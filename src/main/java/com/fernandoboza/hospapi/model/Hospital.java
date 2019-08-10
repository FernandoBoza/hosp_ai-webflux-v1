package com.fernandoboza.hospapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document // Identifies this class as domain object to be persisted to mongodb
public class Hospital {
    private String name;
    private String address;
    private String phone;
    private String zipcode;
    private String city;
    private String state;
    private List<Service> services;

    @Id
    private String id;

    public Hospital() {
    }

    public Hospital(String name, String address, String phone, String zipcode, String city, String state) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.zipcode = zipcode;
        this.city = city;
        this.state = state;
    }

    //    name Getter and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getId() {
        return id;
    }
}
