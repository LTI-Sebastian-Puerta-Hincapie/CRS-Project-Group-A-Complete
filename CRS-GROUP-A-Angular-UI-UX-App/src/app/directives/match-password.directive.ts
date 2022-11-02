import { Directive, Input } from '@angular/core';
import { NG_VALIDATORS, Validator, ValidationErrors, FormGroup } from '@angular/forms';
import { CustomvalidationsService } from '../services/customvalidations.service';

@Directive({
  selector: '[appMatchPassword]',
  providers: [{ provide: NG_VALIDATORS, useExisting: MatchPasswordDirective, multi: true }]
})
export class MatchPasswordDirective {

  @Input('appMatchPassword') MatchPassword: string[] = [];

  constructor(private customValidator: CustomvalidationsService) { }

  validate(formGroup: FormGroup): ValidationErrors {
    let result = this.customValidator.MatchPassword(this.MatchPassword[0], this.MatchPassword[1])(formGroup);
    if(result == undefined) return [];
    return result;
  }

}
