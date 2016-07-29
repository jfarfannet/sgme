package gob.sedapal.sgme.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import gob.sedapal.sgme.domain.Nota;
import gob.sedapal.sgme.domain.Usuario;
import gob.sedapal.sgme.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	protected static final Logger log = Logger.getLogger(AcademicoController.class);	
	
	@Autowired
	protected UsuarioService usuarioService;
	/**
	 * Perfil de usuario
	 * @param model
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/profile.html", method = RequestMethod.GET) 
	public String profile(Model model, @RequestParam("id")Integer id) throws Exception { 
		log.info("calling profile " + id);
		
		Usuario usuario = usuarioService.loadUserByUsername(id);
		model.addAttribute("usuario", usuario);
		log.info(usuario);
		
		return "usuarios/profile";
	}
	
	@RequestMapping(value = "/usuarios.html", method = RequestMethod.GET)
	public String listar(Model model) throws Exception { 
		log.info("calling usuarios");
		
		List<Usuario> usuario = usuarioService.listarUsuarios();
		model.addAttribute("notas", usuario);
		
		return "usuarios/listar";
	}
	
}
