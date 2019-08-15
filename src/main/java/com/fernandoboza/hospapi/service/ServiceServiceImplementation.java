package com.fernandoboza.hospapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ServiceServiceImplementation implements ServiceService {

    private final ReactiveMongoOperations reactiveMongoOperations;

    @Autowired
    public ServiceServiceImplementation(ReactiveMongoOperations reactiveMongoOperations) {
        this.reactiveMongoOperations = reactiveMongoOperations;
    }

    @Override
    public Mono<com.fernandoboza.hospapi.model.Service> getHospitalService(String hosp_id, String service_id) {
        return null;
    }

    @Override
    public Flux<com.fernandoboza.hospapi.model.Service> getHospitalAllServices(String hosp_id) {
        return null;
    }

    @Override
    public Flux<com.fernandoboza.hospapi.model.Service> createService(Flux<com.fernandoboza.hospapi.model.Service> serviceMono, String hosp_id) {
        return null;
    }

    @Override
    public Mono<com.fernandoboza.hospapi.model.Service> updateService(String hosp_id, String id, Mono<com.fernandoboza.hospapi.model.Service> serviceMono) {
        return null;
    }

    @Override
    public Mono<com.fernandoboza.hospapi.model.Service> deleteService(String hosp_id, String id) {
        return null;
    }
}
