package com.aisha.adminModule.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aisha.adminModule.Services.CategoryService;
import com.aisha.adminModule.Services.SubCategoryService;
import com.aisha.adminModule.Services.SubSubCategoryService;

@Controller
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private SubCategoryService subCategoryService;
	@Autowired
	private SubSubCategoryService subSubCategoryService;
	
	@RequestMapping("/category")
	public String redirectTocategory(Model model) {
		model.addAttribute("categories", categoryService.getAllCategories());
		return "category";
	}
	
	
	@RequestMapping("/subcategory")
	public String redirectToSubcategory(Model model) {
		subCategoryService.getAllSubCategory().stream().forEach(t->t.setCategories(categoryService.findByCategoryId(t.getSubCategoryIdentity().Category_ID)));
		model.addAttribute("subcategories", subCategoryService.getAllSubCategory());
		return "subcategory";
	}
	
	
	@RequestMapping("/subsubcategory")
	public String redirectToSubSubcategory(Model model) {
		
		
		subSubCategoryService.getAllSubSubCategories().stream().forEach(t->{
			t.setSubCategory(subCategoryService.findBySubCategoryIdentity(t.getSubSubCategoryIdentity().getCategory_ID(),t.getSubSubCategoryIdentity().getSub_Category_ID()));
			t.getSubCategory().setCategories(categoryService.findByCategoryId(t.getSubSubCategoryIdentity().getCategory_ID()));
		});
		model.addAttribute("subsubcategories", subSubCategoryService.getAllSubSubCategories());
		return "subsubcategory";
	}
	
	@RequestMapping("/category/add")
	public String redirectToCategoryAdditionPage(Model model) {
		return "categoryadd";
	}

}
