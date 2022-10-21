import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AddGradesComponentComponent } from './add-grades-component.component';

describe('AddGradesComponentComponent', () => {
  let component: AddGradesComponentComponent;
  let fixture: ComponentFixture<AddGradesComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AddGradesComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AddGradesComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
