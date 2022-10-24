import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorEnrolledCoursesComponent } from './professor-enrolled-courses.component';

describe('ProfessorEnrolledCoursesComponent', () => {
  let component: ProfessorEnrolledCoursesComponent;
  let fixture: ComponentFixture<ProfessorEnrolledCoursesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfessorEnrolledCoursesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorEnrolledCoursesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
