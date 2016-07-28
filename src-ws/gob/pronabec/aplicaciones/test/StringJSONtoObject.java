package gob.pronabec.aplicaciones.test;

import java.io.StringReader;
import java.util.List;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONObject;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import gob.sedapal.sgme.domain.Sede;


public class StringJSONtoObject {

	public static void main(String[] args) throws Exception {
		
		/* IMPORTANTE: Se recomienda que los atributos sea la primera letra en minuscula, sino usar @JsonProperty("Name") */
				
		// to JSONObject
        JSONObject jsonObject = new JSONObject("{\"codigo\":\"L\",\"denominacion\":\"TECSUP-CENTRO\",\"ubicacion\":\"LIMA\"}"); 
        System.out.println(jsonObject.get("denominacion"));
        
        // to JSONArray
        JSONArray jsonList = new JSONArray("[{\"codigo\":\"L\",\"denominacion\":\"TECSUP-CENTRO\",\"ubicacion\":\"LIMA\"}]"); 
        System.out.println(((JSONObject)jsonList.get(0)).get("denominacion"));
        
        // to <Object>
        StringReader json = new StringReader("{\"codigo\":\"L\",\"denominacion\":\"TECSUP-CENTRO\",\"ubicacion\":\"LIMA\"}");
        System.out.println("{\"codigo\":\"L\",\"denominacion\":\"TECSUP-CENTRO\",\"ubicacion\":\"LIMA\"}");
        
        ObjectMapper mapper = new ObjectMapper();
        Sede sede = mapper.readValue(json, Sede.class);
        System.out.println(sede);
        
        // to List<Object>
        StringReader json2 = new StringReader("[{\"codigo\":\"L\",\"denominacion\":\"TECSUP-CENTRO\",\"ubicacion\":\"LIMA\"}]");
        System.out.println("[{\"codigo\":\"L\",\"denominacion\":\"TECSUP-CENTRO\",\"ubicacion\":\"LIMA\"}]");
        
        ObjectMapper mapper2 = new ObjectMapper();
        List<Sede> sedes = mapper2.readValue(json2, new TypeReference<List<Sede>>(){});
        System.out.println(sedes);
        
	}
	
}
