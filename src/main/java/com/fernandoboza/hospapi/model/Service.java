package com.fernandoboza.hospapi.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Service {
    private String name;
    private double price;
    private String hosp_id;
}
