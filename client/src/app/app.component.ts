import {Component} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";
import {HospitalService} from "./services/hospital.service";
import {Hospital} from "./models/Hospital";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {

  constructor(private hs: HospitalService) {}
  public lat: number = 25.7308;
  public lng: number = -80.3853;
  public search: string;
  public hospitals: Hospital[];

  ngOnInit(){
    this.getAllHospital();
  }

  public submitSearch(){
    console.log(this.search);
  }

  public getAllHospital(){
    this.hs.getHospitals().subscribe( result => {
      console.log(result);
      this.hospitals = result;
    });
  }

}
