package com.Santana.productsCategories.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Santana.productsCategories.models.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long>{

}
