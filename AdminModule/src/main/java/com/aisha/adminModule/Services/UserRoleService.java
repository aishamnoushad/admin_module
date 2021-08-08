package com.aisha.adminModule.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aisha.adminModule.Entity.User_Roles;
import com.aisha.adminModule.Repository.UserRolesRepository;

@Service
public class UserRoleService {
	@Autowired
	private UserRolesRepository user_RolesRepo;
	
	public User_Roles  saveUserRole(User_Roles user_Roles) {
		return user_RolesRepo.saveAndFlush(user_Roles);
	}
}
