package com.fernandoboza.hospapi.service;

import com.fernandoboza.hospapi.model.Hospital;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.data.geo.Point;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HospitalService {

    Mono<Hospital> getHospital(String id);
    Mono<Hospital> createHospital(Mono<Hospital> hospitalMono);
    Mono<Hospital> updateHospital(String id, Mono<Hospital> hospitalMono);
    Mono<Boolean> deleteHospital(String id);
    Flux<Hospital> getAllHospitals(); // maybe place in radius
    Flux<GeoResult<Hospital>> findByLocationNear(double lat, double lng, Distance distance, Mono<Hospital> hospitalMono);
}
