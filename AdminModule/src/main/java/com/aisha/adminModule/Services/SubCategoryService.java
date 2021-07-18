package com.aisha.adminModule.Services;

import java.util.List;
import java.util.Optional;

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
}
