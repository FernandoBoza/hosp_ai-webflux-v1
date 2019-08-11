import { Component } from '@angular/core';
import { FormControl, FormGroup } from "@angular/forms";
import { HospitalService } from "./services/hospital.service";
import { Hospital } from "./models/Hospital";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  constructor(private hs: HospitalService) { }
  public lat: number = 25.7308;
  public lng: number = -80.3853;
  public lattwo: number = 25.8308;
  public lngtwo: number = -80.4853;
  public search: string;
  public hospitals: Hospital[];
  public title: string = "Hospital services at a glance";
  public searchActive: boolean = false;

  ngOnInit() {
    // this.getAllHospital();
  }

  public submitSearch() {
    var reg = /^\d+$/;
    this.title = "Search"
    this.searchActive = true;


    if (reg.test(this.search)) {
    }
    else {

    }
  }

  public getAllHospital() {
    this.hs.getHospitals().subscribe(result => {
      console.log(result);
      this.hospitals = result;
    });
  }

}
