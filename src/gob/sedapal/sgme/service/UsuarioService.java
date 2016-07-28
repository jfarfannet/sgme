package gob.sedapal.sgme.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import gob.sedapal.sgme.dao.UsuarioDao;
import gob.sedapal.sgme.domain.Usuario;

@Service
public class UsuarioService {
	protected static Logger log = Logger.getLogger(UsuarioService.class);
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	
	public Usuario loadUserByUsername(int idUsuario) throws UsernameNotFoundException {
		log.info("calling loadUserByUsername: " + idUsuario);
		
		return usuarioDao.loadUserByUsername(idUsuario); 
	}
}
