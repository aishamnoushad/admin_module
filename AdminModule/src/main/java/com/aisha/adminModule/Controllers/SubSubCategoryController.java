package com.aisha.adminModule.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aisha.adminModule.Entity.SubCategory;
import com.aisha.adminModule.Entity.SubSubCategory;
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
	
	@GetMapping("/subsubcategory/add")
	public String redirectToSubSubCategoryAdditionPage(Model model) {
		model.addAttribute("subsubcategory", new SubSubCategory());
		model.addAttribute("AllCategories", categoryService.getAllCategories());
		return "addsubsubcategory";
	}
	@ResponseBody
	@GetMapping("/getSubCategories")
	public  List<SubCategory> getSubCategories(@RequestParam(value = "category_id", required = true) String catid) {
		return subCategoryService.getAllSubCategoryOfSelected(catid);
		
	}
	@PostMapping("/subsubcategory/add")
	public String postSaveCategory(@ModelAttribute SubSubCategory newSubCategory) {
		subSubCategoryService.saveSubCategory(newSubCategory);
		return "redirect:/subsubcategory";
	}
	
	@GetMapping("/subsubcategory/update/{category_id}/{sub_category_id}/{sub_sub_category_id}")
	public String updateViewSubCategory(@PathVariable("category_id") String CategoryId,@PathVariable("sub_category_id") String SubCategoryId,@PathVariable("sub_sub_category_id") String SubSubCategoryId, Model model) {
		try {
//			if(categoryService.findByCategoryId(CategoryId).isPresent())
				model.addAttribute("selSubSubCategory", subSubCategoryService.findBySubSubCategoryIdentity(CategoryId,SubCategoryId,SubSubCategoryId).get());
				model.addAttribute("AllCategories", categoryService.getAllCategories());
				model.addAttribute("subcategories", subCategoryService.getAllSubCategoryOfSelected(CategoryId));
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return "updatesubsubcategory";
	}
	
	@GetMapping("/subsubcategory/delete/{category_id}/{sub_category_id}/{sub_sub_category_id}")
	public String postdeleteCategory(@PathVariable("category_id") String CategoryId, @PathVariable("sub_category_id") String SubCategoryId,@PathVariable("sub_sub_category_id") String SubSubCategoryId) {
		subSubCategoryService.deleteSubSubCategory(CategoryId,SubCategoryId,SubSubCategoryId);
		return "redirect:/subsubcategory";
	}
}
