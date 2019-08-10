package com.fernandoboza.hospapi.service;

import com.fernandoboza.hospapi.model.Hospital;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HospitalService {

    Mono<Hospital> getHospital(String id);
    Mono<Hospital> createHospital(Mono<Hospital> hospitalMono);
    Mono<Hospital> updateHospital(String id, Mono<Hospital> hospitalMono);
    Mono<Boolean> deleteHospital(String id);
    Flux<Hospital> getAllHospitals(); // maybe place in radius
}
