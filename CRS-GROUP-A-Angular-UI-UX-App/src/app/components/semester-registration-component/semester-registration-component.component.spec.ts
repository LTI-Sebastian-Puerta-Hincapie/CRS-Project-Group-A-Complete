import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SemesterRegistrationComponentComponent } from './semester-registration-component.component';

describe('SemesterRegistrationComponentComponent', () => {
  let component: SemesterRegistrationComponentComponent;
  let fixture: ComponentFixture<SemesterRegistrationComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ SemesterRegistrationComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(SemesterRegistrationComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
