import { Component } from '@angular/core';
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
  public search: string = ""
  public hospitals: Hospital[];
  public title: string = "Hospital services at a glance";
  public searchActive: boolean = false;

  ngOnInit() {
    // this.getAllHospital();
  }

  public submitSearch(input: string) {
    this.search = input;
    this.searchActive = true;
    this.title = "Search"
    let reg = /^\d+$/;

    if (reg.test(input)) {
      console.log('zipcode');
    } else {
      console.log('service');
    }
  }


  public getAllHospital() {
    this.hs.getHospitals().subscribe(result => {
      console.log(result);
      this.hospitals = result;
    });
  }



}
