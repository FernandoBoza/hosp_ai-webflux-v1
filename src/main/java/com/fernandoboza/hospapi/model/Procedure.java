package com.fernandoboza.hospapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Procedure {
    private String name;
    private double price;
    private String hosp_id;
    @Id
    private String id;

    public Procedure() {
    }

    public Procedure(String name, double price, String hosp_id) {
        this.name = name;
        this.price = price;
        this.hosp_id = hosp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getHosp_id() {
        return hosp_id;
    }

    public void setHosp_id(String hosp_id) {
        this.hosp_id = hosp_id;
    }

    public String getId() {
        return id;
    }
}
