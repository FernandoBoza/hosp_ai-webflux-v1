package com.fernandoboza.hospapi.service;

import com.fernandoboza.hospapi.model.Hospital;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HospitalService {

    Mono<Hospital> getHospital(String id);
    Mono<Hospital> updateHospital(String id, Mono<Hospital> hospitalMono);
    Mono<Boolean> deleteHospital(String id);

    Flux<Hospital> getAllHospitals();
    Flux<Hospital> createHospital(Flux<Hospital> hospitalMono);
    Flux<GeoResult<Hospital>> findByLocationNear(double lat, double lng, Distance distance, Mono<Hospital> hospitalMono);
}
