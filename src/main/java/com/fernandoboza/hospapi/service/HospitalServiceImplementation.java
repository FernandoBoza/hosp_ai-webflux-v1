package com.fernandoboza.hospapi.service;

import com.fernandoboza.hospapi.model.Hospital;
import com.google.maps.errors.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.ArrayList;

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
    public Flux<Hospital> createHospital(Flux<Hospital> hospitalMono) {
        return hospitalMono.flatMap(hosp -> {
            try {
                return reactiveMongoOperations.save(
                        hosp.createLatCord(hosp));
            } catch (InterruptedException | ApiException | IOException e) {
                e.printStackTrace();
            }
            return Mono.just(hosp);
        });
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

    @Override
    public Flux<GeoResult<Hospital>> findByLocationNear(double lat, double lng, Distance distance, Mono<Hospital> hospitalMono) {
        return null;
//        Point point = new Point(lat, lng);
//        return hospitalMono.flatMap(hospital -> reactiveMongoOperations.geoNear(NearQuery.near(point).maxDistance(distance), Hospital.class)
//                .flatMap(hospitalGeoResult -> {
//                    System.out.println(hospitalGeoResult);
//                    return ;
//                }));
    }

}
