package com.fernandoboza.hospapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication()
@EnableReactiveMongoRepositories
public class HospApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospApiApplication.class, args);
    }

}
