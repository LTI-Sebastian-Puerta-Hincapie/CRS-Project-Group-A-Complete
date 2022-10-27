import { TestBed } from '@angular/core/testing';

import { UpdatePasswordServiceService } from './update-password-service.service';

describe('UpdatePasswordServiceService', () => {
  let service: UpdatePasswordServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(UpdatePasswordServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
