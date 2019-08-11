package com.fernandoboza.hospapi;

import com.fernandoboza.hospapi.service.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoReactiveDataAutoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication()
@EnableReactiveMongoRepositories
public class HospApiApplication {

    @Autowired
    HospitalService hospitalService;
    public static void main(String[] args) {
        SpringApplication.run(HospApiApplication.class, args);
    }

}
