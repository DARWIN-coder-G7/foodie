import { HttpClient } from '@angular/common/http';
import { EventEmitter, Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { login, signup } from '../data-type';

@Injectable({
  providedIn: 'root'
})
export class UserService {
   invaliduser = new EventEmitter<boolean>(false)
  constructor(private http:HttpClient,private router:Router) { }
  usersignup(user:signup){
    this.http.post('http://localhost:8080/api/user',user,
    {observe:'response'}).subscribe((result)=>{
      if(result){
        localStorage.setItem('user',JSON.stringify(result.body))
        this.router.navigate(['/']);
      }
    })
  }
  userlogin(data:login){
    this.http.get<signup[]>(`http://localhost:8080/api/user/${data.username}/${data.userpass}`,
    {observe:'response'}).subscribe((result)=>{
      if(result ){
        console.log(result);
        localStorage.setItem('user',JSON.stringify(result.body))
        this.router.navigate(['/']);
        this.invaliduser.emit(false)
      }else{this.invaliduser.emit(true)}
    })
  }
  userauthreload(){
    if(localStorage.getItem('user')){
      this.router.navigate(['/'])
    }
  }
}
