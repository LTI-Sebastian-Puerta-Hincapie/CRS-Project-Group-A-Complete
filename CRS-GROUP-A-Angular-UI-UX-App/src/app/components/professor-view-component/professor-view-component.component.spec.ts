import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProfessorViewComponentComponent } from './professor-view-component.component';

describe('ProfessorViewComponentComponent', () => {
  let component: ProfessorViewComponentComponent;
  let fixture: ComponentFixture<ProfessorViewComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProfessorViewComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProfessorViewComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
