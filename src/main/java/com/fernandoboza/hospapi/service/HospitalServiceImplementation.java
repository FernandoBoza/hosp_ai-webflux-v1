package com.fernandoboza.hospapi.service;

import com.fernandoboza.hospapi.model.Hospital;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Map;

@Service
public class HospitalServiceImplementation implements HospitalService {

    private final ReactiveMongoOperations reactiveMongoOperations;

    private double createLatCord(String address, String city, String state, String zipcode) throws InterruptedException, ApiException, IOException {
        GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyB7XZM9ZU0jM3SAnFxfLes_8OXOQ0ugI9I").build();
        GeocodingResult[] results = GeocodingApi.geocode(context, address + city + state + zipcode).await();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        return results[0].geometry.location.lat;
    }

    private void print(Mono input){
        System.out.println(input);
    }

    @Autowired
    public HospitalServiceImplementation(ReactiveMongoOperations reactiveMongoOperations) {
        this.reactiveMongoOperations = reactiveMongoOperations;
    }

    @Override
    public Mono<Hospital> getHospital(String id) {
        return reactiveMongoOperations.findById(id, Hospital.class);
    }

    @Override
    public Mono<Hospital> createHospital(Mono<Hospital> hospitalMono) {
//        Mono lats = hospitalMono.map(hospital -> {
//            System.out.println(hospital.getName());
//            System.out.println("hospital.getName()");
//            return hospital.getName();
//        });

//        hospitalMono.delayUntil()
//        print(lats);
        return reactiveMongoOperations.save(hospitalMono);
    }

    @Override
    public Mono<Hospital> updateHospital(String id, Mono<Hospital> hospitalMono) {
//        return reactiveMongoOperations.save(hospitalMono);

//    OR WE CAN SPECIFY FIELDS LIKE SO I.E UPDATE PHONE
        return hospitalMono.flatMap(hospital -> reactiveMongoOperations.findAndModify(
                Query.query(Criteria.where("id").is(id)),
                Update.update("phone", hospital.getPhone()), Hospital.class
                ).flatMap(results -> {
                    results.setPhone(hospital.getPhone());
                    return Mono.just(results);
                })
        );
    }

    @Override
    public Mono<Boolean> deleteHospital(String id) {
        return reactiveMongoOperations.remove(
                Query.query(Criteria.where("id").is(id)), Hospital.class)
        .flatMap(deleteResult -> Mono.just(deleteResult.wasAcknowledged()));
    }

    @Override
    public Flux<Hospital> getAllHospitals() {
        return reactiveMongoOperations.findAll(Hospital.class);
    }
}
