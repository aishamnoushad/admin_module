package com.aisha.adminModule.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisha.adminModule.Entity.SubSubCategory;
import com.aisha.adminModule.Repository.SubSubCategoryRepository;

@Service
public class SubSubCategoryService {
	@Autowired
	SubSubCategoryRepository subSubCategoryRepository;
	
	public List<SubSubCategory> getAllSubSubCategories(){
		return subSubCategoryRepository.findAll();
	}

}
