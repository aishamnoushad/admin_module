package com.aisha.adminModule.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.aisha.adminModule.Entity.User;
import com.aisha.adminModule.Services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {
		model.addAttribute("user", new User());
		return "register";
		
	}
	
	@PostMapping("/register")
	public String processRegistration(@ModelAttribute User user) {
		userService.AddUserRequest(user);
		return "redirect:/login";
	}

}
