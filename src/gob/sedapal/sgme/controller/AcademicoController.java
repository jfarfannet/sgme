package gob.sedapal.sgme.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import gob.sedapal.sgme.domain.Asistencia;
import gob.sedapal.sgme.domain.Becario;
import gob.sedapal.sgme.domain.Carrera;
import gob.sedapal.sgme.domain.Curso;
import gob.sedapal.sgme.domain.Matricula;
import gob.sedapal.sgme.domain.MatriculaDetalle;
import gob.sedapal.sgme.domain.Nota;
import gob.sedapal.sgme.domain.PlanEstudio;
import gob.sedapal.sgme.domain.Prerequisito;
import gob.sedapal.sgme.domain.Sede;
import gob.sedapal.sgme.domain.Semestre;
import gob.sedapal.sgme.domain.User;
import gob.sedapal.sgme.domain.Usuario;
import gob.sedapal.sgme.service.AcademicoService;
import gob.sedapal.sgme.service.PronabecService;

@Controller
@RequestMapping("/academico")
public class AcademicoController {

	protected static final Logger log = Logger.getLogger(AcademicoController.class);	
	
	@Autowired
	private AcademicoService academicoService;
	
	@Autowired
	private PronabecService pronabecService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model, @AuthenticationPrincipal User user) throws Exception { 
		log.info("calling index");
		
		return "academico/index";
	}
	
	@RequestMapping(value = "/becarios", method = RequestMethod.GET, produces="application/json") 
	public @ResponseBody List<Becario> becarios() throws Exception { 
		log.info("calling becarios");
		
		List<Becario> response = pronabecService.callGetBecariosIES();
		log.info(response);
		
		return response;
	}
	
