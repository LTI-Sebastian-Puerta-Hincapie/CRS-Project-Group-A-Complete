import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GenerateReportCardComponentComponent } from './generate-report-card-component.component';

describe('GenerateReportCardComponentComponent', () => {
  let component: GenerateReportCardComponentComponent;
  let fixture: ComponentFixture<GenerateReportCardComponentComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ GenerateReportCardComponentComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(GenerateReportCardComponentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
