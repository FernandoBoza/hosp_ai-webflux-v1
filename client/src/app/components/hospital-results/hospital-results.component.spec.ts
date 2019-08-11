import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { HospitalResultsComponent } from './hospital-results.component';

describe('HospitalResultsComponent', () => {
  let component: HospitalResultsComponent;
  let fixture: ComponentFixture<HospitalResultsComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ HospitalResultsComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(HospitalResultsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
