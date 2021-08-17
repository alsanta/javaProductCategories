package com.Santana.productsCategories.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="products")
public class Product {
//	--------------------MemberVariables (Column names) Start------------------------//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull
	@Size(min=1, max = 100, message = "The name must be between 1 and 100 characters.")
	private String name;
	
	@NotNull
	@Size(min=1, max = 200, message = "The description must be between 1 and 200 characters.")
	private String description;
	
	@NotNull
	@Min (value = 0, message = "The price must be greater than 0")
	private double price;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createdAt;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedAt;
	
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
	
//	ManyToMany
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
//    	The name is the new table name. Has to be the same on both models
        name = "categories_products", 
//      Which column here it joins.
        joinColumns = @JoinColumn(name = "product_id"),
//      Which column on the other table it joins
        inverseJoinColumns = @JoinColumn(name = "category_id")
    )
//	What This model will reference the new table as
	private List<Category> categories;
//	--------------------End Variables---------------------------------------------------//
	
	
//	--------------------Loaded/Unloaded Constructors------------------------------------//

	public Product() {
	}

	public Product(String name,String description,double price) {
		this.name = name;
		this.description = description;
		this.price = price;
}
	
//	---------------------End Constructors-------------------------------------------------//
	
	
//	---------------------Getters & Setters------------------------------------------------//

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}
	
	
	
//	---------------------End Getters & Setters-------------------------------------------//	
	
	

}
