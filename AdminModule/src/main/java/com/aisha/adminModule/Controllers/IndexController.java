package com.aisha.adminModule.Controllers;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aisha.adminModule.Services.GenericService;

@Controller
public class IndexController {
	@Autowired
	private GenericService genericService;
//	@RequestMapping("/login")
//	public String index() {
//		return "login";
//	}
	@RequestMapping("/register")
	public String redirectToRegister() {
		return "register";
	}
	@RequestMapping("/dashboard")
	public String redirectToDashboard(Model model) {
		model.addAttribute("whatsappclick", genericService.getAllWhatsappClicks().stream().map(obj->obj.getClickdate()).collect(Collectors.toList()));
		model.addAttribute("whatsappclickcount", genericService.getAllWhatsappClicks().stream().map(obj->obj.getCount()).collect(Collectors.toList()));
		return "index";
	}
	@RequestMapping("/category")
	public String redirectTocategory() {
		return "category";
	}
}
