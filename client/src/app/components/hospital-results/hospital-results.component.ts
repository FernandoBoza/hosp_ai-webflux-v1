import {Component, Input, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Hospital} from "../../models/Hospital";
import {HospitalService} from "../../services/hospital.service";

@Component({
  selector: 'hospital-results',
  templateUrl: './hospital-results.component.html',
  styleUrls: ['./hospital-results.component.scss']
})
export class HospitalResultsComponent {

  constructor(private http: HttpClient, private hs: HospitalService) {
  }

  @Input() results;
  public selected: number = -1;


  public fetchCordFromAddress(address) {
    let base = "https://maps.googleapis.com/maps/api/geocode/json?address=";
    let footer = "&key=AIzaSyB7XZM9ZU0jM3SAnFxfLes_8OXOQ0ugI9I";
    let addy = (address.address.split(' ').join('+'));
    let city = (address.city);
    let state = (address.state);
    let hospitalCord = `${base} + ${addy} + ${city} + ${state} + ${footer}`;
    return this.http.get(hospitalCord);
  }

  public selectHosp(address, index) {
    this.selected = index;
    this.fetchCordFromAddress(address).subscribe(result => {
      let {lat, lng} = result['results'][0].geometry.location;
      this.setCord(lat, lng)
    });
  }

  public setCord(lat, lng) {
    return this.hs.setCord(lat, lng);
  }

  // public selectHosp(hosp, index) {
  //   this.selected = index;
  //   this.setCord(hosp.lat, hosp.lng)
  // }

}