//	@RequestMapping(value = "/usuarios", method = RequestMethod.GET)
//	public String usuarios(Model model) throws Exception { 
//		log.info("calling usuarios");
//		
//		List<Usuario> usuarios = academicoService.();
//		model.addAttribute("usuarios", usuarios);
//		
//		return "academico/sedes :: content";
//	}
	
	@RequestMapping(value = "/sedes", method = RequestMethod.GET)
	public String sedes(Model model) throws Exception { 
		log.info("calling sedes");
		
		List<Sede> sedes = academicoService.listarSedes();
		model.addAttribute("sedes", sedes);
		
		return "academico/sedes :: content";
	}
	
	@RequestMapping(value = "/sedes/upload", method = RequestMethod.POST) 
	public @ResponseBody String sedes_upload() throws Exception { 
		log.info("calling sedes_upload");
		
		String response = pronabecService.callGuardarSedes();
		log.info(response);
		
		return response;
	}
	
	
	@RequestMapping(value = "/carreras", method = RequestMethod.GET)
	public String carreras(Model model) throws Exception { 
		log.info("calling carreras");
		
		List<Carrera> carreras = academicoService.listarCarreras();
		model.addAttribute("carreras", carreras);
		
		return "academico/carreras :: content";
	}
	
	@RequestMapping(value = "/carreras/upload", method = RequestMethod.POST) 
	public @ResponseBody String carreras_upload() throws Exception { 
		log.info("calling carreras_upload");
		
		String response = pronabecService.callGuardarCarreras();
		log.info(response);
		
		return response;
	}
	
	
	@RequestMapping(value = "/planestudios", method = RequestMethod.GET)
	public String planestudios(Model model) throws Exception { 
		log.info("calling planestudios");
		
		List<PlanEstudio> planestudios = academicoService.listarPlanEstudios();
		model.addAttribute("planestudios", planestudios);
		
		return "academico/planestudios :: content";
	}
	
	@RequestMapping(value = "/planestudios/upload", method = RequestMethod.POST) 
	public @ResponseBody String planestudios_upload() throws Exception { 
		log.info("calling planestudios_upload");
		
		String response = pronabecService.callGuardarPlanEstudios();
		log.info(response);
		
		return response;
	}
	
	
	@RequestMapping(value = "/cursos", method = RequestMethod.GET)
	public String cursos(Model model) throws Exception { 
		log.info("calling cursos");
		
		List<Curso> cursos = academicoService.listarCursos();
		model.addAttribute("cursos", cursos);
		
		return "academico/cursos :: content";
	}
	
	@RequestMapping(value = "/cursos/upload", method = RequestMethod.POST) 
	public @ResponseBody String cursos_upload() throws Exception { 
		log.info("calling cursos_upload");
		
		String response = pronabecService.callGuardarCursos();
		log.info(response);
		
		return response;
	}
	
	
	@RequestMapping(value = "/prerequisitos", method = RequestMethod.GET)
	public String prerequisitos(Model model) throws Exception { 
		log.info("calling prerequisitos");
		
		List<Prerequisito> prerequisitos = academicoService.listarPrerequisitos();
		model.addAttribute("prerequisitos", prerequisitos);
		
		return "academico/prerequisitos :: content";
	}
	
	@RequestMapping(value = "/prerequisitos/upload", method = RequestMethod.POST) 
	public @ResponseBody String prerequisitos_upload() throws Exception { 
		log.info("calling prerequisitos_upload");
		
		String response = pronabecService.callGuardarPrerequisitos();
		log.info(response);
		
		return response;
	}
	
	
	@RequestMapping(value = "/semestres", method = RequestMethod.GET)
	public String semestres(Model model) throws Exception { 
		log.info("calling semestres");
		
		List<Semestre> semestres = academicoService.listarSemestres();
		model.addAttribute("semestres", semestres);
		
		return "academico/semestres :: content";
	}
	
	@RequestMapping(value = "/semestres/upload", method = RequestMethod.POST) 
	public @ResponseBody String semestres_upload() throws Exception { 
		log.info("calling semestres_upload");
		
		String response = pronabecService.callGuardarSemestres();
		log.info(response);
		
		return response;
	}
	
	
	@RequestMapping(value = "/matriculas", method = RequestMethod.GET)
	public String matriculas(Model model) throws Exception { 
		log.info("calling matriculas");
		
		List<Matricula> matriculas = academicoService.listarMatriculas();
		model.addAttribute("matriculas", matriculas);
		
		return "academico/matriculas :: content";
	}
	
	@RequestMapping(value = "/matriculas/upload", method = RequestMethod.POST) 
	public @ResponseBody String matriculas_upload() throws Exception { 
		log.info("calling matriculas_upload");
		
		String response = pronabecService.callGuardarMatriculas();
		log.info(response);
		
		return response;
	}
	
	
	@RequestMapping(value = "/matriculasdetalle", method = RequestMethod.GET)
	public String matriculasdetalle(Model model) throws Exception { 
		log.info("calling matriculasdetalle");
		
		List<MatriculaDetalle> matriculasdetalle = academicoService.listarMatriculasDetalle();
		model.addAttribute("matriculasdetalle", matriculasdetalle);
		
		return "academico/matriculasdetalle :: content";
	}
	
	@RequestMapping(value = "/matriculasdetalle/upload", method = RequestMethod.POST) 
	public @ResponseBody String matriculasdetalle_upload() throws Exception { 
		log.info("calling matriculasdetalle_upload");
		
		String response = pronabecService.callGuardarMatriculasDetalle();
		log.info(response);
		
		return response;
	}
	
	
	@RequestMapping(value = "/notas", method = RequestMethod.GET)
	public String notas(Model model) throws Exception { 
		log.info("calling notas");
		
		List<Nota> notas = academicoService.listarNotas();
		model.addAttribute("notas", notas);
		
		return "academico/notas :: content";
	}
	
	@RequestMapping(value = "/notas/upload", method = RequestMethod.POST) 
	public @ResponseBody String notas_upload() throws Exception { 
		log.info("calling notas_upload");
		
		String response = pronabecService.callGuardarNotas();
		log.info(response);
		
		return response;
	}
	
	
	@RequestMapping(value = "/asistencias", method = RequestMethod.GET)
	public String asistencias(Model model) throws Exception { 
		log.info("calling asistencias");
		
		List<Asistencia> asistencias = academicoService.listarAsistencias();
		model.addAttribute("asistencias", asistencias);
		
		return "academico/asistencias :: content";
	}
	
	@RequestMapping(value = "/asistencias/upload", method = RequestMethod.POST) 
	public @ResponseBody String asistencias_upload() throws Exception { 
		log.info("calling asistencias_upload");
		
		String response = pronabecService.callGuardarAsistencias();
		log.info(response);
		
		return response;
	}

	//Spring Flash message: http://stackoverflow.com/questions/23528496/what-is-requestscope-equivalent-in-thymeleaf-to-use-flash-messages
	//Spring security: http://www.thymeleaf.org/doc/articles/springsecurity.html
	
}
