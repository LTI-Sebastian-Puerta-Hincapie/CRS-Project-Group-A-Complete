import { TestBed } from '@angular/core/testing';

import { SemesterRegistrationServiceService } from './semester-registration-service.service';

describe('SemesterRegistrationServiceService', () => {
  let service: SemesterRegistrationServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SemesterRegistrationServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
