package com.fernandoboza.hospapi.controller;

import com.fernandoboza.hospapi.model.Hospital;
import com.fernandoboza.hospapi.model.Service;
import com.fernandoboza.hospapi.service.HospitalService;
import com.fernandoboza.hospapi.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.data.geo.GeoResult;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/hospitals/v1/service/")
@CrossOrigin

public class ServicesController {
    private final ServiceService serviceService;

    @Autowired
    public ServicesController(ServiceService serviceService) {
        this.serviceService = serviceService;
    }


}
