package com.Santana.productsCategories.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Santana.productsCategories.models.Category;
import com.Santana.productsCategories.models.Product;
import com.Santana.productsCategories.repositories.CategoryRepository;
import com.Santana.productsCategories.repositories.ProductRepository;

@Service
public class AppService {
//	--------Letting the Service know of the Repos------------//
	
	private final ProductRepository productRepo;
	private final CategoryRepository categoryRepo;
	
//	--------Letting the Service know of the Repos End--------//
	
	
//	Constructor for the Repos
	
	public AppService(ProductRepository productRepo,CategoryRepository categoryRepo) {
		this.productRepo = productRepo;
		this.categoryRepo = categoryRepo;
	}
	
	
//	-----------------------------Methods--------------------//

//	Make a new item in the list
	public Product createProduct(Product p) {
		return this.productRepo.save(p);
	}
	
	public Category createCategory(Category c) {
		return this.categoryRepo.save(c);
	}
	
	public List<Product> getAllProducts(){
		return (List<Product>)this.productRepo.findAll();
	}
	
	public List<Category> getAllCategories(){
		return (List<Category>)this.categoryRepo.findAll();
	}
	
	public Product getProductById(Long id) {
		return this.productRepo.findById(id).orElse(null);
	}
	
	public Category getCategoryById(Long id) {
		return this.categoryRepo.findById(id).orElse(null);
	}
	
	public void updateProduct(Product p) {
		this.productRepo.save(p);
	}
	
	public void updateCategory(Category c) {
		this.categoryRepo.save(c);
	}
//	-----------------------------Methods End----------------//

}
