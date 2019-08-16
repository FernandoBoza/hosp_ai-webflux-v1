package com.fernandoboza.hospapi.model;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.io.IOException;

@Document // Identifies this class as domain object to be persisted to mongodb
public class Hospital {


    private String name;
    private String address;
    private String phone;
    private String zipcode;
    private String city;
    private String state;
    private double lat;
    private double lng;
    private Flux<Procedure> services;

    @Id
    private String id;

    //
    public Hospital() {
    }

    public Hospital(String name, String address, String phone, String zipcode, String city, String state, double lat, double lng) throws InterruptedException, ApiException, IOException {
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
        this.lat = lng;
        this.lng = lng;
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

    public Flux<Procedure> getProcedure() {
        return services;
    }

    public void setProcedure(Flux<Procedure> services) {
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

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }

    public String getId() {
        return id;
    }

    public Mono<Hospital> createLatCord(Hospital hosp) throws InterruptedException, ApiException, IOException {
        GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyB7XZM9ZU0jM3SAnFxfLes_8OXOQ0ugI9I").build();
        GeocodingResult[] results = GeocodingApi.geocode(context, hosp.getAddress() + hosp.getCity() + hosp.getState() + hosp.getZipcode()).await();
        hosp.setLat(results[0].geometry.location.lat);
        hosp.setLng(results[0].geometry.location.lng);
        return Mono.just(hosp);
    }


}
