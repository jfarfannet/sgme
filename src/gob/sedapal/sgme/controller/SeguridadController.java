package gob.sedapal.sgme.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SeguridadController {

	protected static final Logger log = Logger.getLogger(SeguridadController.class);	

	@RequestMapping(value = "/login.html", method = RequestMethod.GET)
	public String login() {
		log.info("calling login");
		
		return "login";
	}

	@RequestMapping(value = "/403.html", method = RequestMethod.GET)
	public @ResponseBody String accesssDenied() {	//For 403 Access denied page
		log.info("calling accesssDenied");
		
		return "No esta autorizado para acceder a este sitio";

	}
	
}
