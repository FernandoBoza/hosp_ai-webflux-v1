package com.fernandoboza.hospapi.controller;

import com.fernandoboza.hospapi.model.Hospital;
import com.fernandoboza.hospapi.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController // Controller and ResponseBody Annotations together
@RequestMapping("/hospitals/v1/hosp/") // Create a base string that the endpoint is built upon
@CrossOrigin // For DEV Angular and Spring app locally REMOVE FOR PRODUCTION
public class HospitalController {
    private final HospitalService hospitalService;

    @Autowired
    public HospitalController(HospitalService hospitalService) {
        this.hospitalService = hospitalService;
    }

    // Path variable and this end point returns an JSON
    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<Hospital> getHospital(@PathVariable String id) {
        return hospitalService.getHospital(id);
    }

    @PostMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<Hospital> createHospital(@RequestBody Mono<Hospital> hospital) {
        return hospitalService.createHospital(hospital);
    }

    @PutMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Mono<Hospital> updateHospital(@PathVariable String id, @RequestBody Mono<Hospital> hospital) {
        return hospitalService.updateHospital(id, hospital);
    }

    @DeleteMapping(path = "{id}")
    public Mono<Boolean> deleteHospital(@PathVariable String id) {
        return hospitalService.deleteHospital(id);
    }

    @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Flux<Hospital> getAllHospitals() {
        return hospitalService.getAllHospitals();
    }
}
