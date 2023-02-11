package com.restapi.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table( name = "cart_data")
public class CartData {

	public CartData() {
		super();
	}
	public CartData(long id, String name, double price, String genre, Boolean status, String img, String desc,
			String stime, String lang, long productid, long userid, int quantity) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.genre = genre;
		this.status = status;
		this.img = img;
		this.desc = desc;
		this.stime = stime;
		this.lang = lang;
		this.productid = productid;
		this.userid = userid;
		this.quantity = quantity;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cart_id", nullable = false)
	private long id;
	@Column(name = "prd_name", nullable = false)
    private String name;
	@Column(name = "prd_price", nullable = false)
    private double price;
	@Column(name = "prd_genre", nullable = false)
	@Lob
    private String genre;
	@Column(name = "prd_status", nullable = false)
    private Boolean status;
	@Lob
	@Column(name = "prd_image", nullable = false)
    private String img;
	@Lob
	@Column(name = "prd_desc", nullable = false)
    private String desc;
	@Column(name = "prd_stime", nullable = false)
    private String stime;
	@Column(name = "prd_lang", nullable = false)
    private String lang;
	@Column(name = "prd_id", nullable = false)
    private long productid;
	@Column(name = "user_id", nullable = false)
    private long userid;
	@Column(name = "prd_quantity")
    private int quantity;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public long getProductid() {
		return productid;
	}
	public void setProductid(long productid) {
		this.productid = productid;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
