package gob.sedapal.sgme.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.sedapal.sgme.dao.AcademicoDao;
import gob.sedapal.sgme.domain.Asistencia;
import gob.sedapal.sgme.domain.Carrera;
import gob.sedapal.sgme.domain.Curso;
import gob.sedapal.sgme.domain.Matricula;
import gob.sedapal.sgme.domain.MatriculaDetalle;
import gob.sedapal.sgme.domain.Nota;
import gob.sedapal.sgme.domain.PlanEstudio;
import gob.sedapal.sgme.domain.Prerequisito;
import gob.sedapal.sgme.domain.Sede;
import gob.sedapal.sgme.domain.Semestre;

@Service
public class AcademicoService {

	protected static Logger log = Logger.getLogger(AcademicoService.class);
	
	@Autowired
	private AcademicoDao academicoDao;
	
	public List<Sede> listarSedes() {
		log.info("calling listarSedes: ");
		
		return academicoDao.listarSedes(); 
	}
	
		
	public List<Carrera> listarCarreras() {
		log.info("calling listarCarreras: ");
		
		return academicoDao.listarCarreras(); 
	}
	
	public List<PlanEstudio> listarPlanEstudios() {
		log.info("calling listarPlanEstudios: ");
		
		return academicoDao.listarPlanEstudios(); 
	}
	
	public List<Curso> listarCursos() {
		log.info("calling listarCursos: ");
		
		return academicoDao.listarCursos(); 
	}
	
	public List<Prerequisito> listarPrerequisitos() {
		log.info("calling listarPrerequisitos: ");
		
		return academicoDao.listarPrerequisitos(); 
	}
	
	public List<Semestre> listarSemestres() {
		log.info("calling listarSemestres: ");
		
		return academicoDao.listarSemestres(); 
	}
	
	public List<Matricula> listarMatriculas() {
		log.info("calling listarMatriculas: ");
		
		return academicoDao.listarMatriculas(); 
	}
	
	public List<MatriculaDetalle> listarMatriculasDetalle() {
		log.info("calling listarMatriculasDetalle: ");
		
		return academicoDao.listarMatriculasDetalle(); 
	}
	
	public List<Nota> listarNotas() {
		log.info("calling listarNotas: ");
		
		return academicoDao.listarNotas(); 
	}
	
	public List<Asistencia> listarAsistencias() {
		log.info("calling listarAsistencias: ");
		
		return academicoDao.listarAsistencias(); 
	}

}
