import { JsonPipe } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Route, Router } from '@angular/router';
import { cart, order } from '../data-type';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-checkout',
  templateUrl: './checkout.component.html',
  styleUrls: ['./checkout.component.css']
})
export class CheckoutComponent implements OnInit {
  totalprice:number|undefined;
  cartdata:cart[]|undefined;
  ordermsg:String|undefined;
    constructor( private product:ProductService,private roter:Router){}
  ngOnInit(): void {
    this.product.currentcart().subscribe((result)=>{
      this.cartdata = result;
      let price=0;
      result.forEach((item)=>{
       if(item.quantity){price = price+(+item.price* +item.quantity)}
      })
     
      this.totalprice=price+(price/10)+100-(price/10);
     console.log(this.totalprice)
    })
  }
  ordernow(data:{email:string,address:string,contact:string}){
    let user = localStorage.getItem('user');
    let userid = user && JSON.parse(user).userid;
    if(this.totalprice){
      let orderdata:order = {
        ...data,
        totalprice:this.totalprice,
        userid,id:undefined
      }
       this.cartdata?.forEach((item)=>{
        setTimeout(()=>{
          item.id && this.product.deleteCartItems(item.id);
        },700)
       })
      this.product.ordernow(orderdata).subscribe((result)=>{
        if(result){
          this.ordermsg="order Placed"
        setTimeout(()=>{
          this.ordermsg=undefined
          this.roter.navigate(['/myorders'])
        },4000)
      }
      })
    }
  }
}
