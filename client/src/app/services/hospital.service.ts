import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";
import { Hospital } from "../models/Hospital";

@Injectable({
  providedIn: 'root'
})
export class HospitalService {

  constructor(private http: HttpClient) {
  }

  private baseUrl: string = "http://localhost:8080";
  private hospitalApi: string = `${this.baseUrl}/hospitals/v1/hosp/`;
  public name: string;
  public lat: number;
  public lng: number;

  public setCord(lat, lng){
    this.lat = lat;
    this.lng = lng;
  }

  public getHospitals(): Observable<Hospital[]> {
    return this.http.get<Hospital[]>(this.hospitalApi);
  }

  public getZipcode(zipcode){
    let zipSearch = `https://maps.googleapis.com/maps/api/geocode/json?address=${zipcode}&key=AIzaSyB7XZM9ZU0jM3SAnFxfLes_8OXOQ0ugI9I`;
    return this.http.get(zipSearch);
  }

  public getCordFromZipcode(zipcode){
    this.getZipcode(zipcode).subscribe(result => {
      let {lat, lng} = result['results'][0].geometry.location;
      this.lat = lat;
      this.lng = lng;
    });
  }

}
