package com.aisha.adminModule.Entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categories {
	@Id
	private String Category_ID;
	private String Category_Name;
	private String Description;
	private String Status;
	private LocalDate updated_at;
	private LocalDate created_at;
	public String getCategory_ID() {
		return Category_ID;
	}
	public void setCategory_ID(String category_ID) {
		Category_ID = category_ID;
	}
	public String getCategory_Name() {
		return Category_Name;
	}
	public void setCategory_Name(String category_Name) {
		Category_Name = category_Name;
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
	public LocalDate getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDate updated_at) {
		this.updated_at = updated_at;
	}
	public LocalDate getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDate created_at) {
		this.created_at = created_at;
	}
	public Categories(String category_ID, String category_Name, String description, String status, LocalDate updated_at,
			LocalDate created_at) {
		super();
		Category_ID = category_ID;
		Category_Name = category_Name;
		Description = description;
		Status = status;
		this.updated_at = updated_at;
		this.created_at = created_at;
	}
	public Categories() {
		
	}
	
	

}
