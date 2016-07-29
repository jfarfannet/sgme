package gob.sedapal.sgme.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import gob.sedapal.sgme.domain.Roles;
import gob.sedapal.sgme.service.RolesService;

@Controller
@RequestMapping("/roles")
public class RolesController {
	
	protected static final Logger log = Logger.getLogger(RolesController.class);	
	
	@Autowired
	private RolesService rolesService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model) throws Exception { 
		log.info("calling index");
		
		return "roles/index";
	}
	
	@RequestMapping(value = "/listar.html", method = RequestMethod.GET)
	public String listar(Model model) throws Exception { 
		log.info("calling roles");
		
		List<Roles> roles = rolesService.listarRoles();
		
		model.addAttribute("roles", roles);
				
		return "roles/listar :: content";
	}
}
