package gob.pronabec.aplicaciones.test;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;

public class ClientRestFull {

	public static void main(String[] args) {
		
		// {"CODPADRE":"3005","ID":"63","NOMBRE":"Agr\u00edcola","LUGAR":"T","ESCURSO":"1","ESVIRTUAL":"0","ESEVENTO":"1"}
		
		Client client = ClientBuilder.newClient();
        Area area = client.target("http://www.tecsup.edu.pe/home/wp-content/themes/medialab/data/area.json")
                .request()
                .get(Area.class);
        
        System.out.println(area);
        
        // [{"CODPADRE":"3005","ID":"63","NOMBRE":"Agr\u00edcola","LUGAR":"T","ESCURSO":"1","ESVIRTUAL":"0","ESEVENTO":"1"}, ... ]
		
 		Client client2 = ClientBuilder.newClient();
        List<Area> areas = client2.target("http://www.tecsup.edu.pe/home/wp-content/themes/medialab/data/areas.json")
                 .request()
                 .get(new GenericType<List<Area>>() {});
         
         System.out.println(areas);

         // Si los atributos del JSON contiene la primera letra en mayuscula es necesario especificar en Area :
         // 1. o usas @XmlElement(name="CODPADRE") en los métidos 
         // o si los atributos con igual con mayuscula que sea público
         
	}

}
