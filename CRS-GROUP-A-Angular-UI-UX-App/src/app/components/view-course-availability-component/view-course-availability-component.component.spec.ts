import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewCourseAvailabilityComponentComponent } from './view-course-availability-component.component';

describe('ViewCourseAvailabilityComponentComponent', () => {
  let component: ViewCourseAvailabilityComponentComponent;
  let fixture: ComponentFixture<ViewCourseAvailabilityComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewCourseAvailabilityComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewCourseAvailabilityComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
