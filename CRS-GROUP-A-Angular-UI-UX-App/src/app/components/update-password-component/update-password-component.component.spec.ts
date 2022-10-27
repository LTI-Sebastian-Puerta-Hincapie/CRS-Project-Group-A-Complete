import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdatePasswordComponentComponent } from './update-password-component.component';

describe('UpdatePasswordComponentComponent', () => {
  let component: UpdatePasswordComponentComponent;
  let fixture: ComponentFixture<UpdatePasswordComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdatePasswordComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdatePasswordComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
