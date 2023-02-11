package com.restapi.back.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.restapi.back.entity.Products;
import com.restapi.back.repository.Productrepo;
import com.restapi.back.service.ProductService;
import com.restapi.back.exception.ResourceNotFoundException;
@Service
public class Productserv implements ProductService {
    public Productserv(Productrepo prodrepo) {
		super();
		this.prodrepo = prodrepo;
	}
	private Productrepo prodrepo;
	@Override
	public Products saveProducts(Products products) {
		
		return prodrepo.save(products);
	}
	@Override
	public List<Products> getAllProducts() {
		
		return prodrepo.findAll();
	}
	@Override
	public Products getProductsbyId(long id) {
		//Optional<Products> product = prodrepo.findById(id);
		return prodrepo.findById(id).orElseThrow(() -> 
		                             new ResourceNotFoundException("Products","id",id));
	}
	@Override
	public Products updateProducts(Products products, long id) {
		Products existingproduct = prodrepo.findById(id).orElseThrow(() -> 
        new ResourceNotFoundException("Products","id",id));
		existingproduct.setDesc(products.getDesc());
		existingproduct.setGenre(products.getGenre());
		existingproduct.setStatus(products.getStatus());
		existingproduct.setImg(products.getImg());
		existingproduct.setLang(products.getLang());
		existingproduct.setName(products.getName());
		existingproduct.setPrice(products.getPrice());
		existingproduct.setStime(products.getStime());
		prodrepo.save(existingproduct);
		return existingproduct;
	}
	@Override
	public void deleteProduct(long id) {
		prodrepo.findById(id).orElseThrow(() -> 
                       new ResourceNotFoundException("Products","id",id));
		prodrepo.deleteById(id);
		
	}
	@Override
	public List<Products> searcProducts(String query) {
		
		List<Products> products = prodrepo.searchPrroducts(query);
		return products;
	}
	@Override
	public List<Products> filterProducts(String genre) {
		//System.out.println(genre);
		List<Products> products = prodrepo.filterbytype(genre);
		return products;
	}
	@Override
	public List<Products> limitbyProducts(int nos) {
		List<Products> products = prodrepo.limitProducts(nos);
		return products;
	}
	@Override
	public List<Products> sortbyprice() {
		List<Products> products= prodrepo.sortProducts();
		return products;
	}
	@Override
	public List<Products> showalltocustopmer() {
		List<Products> products = prodrepo.showallforcustomerProducts();
		return products;
	}

}
