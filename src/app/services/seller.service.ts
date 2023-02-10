import { EventEmitter, Injectable } from '@angular/core';
import{HttpClient} from '@angular/common/http';
import { adminlogin, login, signup } from '../data-type';
import { Router } from '@angular/router';
import { BehaviorSubject } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class SellerService {
    issellerloggedin = new BehaviorSubject<boolean>(false);
    isloginerror = new EventEmitter<boolean>(false)
    constructor(private http:HttpClient,private router:Router) { }
  userSignup(data:signup){
     this.http.post('http://localhost:3000/seller',
    data,
    {observe:'response'}).subscribe((result)=>{
     if(result){
     
      localStorage.setItem('seller',JSON.stringify(result.body))
      this.router.navigate(['seller-home'])
     }
    });
    
  }
  reloadseller(){
    if(localStorage.getItem('seller')){
      this.issellerloggedin.next(true)
      this.router.navigate(['seller-home'])
    }
  }
  userLogin(data:adminlogin){
    this.http.get(`http://localhost:8080/api/admin/${data.adminName}/${data.adminKey}`,
    {observe:'response'}).subscribe((result:any)=>{
      console.log(result);
    if(result && result.body )
    {
      this.isloginerror.emit(false)
      localStorage.setItem('seller',JSON.stringify(result.body))
      this.router.navigate(['seller-home'])
    }else{
      console.warn("login failed");
      this.isloginerror.emit(true)
    }
    })
    console.warn(data)
  }
  changepin(data:any){
    return this.http.put(`http://localhost:8080/api/admin/${data.adminId}`,data)
  }
}
