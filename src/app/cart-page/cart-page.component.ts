import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { cart, pricesummary, product } from '../data-type';
import { ProductService } from '../services/product.service';

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css']
})
export class CartPageComponent implements OnInit {
  cartdata:cart[]|undefined;
  cartprod:product|undefined;
  cartsummary:pricesummary={
    price:0,
    dicount:0,
    tax:0,
    delivery:0,
    total:0
}
  constructor(private product:ProductService,private router:Router){}
 ngOnInit(): void {
   this.product.currentcart().subscribe((result)=>{
     this.cartdata=result;
     let price=0;
     result.forEach((item)=>{
      if(item.quantity){price = price+(+item.price* +item.quantity)}
     })
     this.cartsummary.price=price;
     this.cartsummary.dicount= price/10;
     this.cartsummary.tax= price/10;
     this.cartsummary.delivery=100;
     this.cartsummary.total=price+(price/10)+100-(price/10);

   })
 }
 checkout(){
  this.router.navigate(['/checkout'])
 }
 removefromcart(id:number){
  if(!localStorage.getItem('user')){
  this.product.removeitemfromcart(id);
 }else{
  this.cartdata && this.product.removefromremotecart(id)
  .subscribe((result)=>{
    let user = localStorage.getItem('user');
      let userid = user && JSON.parse(user).userid;
    this.product.getcartlist(userid);
    this.product.currentcart().subscribe((result)=>{
      this.cartdata=result;})
  })
 }
 
}
}
