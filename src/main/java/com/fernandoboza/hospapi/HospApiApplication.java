package com.fernandoboza.hospapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoReactiveDataAutoConfiguration;

@SpringBootApplication(exclude = {MongoReactiveDataAutoConfiguration.class, MongoDataAutoConfiguration.class})
public class HospApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospApiApplication.class, args);
    }

}
