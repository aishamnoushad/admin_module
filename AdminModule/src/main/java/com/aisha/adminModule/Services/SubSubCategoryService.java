package com.aisha.adminModule.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisha.adminModule.Entity.SubCategory;
import com.aisha.adminModule.Entity.SubCategoryIdentity;
import com.aisha.adminModule.Entity.SubSubCategory;
import com.aisha.adminModule.Entity.SubSubCategoryIdentity;
import com.aisha.adminModule.Repository.SubSubCategoryRepository;

@Service
public class SubSubCategoryService {
	@Autowired
	SubSubCategoryRepository subSubCategoryRepository;
	
	public List<SubSubCategory> getAllSubSubCategories(){
		return subSubCategoryRepository.findAll();
	}
	
	public Optional<SubSubCategory> findBySubSubCategoryIdentity(String catid, String subcatid, String subsubcatid){
		
		return subSubCategoryRepository.findById( new SubSubCategoryIdentity(catid, subcatid, subsubcatid));
	}

	public SubSubCategory saveSubCategory(SubSubCategory newSubCategory) {
		newSubCategory.setCreated_at(LocalDate.now());
		newSubCategory.setUpdated_at(LocalDate.now());
		return subSubCategoryRepository.saveAndFlush(newSubCategory);
		
	}
	public void deleteSubSubCategory(String catid, String subcatid, String subsubcatid) {
		subSubCategoryRepository.deleteById(new SubSubCategoryIdentity(catid, subcatid, subsubcatid));;
	}
}
