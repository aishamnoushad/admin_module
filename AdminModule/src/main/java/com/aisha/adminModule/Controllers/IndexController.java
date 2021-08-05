package com.aisha.adminModule.Controllers;



import java.util.stream.Collectors;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;

import com.aisha.adminModule.Entity.User;
import com.aisha.adminModule.Services.GenericService;
import com.aisha.adminModule.Services.MyUserPrincipal;
import com.aisha.adminModule.handlers.ActiveUserStore;

@Controller
public class IndexController {
	@Autowired
	private GenericService genericService;
	
	@Autowired
    ActiveUserStore activeUserStore;
	 @Resource(name="authenticationManager")
	    private AuthenticationManager authManager;
	private static final Logger log = LoggerFactory.getLogger(IndexController.class);
	
	@GetMapping("/login")
	public String index(Model model) {
		model.addAttribute("logginguser", new User());
		return "login";
	}

	@RequestMapping("/dashboard")
	public String redirectToDashboard(Model model) {
		model.addAttribute("users", activeUserStore.getUsers());
		model.addAttribute("whatsappclick", genericService.getAllWhatsappClicks().stream().map(obj->obj.getClickdate()).collect(Collectors.toList()));
		model.addAttribute("whatsappclickcount", genericService.getAllWhatsappClicks().stream().map(obj->obj.getCount()).collect(Collectors.toList()));
		return "index";
	}
//	@RequestMapping("/error")
//	public String redirectToError(Model model) {
//		return "error";
//	}
	@PostMapping("/postLogin")
	public String postLogin(@ModelAttribute User loggingUser, HttpSession session, Model model) {
		log.info("postLogin()");
			// read principal out of security context and set it to session
		//UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
		 UsernamePasswordAuthenticationToken authReq
	      = new UsernamePasswordAuthenticationToken(loggingUser.getEmail(), loggingUser.getPassword());
	    Authentication authentication = authManager.authenticate(authReq);
	    
	    SecurityContext sc = SecurityContextHolder.getContext();
	    sc.setAuthentication(authentication);
	   // HttpSession session = req.getSession(true);
		
		validatePrinciple(authentication.getPrincipal());
		User loggedInUser = ((MyUserPrincipal) authentication.getPrincipal()).getUser();
		log.info("postLogin()" + loggedInUser.getId());
		model.addAttribute("currentUserId", loggedInUser.getId());
		log.info("postLogin()" + loggedInUser.getName());
		model.addAttribute("currentUser", loggedInUser.getName());
		log.info("postLogin()" + loggedInUser.getId());
		session.setAttribute("userId", loggedInUser.getId());
		session.setAttribute("userName", loggedInUser.getName());
		session.setAttribute("ActiveUser", loggedInUser);
		return "redirect:/dashboard";
	}

	private void validatePrinciple(Object principal) {
		if (!(principal instanceof MyUserPrincipal)) {
			throw new  IllegalArgumentException("Principal can not be null!");
		}
	}
	
	@GetMapping("/logout")
	public String logout(SessionStatus session) {
		SecurityContextHolder.getContext().setAuthentication(null);
		session.setComplete();
		return "redirect:/login";
	}
}
