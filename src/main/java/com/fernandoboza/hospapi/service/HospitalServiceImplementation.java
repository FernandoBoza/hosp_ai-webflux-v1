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
        return hospitalMono.flatMap(hosp ->
                {
                    try {
                        return hosp.createLatCord(hosp);
                    } catch (InterruptedException | ApiException | IOException e) {
                        e.printStackTrace();
                    }
                    return Mono.just(hosp);
                }
        );
    }

    @Override
    public Mono<Hospital> updateHospital(String id, Mono<Hospital> hospitalMono) {
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
