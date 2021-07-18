package com.aisha.adminModule.Entity;

import java.util.Date;
import java.util.Optional;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.beans.factory.annotation.Autowired;



@Entity
@Table(name="sub_categories")
public class SubCategory {
   @EmbeddedId
	SubCategoryIdentity subCategoryIdentity;
	
	public String Sub_Category_Name;
	public String Description;
	public String Status;
	private Date updated_at;
	private Date created_at;
	public SubCategoryIdentity getSubCategoryIdentity() {
		return subCategoryIdentity;
	}
	public void setSubCategoryIdentity(SubCategoryIdentity subCategoryIdentity) {
		this.subCategoryIdentity = subCategoryIdentity;
	}
	public String getSub_Category_Name() {
		return Sub_Category_Name;
	}
	public void setSub_Category_Name(String sub_Category_Name) {
		Sub_Category_Name = sub_Category_Name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public Date getCreated_at() {
		return created_at;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public SubCategory(SubCategoryIdentity subCategoryIdentity, String sub_Category_Name, String description,
			String status, Date updated_at, Date created_at) {
		super();
		this.subCategoryIdentity = subCategoryIdentity;
		Sub_Category_Name = sub_Category_Name;
		Description = description;
		Status = status;
		this.updated_at = updated_at;
		this.created_at = created_at;
	}
	
	public SubCategory() {
		
	}
	
	
	///////////
	//out of DB Values
	////////////////////
	@Transient
	@Autowired
	Categories categories;
	
	public Categories getCategories() {
		return categories;
	}
	public void setCategories(Categories categories) {
		this.categories = categories;
	}
	public void setCategories(Optional<Categories> categories) {
		this.categories = categories.get();
	}
	
	
	
}
