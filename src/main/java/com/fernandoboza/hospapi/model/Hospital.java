package com.fernandoboza.hospapi.model;

import com.google.maps.errors.ApiException;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.IOException;
import java.util.List;

@Document // Identifies this class as domain object to be persisted to mongodb
public class Hospital {

//    private double createLatCord(String address, String city, String state, String zipcode) throws InterruptedException, ApiException, IOException {
//        GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyB7XZM9ZU0jM3SAnFxfLes_8OXOQ0ugI9I").build();
//        GeocodingResult[] results = GeocodingApi.geocode(context, address + city + state + zipcode).await();
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        return results[0].geometry.location.lat;
//    }

//    private double createLngCord(String address, String city, String state, String zipcode) throws InterruptedException, ApiException, IOException {
//        System.out.println(address);
//        GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyB7XZM9ZU0jM3SAnFxfLes_8OXOQ0ugI9I").build();
//        GeocodingResult[] results = GeocodingApi.geocode(context, address + city + state + zipcode).await();
//        Gson gson = new GsonBuilder().setPrettyPrinting().create();
//        return results[0].geometry.location.lng;
//    }


    private String name;
    private String address;
    private String phone;
    private String zipcode;
    private String city;
    private String state;
    private double lat;
    private double lng;
    private List<Service> services;

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
}
