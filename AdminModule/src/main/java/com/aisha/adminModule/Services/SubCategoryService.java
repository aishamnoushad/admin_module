package com.aisha.adminModule.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisha.adminModule.Entity.SubCategory;
import com.aisha.adminModule.Entity.SubCategoryIdentity;
import com.aisha.adminModule.Repository.SubCategoryRepository;

@Service
public class SubCategoryService {
	@Autowired
	SubCategoryRepository subCategoryRepository;
	
	
	public List<SubCategory> getAllSubCategory(){
		return subCategoryRepository.findAll();
	}
	
	public Optional<SubCategory> findBySubCategoryIdentity(String catid, String subcatid){
		
		return subCategoryRepository.findById(new SubCategoryIdentity(catid,subcatid));
	}
	
	public SubCategory saveSubCategory(SubCategory newSubCategory) {
		newSubCategory.setCreated_at(LocalDate.now());
		newSubCategory.setUpdated_at(LocalDate.now());
		return subCategoryRepository.saveAndFlush(newSubCategory);
	}
	public void deleteSubCategory(String CatId, String Subcatid) {
		subCategoryRepository.deleteById(new SubCategoryIdentity(CatId, Subcatid));
	}
	public List<SubCategory> getAllSubCategoryOfSelected(String catid ){
		return subCategoryRepository.findAll().stream().filter(t->t.getSubCategoryIdentity().Category_ID.equalsIgnoreCase(catid)).collect(Collectors.toList());
	}
	
}
