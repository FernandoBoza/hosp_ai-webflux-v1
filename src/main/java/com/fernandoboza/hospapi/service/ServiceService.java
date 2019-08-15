package com.fernandoboza.hospapi.service;

import com.fernandoboza.hospapi.model.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ServiceService {

    // GET url/hosp/hosp_id/services/service_id
    Mono<Service> getHospitalService(String hosp_id, String service_id);

    // GET url/hosp/hosp_id/services/service_id
    Flux<Service> getHospitalAllServices(String hosp_id);

    // POST url/hosp/hosp_id/services
    Flux<Service> createService(Flux<Service> serviceMono,String hosp_id);

    // PUT url/hosp/hosp_id/services/service_id
    Mono<Service> updateService(String hosp_id, String id, Mono<Service> serviceMono);

    // DELETE url/hosp/hosp_id/sevices/service_id
    Mono<Service> deleteService(String hosp_id, String id);
}

