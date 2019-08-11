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

  public getCord(){
    return {
      "lat" : this.lat,
      "lng" : this.lng
    }
  }

  public getHospitals(): Observable<Hospital[]> {
    return this.http.get<Hospital[]>(this.hospitalApi);
  }

}
