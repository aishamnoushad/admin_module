package com.aisha.adminModule.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aisha.adminModule.Entity.Categories;
import com.aisha.adminModule.Services.CategoryService;
import com.aisha.adminModule.Services.SubCategoryService;
import com.aisha.adminModule.Services.SubSubCategoryService;
@Controller
public class SubSubCategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SubCategoryService subCategoryService;
	@Autowired
	private SubSubCategoryService subSubCategoryService;
	
	
	
	@RequestMapping("/subsubcategory")
	public String redirectToSubSubcategory(Model model) {
		
		
		subSubCategoryService.getAllSubSubCategories().stream().forEach(t->{
			t.setSubCategory(subCategoryService.findBySubCategoryIdentity(t.getSubSubCategoryIdentity().getCategory_ID(),t.getSubSubCategoryIdentity().getSub_Category_ID()));
			t.getSubCategory().setCategories(categoryService.findByCategoryId(t.getSubSubCategoryIdentity().getCategory_ID()));
		});
		model.addAttribute("subsubcategories", subSubCategoryService.getAllSubSubCategories());
		return "subsubcategory";
	}
	
	
}
