import { Component, OnInit } from '@angular/core';
import { PaymentServiceService } from 'src/app/services/payment-service.service';

@Component({
  selector: 'app-payment-component',
  templateUrl: './payment-component.component.html',
  styleUrls: ['./payment-component.component.css']
})
export class PaymentComponentComponent implements OnInit {

  studentID:number = 0;
  paymentMethod:string = "";
  getData:any;
  showStudentBillTable:boolean = false;

  constructor(private _httpService:PaymentServiceService) { }

  ngOnInit(): void {

    // Get saved data from sessionStorage
    let sessionUserId = sessionStorage.getItem("userId");
    console.log(sessionUserId);
    if(sessionUserId != undefined) {
      this.studentID = parseInt(sessionUserId); 
    }

    this.getStudentFee(this.studentID);
  }

  getStudentFee(studentId:number) {

    console.log("Get student fee method");

    this._httpService.getStudentFee(studentId).subscribe((res:any[]) => {
      console.log(res);
      this.getData=res;
    })

    this.showStudentBillTable = !this.showStudentBillTable;
  }

  payStudentFee(studentId:number, paymentMethod:string) {

    console.log("Calling pay student fee method");
    
    this._httpService.payStudentFee(studentId, paymentMethod)
        .subscribe((res:any[]) => {
      console.log(res);
    })
  }
}
