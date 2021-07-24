package com.aisha.adminModule.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisha.adminModule.Entity.Categories;
import com.aisha.adminModule.Repository.CategoryRepository;

@Service
public class CategoryService {
	@Autowired
	private CategoryRepository categoryRepository;
	
	public List<Categories> getAllCategories(){
		return categoryRepository.findAll();
	}
	
	public Optional<Categories> findByCategoryId(String id) {
		return categoryRepository.findById(id);
	}
	
	
	public Categories saveCategory(Categories newCategory) {
		newCategory.setCreated_at(LocalDate.now());
		newCategory.setUpdated_at(LocalDate.now());
		return categoryRepository.saveAndFlush(newCategory);
	}
	
	
	public void deleteCategory(String CatId) {
		categoryRepository.deleteById(CatId);
	}

}
