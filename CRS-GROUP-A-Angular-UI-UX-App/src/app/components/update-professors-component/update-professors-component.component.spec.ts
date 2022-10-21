import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateProfessorsComponentComponent } from './update-professors-component.component';

describe('UpdateProfessorsComponentComponent', () => {
  let component: UpdateProfessorsComponentComponent;
  let fixture: ComponentFixture<UpdateProfessorsComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateProfessorsComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateProfessorsComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
