package gob.pronabec.aplicaciones.test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Service;

import org.tempuri.ILoginService;

/**
 * 
 * @author ebenites
 * Client API generado con el comando: wsimport -s src -d bin http://aplicaciones.pronabec.gob.pe/WSA/LoginService.svc?wsdl
 *
 */
public class Cliente {

//	@WebServiceRef(wsdlLocation="http://aplicaciones.pronabec.gob.pe/WSA/LoginService.svc?wsdl")
//	static LoginService service;
	
	public static void main(String[] args) throws MalformedURLException {
		
		// --- authenticate ----------------------------------------------------------------------------------------------------
		
		URL url = new URL("http://aplicaciones.pronabec.gob.pe/WSA/LoginService.svc?wsdl");
		QName qname = new QName("http://tempuri.org/", "LoginService");
		Service service = Service.create(url, qname);
		
		ILoginService port = service.getPort(ILoginService.class);
        System.out.println(port.login("IEST.235", "IEST.235.5955"));
		
        BindingProvider bp = (BindingProvider)port;
        
        @SuppressWarnings("unchecked")
		Map<String, List<String>> responseHeaders = (Map<String, List<String>>)bp.getResponseContext().get("javax.xml.ws.http.response.headers");
        List<String> cookieHeaders = responseHeaders.get("Set-Cookie");
        String cookie = cookieHeaders.get(0).replaceAll(".ASPXAUTH=", "").replaceAll("; path=/", "");
        
        System.out.println(cookie);
        
        // --- Get Rest ----------------------------------------------------------------------------------------------------
        
        Client client = ClientBuilder.newClient();
        String entity = client.target("http://aplicaciones.pronabec.gob.pe/WSA/ServiceAcademico/GetBecariosIES")
//                .register(FilterForExampleCom.class)
//                .path("resource/helloworld")
//                .queryParam("greeting", "Hi World!")
                .request(MediaType.TEXT_PLAIN_TYPE)
//                .header("some-header", "true")
                .cookie(".ASPXAUTH", cookie)
                .get(String.class);
        
        System.out.println(entity);
        
	}

}
