package gob.sedapal.sgme.controller;

import org.apache.log4j.Logger;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import gob.sedapal.sgme.domain.User;

//@Controller
public class MainController {

	protected static final Logger log = Logger.getLogger(MainController.class);	
	
	@RequestMapping(value = { "/", "/welcome.html" }, method = RequestMethod.GET)
	public String welcomePage(Model model, @AuthenticationPrincipal User user) {	//For User
		log.info("calling welcomePage");
		
		model.addAttribute("title", "Spring Security Login - USER Authentication: "+user);
		
		return "index";
	}

	@RequestMapping(value = "/admin/index.html", method = RequestMethod.GET)
	public String adminPage(Model model) {	//For Admin
		log.info("calling adminPage");
		
		model.addAttribute("title", "Spring Security Login - ADMIN Authentication");
		
		return "index";
	}
	
	@RequestMapping(value = "/public/index.html", method = RequestMethod.GET)
	public String publicPage(Model model) {	//For Public
		log.info("calling publicPage");
		
		model.addAttribute("title", "Spring Security Login - PUBLIC Authentication");
		
		return "index";
	}

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login() {
		log.info("calling login");
		
		return "login";
	}

	@RequestMapping(value = "/403.html", method = RequestMethod.GET)
	@ResponseBody //Responder con un texto plano solamente
	public String accesssDenied() {	//For 403 Access denied page
		log.info("calling accesssDenied");
		
		return "No esta autorizado para acceder a este sitio";

	}
	
}
