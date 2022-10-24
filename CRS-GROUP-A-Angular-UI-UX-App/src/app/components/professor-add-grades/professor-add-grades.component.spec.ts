import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorAddGradesComponent } from './professor-add-grades.component';

describe('ProfessorAddGradesComponent', () => {
  let component: ProfessorAddGradesComponent;
  let fixture: ComponentFixture<ProfessorAddGradesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfessorAddGradesComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorAddGradesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
