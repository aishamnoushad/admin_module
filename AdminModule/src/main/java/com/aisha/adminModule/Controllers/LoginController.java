package com.aisha.adminModule.Controllers;



import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.aisha.adminModule.Entity.User;
import com.aisha.adminModule.Services.MyUserPrincipal;

public class LoginController {
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//	public String login() {
//		return "login";
//	}

	@RequestMapping(value = "/loginFailed", method = RequestMethod.GET)
	public String loginError(Model model) {
		log.info("Login attempt failed");
		model.addAttribute("error", "true");
		return "login";
	}

	@RequestMapping("/error-forbidden")
	public String errorForbidden() {
		return "error-forbidden";
	}

//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logout(SessionStatus session) {
//		SecurityContextHolder.getContext().setAuthentication(null);
//		session.setComplete();
//		return "redirect:/login";
//	}

//	@RequestMapping(value = "/postLogin", method = RequestMethod.POST)
//	public String postLogin(Model model, HttpSession session) {
//		log.info("postLogin()");
//
//		// read principal out of security context and set it to session
//		UsernamePasswordAuthenticationToken authentication = (UsernamePasswordAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();
//		validatePrinciple(authentication.getPrincipal());
//		User loggedInUser = ((MyUserPrincipal) authentication.getPrincipal()).getUser();
//
//		model.addAttribute("currentUserId", loggedInUser.getId());
//		model.addAttribute("currentUser", loggedInUser.getName());
//		session.setAttribute("userId", loggedInUser.getId());
//		session.setAttribute("ActiveUser", loggedInUser);
//		return "redirect:/dashboard";
//	}

//	private void validatePrinciple(Object principal) {
//		if (!(principal instanceof MyUserPrincipal)) {
//			throw new  IllegalArgumentException("Principal can not be null!");
//		}
//	}
	
	
}
