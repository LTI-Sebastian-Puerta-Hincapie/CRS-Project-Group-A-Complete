import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateCoursesComponentComponent } from './update-courses-component.component';

describe('UpdateCoursesComponentComponent', () => {
  let component: UpdateCoursesComponentComponent;
  let fixture: ComponentFixture<UpdateCoursesComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateCoursesComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateCoursesComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
