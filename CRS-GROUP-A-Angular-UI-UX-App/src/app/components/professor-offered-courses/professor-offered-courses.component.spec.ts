import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorOfferedCoursesComponent } from './professor-offered-courses.component';

describe('ProfessorOfferedCoursesComponent', () => {
  let component: ProfessorOfferedCoursesComponent;
  let fixture: ComponentFixture<ProfessorOfferedCoursesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfessorOfferedCoursesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorOfferedCoursesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
