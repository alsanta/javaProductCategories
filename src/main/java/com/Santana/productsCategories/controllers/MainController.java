package com.Santana.productsCategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Santana.productsCategories.models.Category;
import com.Santana.productsCategories.models.Product;
import com.Santana.productsCategories.services.AppService;

@Controller
public class MainController {
//	--------Letting the controller know about the AppService-------//
	
	private final AppService appService;
	
//	--------Letting the controller know about the AppService End---//

//	Constructor for the AppService
	public MainController(AppService appservice) {
		this.appService = appservice;
	}
	
//	Main Dashboard showing the 2 tables
	@GetMapping("/")
	public String dashboard(Model model) {
		List<Product> allProducts = this.appService.getAllProducts();
		List<Category> allCategories = this.appService.getAllCategories();
		model.addAttribute("allProducts", allProducts);
		model.addAttribute("allCategories", allCategories);
		return "home.jsp";
	}
	
//	-----------------------New Products----------------//
	@GetMapping("/product")
	public String createProduct(@ModelAttribute("products") Product products){
		return "index.jsp";
	}
	
	@PostMapping("/new/products")
	public String newProduct(@Valid @ModelAttribute("products") Product products, BindingResult result) {
		if(result.hasErrors()) {
			return "index.jsp";
		}
		this.appService.createProduct(products);
		return "redirect:/";
	}
//	-----------------------New Products End------------//
	
	
//	-----------------------New Categories--------------//


	@GetMapping("/category")
	public String createCategory(@ModelAttribute("category") Category category){
		return "newcat.jsp";
	}
	
	@PostMapping("/new/category")
	public String newCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
		if(result.hasErrors()) {
			return "newcat.jsp";
		}
		this.appService.createCategory(category);
		return "redirect:/";
	}
	
//	-----------------------New Categories End---------//
	
	
//	----------------------Displays & Adding-----------//
	
	@GetMapping("/product/{id}")
		public String showSingleProduct(@PathVariable("id") Long productId, Model model){
			Product singleProduct = this.appService.getProductById(productId);
			List<Category> allCategories = this.appService.getAllCategories();
			model.addAttribute("allCategories", allCategories);
			model.addAttribute("singleProduct", singleProduct);
			return "displayProduct.jsp";
		}
	
	@PostMapping("/addCategory/{id}")
	public String addCategory(@PathVariable("id") Long product_id, @RequestParam("category_id") Long catergory_id) {
		Product product = this.appService.getProductById(product_id);
		Category category = this.appService.getCategoryById(catergory_id);
		List<Category> categories = product.getCategories();
		categories.add(category);
		product.setCategories(categories);
		this.appService.updateProduct(product);
		
		return"redirect:/product/" + product_id;
	}
	
	@GetMapping("/category/{id}")
	public String showSingleCategory(@PathVariable("id") Long categoryId, Model model){
		Category singleCategory = this.appService.getCategoryById(categoryId);
		List<Product> allProducts = this.appService.getAllProducts();
		model.addAttribute("allProducts", allProducts);
		model.addAttribute("singleCategory", singleCategory);
		return "displayCategory.jsp";
	}
	
	@PostMapping("/addProduct/{id}")
	public String addProduct(@PathVariable("id") Long category_id, @RequestParam("product_id") Long product_id) {
		Product product = this.appService.getProductById(product_id);
		Category category = this.appService.getCategoryById(category_id);
		List<Product> products = category.getProducts();
		products.add(product);
		category.setProducts(products);
		this.appService.updateCategory(category);
		
		return"redirect:/category/" + category_id;
	}

	
}