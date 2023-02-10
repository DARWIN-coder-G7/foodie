package com.restapi.back.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Products {
	public Products() {
		super();
	}
	public Products(long id, String name, Boolean status, String genre, String lang, double price, String desc,
			String img, String stime) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
		this.genre = genre;
		this.lang = lang;
		this.price = price;
		this.desc = desc;
		this.img = img;
		this.stime = stime;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "pr_id", nullable = false)
	private long id;
	@Column(name = "pr_name", nullable = false)
	private String name;
	@Column(name = "pr_status", nullable = false)
	private Boolean status;
	@Lob
	@Column(name = "pr_type", nullable = false,length = 712)
	private String genre;
	@Column(name = "pr_lang", nullable = false)
	private String lang;
	@Column(name = "pr_price", nullable = false)
	private double price;
	@Lob
	@Column(name = "pr_desc", nullable = false, length = 712)
	private String desc;
	@Lob
	@Column(name = "pr_img", nullable = false)
	private String img;
	@Column(name = "show_time", nullable = false)
	private String stime;
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
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public String getStime() {
		return stime;
	}
	public void setStime(String stime) {
		this.stime = stime;
	}
	
	
}
