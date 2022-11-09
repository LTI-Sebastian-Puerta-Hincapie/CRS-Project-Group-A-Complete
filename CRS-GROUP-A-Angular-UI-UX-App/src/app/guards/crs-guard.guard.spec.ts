import { TestBed } from '@angular/core/testing';

import { CrsGuardGuard } from './crs-guard.guard';

describe('CrsGuardGuard', () => {
  let guard: CrsGuardGuard;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    guard = TestBed.inject(CrsGuardGuard);
  });

  it('should be created', () => {
    expect(guard).toBeTruthy();
  });
});
