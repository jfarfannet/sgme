package gob.sedapal.sgme.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.sedapal.sgme.dao.RolDao;
import gob.sedapal.sgme.domain.Roles;

@Service
public class RolesService {
	protected static Logger log = Logger.getLogger(RolesService.class);
	
	@Autowired
	private RolDao rolDao;
	
	public List<Roles> listarRoles() {
		log.info("calling listarRoles: ");
		
		return rolDao.listarRoles(); 
	}
}
