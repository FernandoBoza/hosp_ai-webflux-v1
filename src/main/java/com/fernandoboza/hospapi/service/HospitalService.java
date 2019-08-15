package com.fernandoboza.hospapi.service;

import com.fernandoboza.hospapi.model.Hospital;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface HospitalService {

    // GET url/hosp/hosp_id
    Mono<Hospital> getHospital(String id);

    // GET url/hosp/
    Flux<Hospital> getAllHospitals();

    // POST url/hosp/hosp_id
    Flux<Hospital> createHospital(Flux<Hospital> hospitalMono);

    // PUT url/hosp/hosp_id
    Mono<Hospital> updateHospital(String id, Mono<Hospital> hospitalMono);

    // DELETE url/hosp/hosp_id
    Mono<Boolean> deleteHospital(String id);

    // GET url/hosp/lat/lng/distance
    Flux<GeoResult<Hospital>> findByLocationNear(double lat, double lng, Distance distance);
}

