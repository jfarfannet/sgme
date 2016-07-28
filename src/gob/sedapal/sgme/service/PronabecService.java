package gob.sedapal.sgme.service;

import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

import org.apache.log4j.Logger;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.tempuri.ILoginService;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

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

@Service
public class PronabecService {
	
	protected static Logger log = Logger.getLogger(PronabecService.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	private AcademicoService academicoService;
	
	private String cookie = null;
	
	private void authenticate() throws Exception {
		log.info("authenticate");
		
		URL url = new URL("http://aplicaciones.pronabec.gob.pe/WSA/LoginService.svc?wsdl");
		QName qname = new QName("http://tempuri.org/", "LoginService");
		javax.xml.ws.Service service = javax.xml.ws.Service.create(url, qname);
		
		ILoginService port = service.getPort(ILoginService.class);
        boolean loginOK = port.login(env.getProperty("config.pronabec.ws.username"), env.getProperty("config.pronabec.ws.password"));
        log.info("Authenticate status: " + loginOK);
        
        if(!loginOK) throw new Exception("Error en la autenticacion a los servicios de PRONABEC");
        
        BindingProvider bp = (BindingProvider)port;
        
        @SuppressWarnings("unchecked")
        Map<String, List<String>> responseHeaders = (Map<String, List<String>>)bp.getResponseContext().get("javax.xml.ws.http.response.headers");
        List<String> cookieHeaders = responseHeaders.get("Set-Cookie");
        this.cookie = cookieHeaders.get(0).replaceAll(".ASPXAUTH=", "").replaceAll("; path=/", "");
        log.info("Cookie generated: " + cookie);
        
	}
	
	public List<Becario> callGetBecariosIES() throws Exception{
		log.info("callGetBecariosIES");
		
		authenticate();
		
		Client client = ClientBuilder.newClient();
		String entity = client.target("http://aplicaciones.pronabec.gob.pe/WSA/ServiceAcademico/GetBecariosIES")
                .request(/*MediaType.APPLICATION_JSON*/) // La respuesta no es JSON puro (tiene un xml)
                .cookie(".ASPXAUTH", this.cookie)
                .get(String.class);
        
        log.info(entity);
        
        entity = entity.replaceAll("\\<.*?>","");
        
        log.info(entity);
        
        ObjectMapper mapper = new ObjectMapper();
        List<Becario> becarios = mapper.readValue(entity, new TypeReference<List<Becario>>(){}); // Necesario usar @JsonProperty cuando es mayuscula la primera letra en cada atributo del JSON
//        List becarios = mapper.readValue(entity, List.class); //Crea automaticamente un bean becario
        
        log.info(becarios);
        
        return becarios;
	}
	
	public String callGuardarSedes() throws Exception{
		log.info("callGuardarSedes");
		
		authenticate();
		
		List<Sede> sedes = academicoService.listarSedes();
		log.info(sedes);
		
		Client client = ClientBuilder.newClient();
        String entity = client.target("http://aplicaciones.pronabec.gob.pe/WSA/ServiceAcademico/GuardarSede")
                .request()
                .cookie(".ASPXAUTH", this.cookie)
                .post(Entity.entity(sedes, MediaType.APPLICATION_JSON), String.class);
        
        log.info(entity);
        
        entity = entity.replaceAll("\\<.*?>","");
        
        log.info(entity);
        
        String message = parseMessageResponse(entity);
        
        return message;
	}
	
	public String callGuardarCarreras() throws Exception{
		log.info("callGuardarCarreras");
		
		authenticate();
		
		List<Carrera> carreras = academicoService.listarCarreras();
		log.info(carreras);
		
		Client client = ClientBuilder.newClient();
        String entity = client.target("http://aplicaciones.pronabec.gob.pe/WSA/ServiceAcademico/GuardarCarrera")
                .request()
                .cookie(".ASPXAUTH", this.cookie)
                .post(Entity.entity(carreras, MediaType.APPLICATION_JSON), String.class);
        
        log.info(entity);
        
        entity = entity.replaceAll("\\<.*?>","");
        
        log.info(entity);
        
        String message = parseMessageResponse(entity);
        
        return message;
	}
	
	public String callGuardarPlanEstudios() throws Exception{
		log.info("callGuardarPlanEstudios");
		
		authenticate();
		
		List<PlanEstudio> planestudios = academicoService.listarPlanEstudios();
		log.info(planestudios);
		
		Client client = ClientBuilder.newClient();
        String entity = client.target("http://aplicaciones.pronabec.gob.pe/WSA/ServiceAcademico/GuardarPlanEstudio")
                .request()
                .cookie(".ASPXAUTH", this.cookie)
                .post(Entity.entity(planestudios, MediaType.APPLICATION_JSON), String.class);
        
        log.info(entity);
        
        entity = entity.replaceAll("\\<.*?>","");
        
        log.info(entity);
        
        String message = parseMessageResponse(entity);
        
        return message;
	}
	
	public String callGuardarCursos() throws Exception{
		log.info("callGuardarCursos" );
		
		authenticate();
		
		List<Curso> cursos = academicoService.listarCursos();
		log.info(cursos);
		
		Client client = ClientBuilder.newClient();
        String entity = client.target("http://aplicaciones.pronabec.gob.pe/WSA/ServiceAcademico/GuardarCurso")
                .request()
                .cookie(".ASPXAUTH", this.cookie)
                .post(Entity.entity(cursos, MediaType.APPLICATION_JSON), String.class);
        
        log.info(entity);
        
        entity = entity.replaceAll("\\<.*?>","");
        
        log.info(entity);
        
        String message = parseMessageResponse(entity);
        
        return message;
	}
	
	public String callGuardarPrerequisitos() throws Exception{
		log.info("callGuardarPrerequisitos");
		
		authenticate();
		
		List<Prerequisito> prerequisitos = academicoService.listarPrerequisitos();
		log.info(prerequisitos);
		
		Client client = ClientBuilder.newClient();
        String entity = client.target("http://aplicaciones.pronabec.gob.pe/WSA/ServiceAcademico/GuardarCursoPreRequisitos")
                .request()
                .cookie(".ASPXAUTH", this.cookie)
                .post(Entity.entity(prerequisitos, MediaType.APPLICATION_JSON), String.class);
        
        log.info(entity);
        
        entity = entity.replaceAll("\\<.*?>","");
        
        log.info(entity);
        
        String message = parseMessageResponse(entity);
        
        return message;
	}
	
	public String callGuardarSemestres() throws Exception{
		log.info("callGuardarSemestres");
		
		authenticate();
		
		List<Semestre> semestres = academicoService.listarSemestres();
		log.info(semestres);
		
		Client client = ClientBuilder.newClient();
        String entity = client.target("http://aplicaciones.pronabec.gob.pe/WSA/ServiceAcademico/GuardarSemestre")
                .request()
                .cookie(".ASPXAUTH", this.cookie)
                .post(Entity.entity(semestres, MediaType.APPLICATION_JSON), String.class);
        
        log.info(entity);
        
        entity = entity.replaceAll("\\<.*?>","");
        
        log.info(entity);
        
        String message = parseMessageResponse(entity);
        
        return message;
	}
	
	public String callGuardarMatriculas() throws Exception{
		log.info("callGuardarMatriculas");
		
		authenticate();
		
		List<Matricula> matriculas = academicoService.listarMatriculas();
		log.info(matriculas);
		
		Client client = ClientBuilder.newClient();
        String entity = client.target("http://aplicaciones.pronabec.gob.pe/WSA/ServiceAcademico/GuardarMatricula")
                .request()
                .cookie(".ASPXAUTH", this.cookie)
                .post(Entity.entity(matriculas, MediaType.APPLICATION_JSON), String.class);
        
        log.info(entity);
        
        entity = entity.replaceAll("\\<.*?>","");
        
        log.info(entity);
        
        String message = parseMessageResponse(entity);
        
        return message;
	}
	
	public String callGuardarMatriculasDetalle() throws Exception{
		log.info("callGuardarMatriculasDetalle");
		
		authenticate();
		
		List<MatriculaDetalle> matriculasdetalle = academicoService.listarMatriculasDetalle();
		log.info(matriculasdetalle);
		
		Client client = ClientBuilder.newClient();
        String entity = client.target("http://aplicaciones.pronabec.gob.pe/WSA/ServiceAcademico/GuardarMatriculaDetalle")
                .request()
                .cookie(".ASPXAUTH", this.cookie)
                .post(Entity.entity(matriculasdetalle, MediaType.APPLICATION_JSON), String.class);
        
        log.info(entity);
        
        entity = entity.replaceAll("\\<.*?>","");
        
        log.info(entity);
        
        String message = parseMessageResponse(entity);
        
        return message;
	}
	
	public String callGuardarNotas() throws Exception{
		log.info("callGuardarNotas");
		
		authenticate();
		
		List<Nota> notas = academicoService.listarNotas();
		log.info(notas);
		
		Client client = ClientBuilder.newClient();
        String entity = client.target("http://aplicaciones.pronabec.gob.pe/WSA/ServiceAcademico/GuardarNotas")
                .request()
                .cookie(".ASPXAUTH", this.cookie)
                .post(Entity.entity(notas, MediaType.APPLICATION_JSON), String.class);
        
        log.info(entity);
        
        entity = entity.replaceAll("\\<.*?>","");
        
        log.info(entity);
        
        String message = parseMessageResponse(entity);
        
        return message;
	}
	
	public String callGuardarAsistencias() throws Exception{
		log.info("callGuardarAsistencias");
		
		authenticate();
		
		List<Asistencia> asistencias = academicoService.listarAsistencias();
		log.info(asistencias);
		
		
		// ---------------------------
		
		int limit = 5000;
		int bucles = asistencias.size()/limit;
		String message = "";
		
		for(int i = 0; i < bucles; i++){
			
			
		List<Asistencia> sub = asistencias.subList(limit*(i), (i==bucles-1)?asistencias.size():limit*(i+1));
		
		Client client = ClientBuilder.newClient();
        String entity = client.target("http://aplicaciones.pronabec.gob.pe/WSA/ServiceAcademico/GuardarAsistencia")
                .request()
                .cookie(".ASPXAUTH", this.cookie)
                .post(Entity.entity(sub, MediaType.APPLICATION_JSON), String.class);
        
        log.info(entity);
        
        entity = entity.replaceAll("\\<.*?>","");
        
        log.info(entity);
        
        message += parseMessageResponse(entity);
        
        
		}
        
        //---------------------------
        
		
        return message;
	}
	
	private String parseMessageResponse(String entity) throws Exception{
		try{
			// On Error
			if(entity.charAt(0) == '['){
	        	JSONArray errores = new JSONArray(entity);
//	        	String message = (errores.getJSONObject(0)).getString("Mensaje"); 
//	        	throw new Exception(message);
	        	
	        	String message = "";
	        	String duplicados = "";
	        	
	        	if(errores.length() > 0){
	        		message += " - Errores: <br/>";
		        	for (int i = 0; i < errores.length(); ++i) {
		        		JSONObject error = errores.getJSONObject(i);
		        		JSONObject detail = (error.isNull("error"))?null:error.getJSONObject("error");
		        		if("Datos duplicados".equals(error.getString("Mensaje")))
		        			duplicados += " ["+error.getString("Mensaje")+":"+detail+"] <br/>";
		        		else
		        			message += " ["+error.getString("Mensaje")+":"+detail+"] <br/>";
		        			
					}
		        	message += duplicados; // Mensaje de duplicados al final
	        	}
	        	return message;
	        	
	        // On Success
	        }else if(entity.charAt(0) == '{'){
	        	JSONObject jsonObject = new JSONObject(entity);
	        	Integer guardados = jsonObject.getInt("guardado");
	        	Integer perdidos = jsonObject.getInt("perdido");
	        	JSONArray errores = jsonObject.getJSONArray("e");
//	        	{"guardado":2,"perdido":0,"e":[]}
//	        	{"guardado":0,"perdido":2,"e":[{"error":{"C_CodSede":"L","C_DenominacionSede":"TECSUP-CENTRO","C_Ubicacion":"LIMA","N_Id_Institucion":101},"Codigo":"-100","Mensaje":"Datos duplicados"},{"error":{"C_CodSede":"T","C_DenominacionSede":"TECSUP-NORTE","C_Ubicacion":"TRUJILLO","N_Id_Institucion":101},"Codigo":"-100","Mensaje":"Datos duplicados"}]}
	        	String message = "Registros guardados: " + guardados;
	        	String duplicados = "";
	        	if(perdidos != 0){
	        		message += " - Registros perdidos: " + perdidos;
	        	}
	        	if(errores.length() > 0){
	        		message += " - Errores: <br/>";
		        	for (int i = 0; i < errores.length(); ++i) {
		        		JSONObject error = errores.getJSONObject(i);
		        		JSONObject detail = error.getJSONObject("error");
		        		if("Datos duplicados".equals(error.getString("Mensaje")))
		        			duplicados += " ["+error.getString("Mensaje")+":"+detail.toString()+"] <br/>";
		        		else
		        			message += " ["+error.getString("Mensaje")+":"+detail.toString()+"] <br/>";
		        			
					}
		        	message += duplicados; // Mensaje de duplicados al final
	        	}
	        	// On all errors (mejor q no sea una excepcion)
//	        	if(guardados == 0 && (perdidos != 0 || errores.length() != 0)){
//	            	throw new Exception(message);
//	        	}
	        	return message;
	        // On Unknowed error
	        }else{
	        	String message = "Error desconocido: "+entity;
	        	throw new Exception(message);
	        }
		}catch(Exception e){
			log.error(e.getMessage(), e);
			throw e;
		}
	}
	
}
