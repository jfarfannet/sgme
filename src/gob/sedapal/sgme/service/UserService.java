package gob.sedapal.sgme.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import gob.sedapal.sgme.dao.UserDao;

@Service
public class UserService implements UserDetailsService {

	protected static Logger log = Logger.getLogger(UserService.class);
	
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		log.info("calling loadUserByUsername: " + username);
		
		return userDao.loadUserByUsername(username); 
	}

}
