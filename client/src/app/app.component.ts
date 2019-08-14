import {Component} from '@angular/core';
import {HospitalService} from "./services/hospital.service";
import {Hospital} from "./models/Hospital";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  constructor(private hs: HospitalService) {
  }

  public search: string = "";
  public hospitals: Hospital[];
  public title: string = "Hospital services at a glance";
  public searchActive: boolean = false;

  get lat() {
    return this.hs.lat;
  }

  get lng() {
    return this.hs.lng;
  }

  public submitSearch(input: string) {
    this.search = input;
    this.searchActive = true;
    this.title = "Search";
    let reg = /^\d+$/;

    if (reg.test(input)) {
      this.getCordFromZipcode(input);
      this.getAllHospital();
    } else {
      console.log('service');
    }
  }

  public getCordFromZipcode(search) {
    return this.hs.getCordFromZipcode(search)
  }


  public getAllHospital() {
    this.hs.getHospitals().subscribe(result => {
      this.hospitals = result;
    });
  }

}
