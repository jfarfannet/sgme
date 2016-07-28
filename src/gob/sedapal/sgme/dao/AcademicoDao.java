package gob.sedapal.sgme.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

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

@Repository
public class AcademicoDao {

	protected static Logger log = Logger.getLogger(AcademicoDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Sede> listarSedes(){
		log.info("calling listarSedes: ");
		
		String sql = "SELECT * FROM B18_V_SEDES";
		
		List<Sede> lista = jdbcTemplate.query(sql, new RowMapper<Sede>() {
            public Sede mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Sede sede = new Sede();
            	sede.setCodigo(rs.getString("C_CodSede"));
        		sede.setDenominacion(rs.getString("C_DenominacionSede"));
        		sede.setUbicacion(rs.getString("C_Ubicacion"));
                return sede;
            }
        });
		
		log.info(lista);
		
		return lista;
	}
	
	public List<Carrera> listarCarreras(){
		log.info("calling listarCarreras: ");
		
		String sql = "SELECT * FROM B18_V_CARRERAS";
		
		List<Carrera> lista = jdbcTemplate.query(sql, new RowMapper<Carrera>() {
            public Carrera mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Carrera carrera = new Carrera();
            	carrera.setCodigo(rs.getString("C_CodCarrera"));
            	carrera.setNombre(rs.getString("C_NombreCarrera"));
            	carrera.setCodfacultad(rs.getString("C_IdFacultad"));
            	carrera.setNomfacultad(rs.getString("C_Nombrefacultad"));
            	carrera.setSede(rs.getString("C_CodSede"));
                return carrera;
            }
        });
		
		log.info(lista);
		
