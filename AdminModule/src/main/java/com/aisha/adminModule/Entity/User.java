package com.aisha.adminModule.Entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")
@JsonIdentityReference(alwaysAsId=true)
@Entity
@Table(name="users")
public class User implements Serializable {
	public User() {

	}
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private Date email_verified_at;
	private String password;
	private int role;
	private String roleName;
	private String remember_token;
	private String mobileNumber;
	private String profile_photo_path;
	private LocalDateTime created_at;
	private LocalDateTime updated_at;
	private Boolean isApproved;

	public User(int id, String name, String email, Date email_verified_at, String password, int role, String roleName,
			String remember_token, String mobileNumber, String profile_photo_path, LocalDateTime created_at, LocalDateTime updated_at,Boolean isApproved) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.email_verified_at = email_verified_at;
		this.password = password;
		this.role = role;
		this.roleName = roleName;
		this.remember_token = remember_token;
		this.mobileNumber = mobileNumber;
		this.profile_photo_path = profile_photo_path;
		this.created_at = created_at;
		this.updated_at = updated_at;
		this.isApproved=isApproved;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getEmail_verified_at() {
		return email_verified_at;
	}
	public void setEmail_verified_at(Date email_verified_at) {
		this.email_verified_at = email_verified_at;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getRemember_token() {
		return remember_token;
	}
	public void setRemember_token(String remember_token) {
		this.remember_token = remember_token;
	}
	public String getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public String getProfile_photo_path() {
		return profile_photo_path;
	}
	public void setProfile_photo_path(String profile_photo_path) {
		this.profile_photo_path = profile_photo_path;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	public Boolean getIsApproved() {
		return isApproved;
	}
	public void setIsApproved(Boolean isApproved) {
		this.isApproved = isApproved;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", email_verified_at=" + email_verified_at
				+ ", password=" + password + ", role=" + role + ", roleName=" + roleName + ", remember_token="
				+ remember_token + ", mobileNumber=" + mobileNumber + ", profile_photo_path=" + profile_photo_path
				+ ", created_at=" + created_at + ", updated_at=" + updated_at + ", isApproved=" + isApproved + "]";
	}



}
