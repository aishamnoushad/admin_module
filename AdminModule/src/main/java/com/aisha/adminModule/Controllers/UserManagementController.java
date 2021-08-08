package com.aisha.adminModule.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aisha.adminModule.Services.UserService;

@Controller
public class UserManagementController {
	@Autowired
	private UserService UserService;
	
	@GetMapping("/user_request")
	public String showUserRequestViewPage(Model model) {
		model.addAttribute("userrequest",UserService.getAllUserRequest());
		return "user_request_view";
	}
	
	

}
