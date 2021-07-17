package com.aisha.adminModule.Controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aisha.adminModule.Services.GenericService;
import com.aisha.adminModule.handlers.ActiveUserStore;

@Controller
public class IndexController {
	@Autowired
	private GenericService genericService;
	
	@Autowired
    ActiveUserStore activeUserStore;
	@GetMapping("/login")
	public String index() {
		return "login";
	}
	@RequestMapping("/register")
	public String redirectToRegister() {
		return "register";
	}
	@RequestMapping("/dashboard")
	public String redirectToDashboard(Model model) {
		model.addAttribute("users", activeUserStore.getUsers());
		model.addAttribute("whatsappclick", genericService.getAllWhatsappClicks().stream().map(obj->obj.getClickdate()).collect(Collectors.toList()));
		model.addAttribute("whatsappclickcount", genericService.getAllWhatsappClicks().stream().map(obj->obj.getCount()).collect(Collectors.toList()));
		return "index";
	}
	@RequestMapping("/category")
	public String redirectTocategory() {
		return "category";
	}
}
