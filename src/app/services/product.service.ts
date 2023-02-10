import { HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { cart, order, product } from '../data-type';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
    cartdata = new EventEmitter<product[]|[]>()
  constructor(private http:HttpClient) { }
  addproduct(data:product){
    return this.http.post(`http://localhost:8080/api/products`,data)
    }
    productlist(){
      return this.http.get<product[]>(`http://localhost:8080/api/products`)
    }
    deleteproduct(id:number){
      return this.http.delete(`http://localhost:8080/api/products/${id}`)
    }
    getproduct(id:string){
      return this.http.get<product>(`http://localhost:8080/api/products/${id}`);
    }
    updateproduct(product:product){
      return this.http.put<product>(`http://localhost:8080/api/products/${product.id}`,product)
    }
    popularproducts(){
      return this.http.get<product[]>("http://localhost:8080/api/products/search/limitby?limit=3")
    }
    trendyproducts(){
      return this.http.get<product[]>("http://localhost:8080/api/products/search/limitby?limit=8")
    }
    searchproduct(query:string){
      return this.http.get<product[]>(`http://localhost:8080/api/products/search?query=${query}`);
    }
    localaddtocart(data:product){
      let cartdata= [];
      let localcart = localStorage.getItem('localcart')
      if(!localcart){
        localStorage.setItem('localcart',JSON.stringify([data]));
        this.cartdata.emit([data])
      }else{
        cartdata = JSON.parse(localcart);
        cartdata.push(data);
        localStorage.setItem('localcart',JSON.stringify(cartdata));
        this.cartdata.emit(cartdata)
      }
    }
    removeitemfromcart(productid:number){
      let cartdata = localStorage.getItem('localcart');
      if(cartdata){
        let items:product[]= JSON.parse(cartdata);
        items = items.filter((item:product)=>productid!==item.id)
        localStorage.setItem('localcart',JSON.stringify(items));
        this.cartdata.emit(items)
      }
    }
    addToCart(cartdata:cart){
      //console.log(cartdata + "from service");
      return this.http.post(`http://localhost:8080/api/cart`,cartdata)
    }
    getcartlist(userid:number){
    //console.log(userid);
      return this.http.get<product[]>(`http://localhost:8080/api/cart/byuser?userid=${userid}`,
      {observe:'response'}).subscribe((result)=>{
        if(result && result.body){
          //console.log(JSON.stringify(result)+"from serv getcart");
          this.cartdata.emit(result.body);
        }
      })
    }
    removefromremotecart(cartid:number){
      return this.http.delete<String>(`http://localhost:8080/api/cart/`+cartid)
    }
    currentcart(){
      let userstore = localStorage.getItem('user');
      let userdata = userstore && JSON.parse(userstore);
      return this.http.get<cart[]>(`http://localhost:8080/api/cart/byuser?userid=${userdata.userid}`)
    }
    ordernow(data:order){
      return this.http.post(`http://localhost:8080/api/order`,data);
    }
    orderlist(){
      let userstore = localStorage.getItem('user');
      let userdata = userstore && JSON.parse(userstore);
      console.log(userdata.userid);
      return this.http.get<order[]>(`http://localhost:8080/api/order/byuser?userid=${userdata.userid}`)
    }
    deleteCartItems(cartid:number){
      return this.http.delete(`http://localhost:8080/api/cart/`+cartid).subscribe((result)=>{
        this.cartdata.emit([]);
      })
    }
    filterbygenre(query:String){
      return this.http.get<product[]>(`http://localhost:8080/api/products/search/filterby?genre=${query}`);
    }
    sortbyPrice(){
      return this.http.get<product[]>(`http://localhost:8080/api/products/sort`);
    }
}
