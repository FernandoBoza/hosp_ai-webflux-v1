//package com.fernandoboza.hospapi.config;
//
//import com.mongodb.ConnectionString;
//import com.mongodb.reactivestreams.client.MongoClient;
//import com.mongodb.reactivestreams.client.MongoClients;
//import com.mongodb.reactivestreams.client.MongoDatabase;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.mongodb.ReactiveMongoDatabaseFactory;
//import org.springframework.data.mongodb.core.ReactiveMongoOperations;
//import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
//import org.springframework.data.mongodb.core.SimpleReactiveMongoDatabaseFactory;
//
//@Configuration
//public class DataConfig {
//
//    private static final String DATABASE_NAME = "hospitals";
//    private static final String  DATABA_URL = "mongodb://<fernando>:<loki1989>@ds261277.mlab.com:61277/hosp-api____";
//
//    MongoClient mongoClient = MongoClients.create(new ConnectionString(DATABA_URL));
//    MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
//
//
//    @Bean
//    public ReactiveMongoDatabaseFactory mongoDatabaseFactory(MongoClient mongoClient){
//        return new SimpleReactiveMongoDatabaseFactory(mongoClient, DATABASE_NAME);
//    }
//
//    @Bean
//    public ReactiveMongoOperations reactiveMongoTemplate(ReactiveMongoDatabaseFactory database){
//        return new ReactiveMongoTemplate(database);
//    }
//}
