import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'create-hospital',
  templateUrl: './create-hospital.component.html',
  styleUrls: ['./create-hospital.component.scss']
})
export class CreateHospitalComponent implements OnInit {

  constructor() { }

  public hospitalCreateForm: FormGroup = new FormGroup({
    name: new FormControl(''),
    address: new FormControl(''),
    phone: new FormControl(''),
    zipcode: new FormControl(''),
    city: new FormControl(''),
    state: new FormControl(''),
  });
  public nameModel: string;
  public addressModel: string;
  public phoneModel: string;
  public zipcodeModel: string;
  public cityModel: string;


  ngOnInit() {
    this.hospitalCreateForm.valueChanges.subscribe(form =>{
      this.nameModel = form.name;
      this.addressModel = form.address;
      this.phoneModel = form.phone;
      this.zipcodeModel = form.zipcode;
      this.cityModel = form.city;

      if (form.name){
        let newHospital: object = form.name.split('|');
        this.nameModel = newHospital[0];
        this.addressModel = newHospital[1];
      }

      console.log(this.hospitalCreateForm);
    });
  }

}
