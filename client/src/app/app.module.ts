import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from "@angular/forms";
import { AgmCoreModule } from "@agm/core";
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from "@angular/common/http";
import { CreateHospitalComponent } from './pages/create-hospital/create-hospital.component';
import { HospitalResultsComponent } from './components/hospital-results/hospital-results.component';
import { SearchComponent } from './components/search/search.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateHospitalComponent,
    HospitalResultsComponent,
    SearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule,
    FormsModule,
    AgmCoreModule.forRoot({
      apiKey: "AIzaSyB7XZM9ZU0jM3SAnFxfLes_8OXOQ0ugI9I"
    })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