		return lista;
	}
	
	public List<PlanEstudio> listarPlanEstudios(){
		log.info("calling listarPlanEstudios: ");
		
		String sql = "SELECT * FROM B18_V_PLANESTUDIOS";
		
		List<PlanEstudio> lista = jdbcTemplate.query(sql, new RowMapper<PlanEstudio>() {
            public PlanEstudio mapRow(ResultSet rs, int rowNum) throws SQLException{
            	PlanEstudio plan = new PlanEstudio();
            	plan.setCodigo(rs.getString("C_CODIGOPLANESTUDIO"));
            	plan.setNombre(rs.getString("C_DESCRIPCION"));
            	plan.setCodcarrera(rs.getString("C_CODIGOCARRERA"));
            	plan.setCreditos(rs.getInt("N_CREDITOSOBLIGATORIOS"));
                return plan;
            }
        });
		
		log.info(lista);
		
		return lista;
	}
	
	public List<Curso> listarCursos(){
		log.info("calling listarCursos: ");
		
		String sql = "SELECT * FROM B18_V_CURSOS";
		
		List<Curso> lista = jdbcTemplate.query(sql, new RowMapper<Curso>() {
            public Curso mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Curso curso = new Curso();
            	curso.setCiclo(rs.getInt("C_CICLO"));
            	curso.setCodigo(rs.getString("C_CODIGOCURSO"));
            	curso.setCodplanestudio(rs.getString("C_CODIGOPLANESTUDIO"));
            	curso.setCreditos(rs.getDouble("C_CREDITOS"));
            	curso.setNombre(rs.getString("C_DESCRIPCION"));
            	curso.setTipo(rs.getString("C_TIPO"));
            	curso.setHoras(rs.getInt("N_HORASPROGRAMADAS"));
            	curso.setMinnota(rs.getDouble("N_NOTAMINIMA"));
            	curso.setMinasistencia(rs.getDouble("N_PORCENTAJEASISTENCIA"));
                return curso;
            }
        });
		
		log.info(lista);
		
		return lista;
	}
	
	public List<Prerequisito> listarPrerequisitos(){
		log.info("calling listarPrerequisitos: ");
		
		String sql = "SELECT * FROM B18_V_PREREQUISITOS";
		
		List<Prerequisito> lista = jdbcTemplate.query(sql, new RowMapper<Prerequisito>() {
            public Prerequisito mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Prerequisito prerequisito = new Prerequisito();
            	prerequisito.setCodcurso(rs.getString("C_CODIGOCURSO"));
            	prerequisito.setCodprerequisito(rs.getString("C_CODIGOPREREQUISITO"));
            	prerequisito.setCodplanestudio(rs.getString("C_CODIGOPLANESTUDIO"));
                return prerequisito;
            }
        });
		
		log.info(lista);
		
		return lista;
	}
	
	public List<Semestre> listarSemestres(){
		log.info("calling listarSemestres: ");
		
		String sql = "SELECT * FROM B18_V_SEMESTRES";
		
		List<Semestre> lista = jdbcTemplate.query(sql, new RowMapper<Semestre>() {
            public Semestre mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Semestre semestre = new Semestre();
            	semestre.setCodigo(rs.getString("C_CodSemestre"));
            	semestre.setDescripcion(rs.getString("C_Descripcion"));
            	semestre.setFecinicio(rs.getDate("F_FechaInicio"));
            	semestre.setFecfin(rs.getDate("F_FechaTermino"));
                return semestre;
            }
        });
		
		log.info(lista);
		
		return lista;
	}
	
	public List<Matricula> listarMatriculas(){
		log.info("calling listarMatriculas: ");
		
		String sql = "SELECT * FROM B18_V_MATRICULAS";
		
		List<Matricula> lista = jdbcTemplate.query(sql, new RowMapper<Matricula>() {
            public Matricula mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Matricula matricula = new Matricula();
            	matricula.setCodalumno(rs.getString("C_CodAlumno"));
            	matricula.setCodmatricula(rs.getString("C_CodMatricula"));
            	matricula.setCodsemestre(rs.getString("C_CodSemestre"));
            	matricula.setDni(rs.getString("C_NroDni"));
            	matricula.setFecha(rs.getDate("F_FechaMatricula"));
            	matricula.setCodcarrera(rs.getString("C_IdCarrera"));
            	matricula.setCodplanestudio(rs.getString("C_CodigoPlan"));
            	matricula.setSede(rs.getString("C_CodSede"));
                return matricula;
            }
        });
		
		log.info(lista);
		
		return lista;
	}
	
	public List<MatriculaDetalle> listarMatriculasDetalle(){
		log.info("calling listarMatriculasDetalle: ");
		
		String sql = "SELECT * FROM B18_V_MATRICULASDETALLE";
		
		List<MatriculaDetalle> lista = jdbcTemplate.query(sql, new RowMapper<MatriculaDetalle>() {
            public MatriculaDetalle mapRow(ResultSet rs, int rowNum) throws SQLException{
            	MatriculaDetalle detalle = new MatriculaDetalle();
            	detalle.setCodmatricula(rs.getString("C_CodMatricula"));
            	detalle.setCodcurso(rs.getString("C_CodigoCurso"));
                return detalle;
            }
        });
		
		log.info(lista);
		
		return lista;
	}
	
	public List<Nota> listarNotas(){
		log.info("calling listarNotas: ");
		
		String sql = "SELECT * FROM B18_V_NOTAS";
		
		List<Nota> lista = jdbcTemplate.query(sql, new RowMapper<Nota>() {
            public Nota mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Nota nota = new Nota();
            	nota.setCodmatricula(rs.getString("C_CodMatricula"));
            	nota.setCodcurso(rs.getString("C_CodigoCurso"));
            	nota.setCondicion(rs.getString("C_Condicion"));	// No puede ser nulo, mandatorio
            	nota.setNota(rs.getDouble("N_Nota"));	// No puede ser nulo, mandatorio
            	//if (rs.wasNull()) nota.setNota(null);
                return nota;
            }
        });
		
		log.info(lista);
		
		return lista;
	}
	
	public List<Asistencia> listarAsistencias(){
		log.info("calling listarAsistencias: ");
		
		String sql = "SELECT * FROM B18_V_ASISTENCIAS";
		
		List<Asistencia> lista = jdbcTemplate.query(sql, new RowMapper<Asistencia>() {
            public Asistencia mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Asistencia asistencia = new Asistencia();
            	asistencia.setCodcurso(rs.getString("C_CodigoCurso"));
            	asistencia.setDescripcion(rs.getString("C_DescripcionCurso"));
            	asistencia.setDni(rs.getString("C_NroDni"));
            	asistencia.setCodalumno(rs.getString("C_CodAlumno"));
            	asistencia.setFecinicio(rs.getString("DateTimeInicio"));
            	asistencia.setFecfin(rs.getString("DateTimeTermino"));
            	asistencia.setOpcion(rs.getInt("Opcion"));
            	asistencia.setTipo(rs.getString("Tipo"));
                return asistencia;
            }
        });
		
		log.info(lista);
		
		return lista;
	}
	
}
