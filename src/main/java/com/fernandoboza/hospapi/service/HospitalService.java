package com.fernandoboza.hospapi.service;

import com.fernandoboza.hospapi.model.Hospital;
import com.google.maps.errors.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import com.fernandoboza.hospapi.model.Procedure;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static com.mongodb.client.model.Aggregates.unwind;
import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.query.Criteria.where;


@org.springframework.stereotype.Service
public class HospitalService {

    private final ReactiveMongoOperations reactiveMongoOperations;

    @Autowired
    public HospitalService(ReactiveMongoOperations reactiveMongoOperations) {
        this.reactiveMongoOperations = reactiveMongoOperations;
    }

    public Mono<Hospital> getHospital(String id) {
        return reactiveMongoOperations.findById(id, Hospital.class);
    }

    public Flux<Hospital> getAllHospitals() {
        return reactiveMongoOperations.findAll(Hospital.class);
    }

    public Flux<Hospital> createHospital(Flux<Hospital> hospitalMono) {
        return hospitalMono.flatMap(hosp -> {
            try {
                return reactiveMongoOperations.save(hosp.createLatCord(hosp));
            } catch (InterruptedException | ApiException | IOException e) {
                e.printStackTrace();
            }
            return Mono.just(hosp);
        });
    }

    public Mono<Hospital> updateHospital(String id, Mono<Hospital> hospitalMono) {
        return hospitalMono.flatMap(hospital -> reactiveMongoOperations.findAndModify(
                Query.query(where("id").is(id)),
                Update.update("phone", hospital.getPhone()), Hospital.class
                ).flatMap(results -> {
                    results.setPhone(hospital.getPhone());
                    return Mono.just(results);
                })
        );
    }

    public Mono<Hospital> createProcedure(List<Procedure> procedureMono, String hosp_id) {
        return getHospital(hosp_id).flatMap(hospital -> reactiveMongoOperations.findAndModify(
                Query.query(where("id").is(hosp_id)),
                Update.update("procedure", procedureMono), Hospital.class
                ).flatMap(results -> {
                    results.setProcedure(procedureMono);
                    return Mono.just(results);
                })
        );
    }

    public Mono<Procedure> getProcedureById(String hosp_id, String proc_id) {
        return getHospital(hosp_id).flatMap(hospital -> reactiveMongoOperations.findById(proc_id, Procedure.class,"hospital"));
    }


    public Mono<Boolean> deleteHospital(String id) {
        return reactiveMongoOperations.remove(
                Query.query(where("id").is(id)), Hospital.class)
                .flatMap(deleteResult -> Mono.just(deleteResult.wasAcknowledged()));
    }

    public Flux<GeoResult<Hospital>> findByLocationNear(double lat, double lng, Distance distance) {
        Point point = new Point(lat, lng);
        return reactiveMongoOperations.geoNear(NearQuery.near(point).maxDistance(distance), Hospital.class);
    }

}
