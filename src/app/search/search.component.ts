import { Component, OnInit } from '@angular/core';
import {ActivatedRoute} from '@angular/router';
import { product } from '../data-type';
import { ProductService } from '../services/product.service';
@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent implements OnInit{
  searchresult:product[]|any;
  p:number=1;
  nodata:string = '';
  constructor(private activeroute:ActivatedRoute,private product:ProductService){}
  ngOnInit(): void {
    let query = this.activeroute.snapshot.paramMap.get('query');
    query && this.product.searchproduct(query).subscribe((result)=>{
      if(result){
        this.searchresult = result;
      }else{
        this.nodata="no data matches your search"
      }
      
    })
  }
  Filterchange(event:Event){
    const filvalue = (event.target as HTMLInputElement).value;
    this.product.filterbygenre(filvalue).subscribe((res)=>{
      if(res){this.searchresult=res;}
      
    })
                          
  }
  sortbyPrice(){
    this.product.sortbyPrice().subscribe((x)=>{
      if(x){this.searchresult=x;}
    })
  }
}
