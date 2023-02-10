export interface signup{
    username:string,
    useremail:string,
    userpass:string
}
export interface login{
    userid:undefined|number,
    username:string,
    useremail:string,
    userpass:string
}
export interface adminlogin{
    adminId:undefined|number,
    adminName:string,
    adminKey:string
}
export interface product {
    name:string,
    price:number,
    genre:string,
    status:string,
    img:string,
    desc:string,
    id:number,
    lang:string,
    stime:string,
    quantity:undefined|number,
    productid:undefined|number,
    userid:number|undefined

}
export interface cart{
    name:string,
    price:number,
    genre:string,
    status:string,
    img:string,
    desc:string,
    lang:string,
    stime:string,
    id:number|undefined,
    quantity:undefined|number,
    productid:number|undefined,
    userid:number|undefined
}
export interface pricesummary{
    price:number,
    dicount:number,
    tax:number,
    delivery:number,
    total:number
}
export interface order{
    email:string,
    address:string,
    contact:string,
    totalprice:number,
    userid:number,
    id:number|undefined
}