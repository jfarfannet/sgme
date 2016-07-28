package gob.sedapal.sgme.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import gob.sedapal.sgme.domain.User;

@Repository
public class UserDao { //Basado en org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl

	protected static Logger log = Logger.getLogger(UserDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public User loadUserByUsername(String username){
		log.info("calling loadUserByUsername: " + username);
		
		//Select UserDetail
		String sql = "SELECT username, password, enabled, fullname, mail FROM users WHERE username = ?";
		
		User user = jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException{
            	User user = new User();
            	user.setFullname(rs.getString("fullname"));
        		user.setUsername(rs.getString("username"));
        		user.setPassword(rs.getString("password"));
        		user.setMail(rs.getString("mail"));
        		user.setEnabled(rs.getInt("enabled")==1);
        		user.setAccountNonLocked(true);
        		user.setAccountNonExpired(true);
        		user.setCredentialsNonExpired(true);
                return user;
            }
        }, username);
		
		//Select GrantedAuthority
		sql = "SELECT username, r.name AS authority FROM users_has_roles h "
				+ "INNER JOIN users u ON u.id=h.users_id "
				+ "INNER JOIN roles r ON r.id=h.roles_id "
				+ "WHERE username = ?";
		
		List<SimpleGrantedAuthority> authorities = jdbcTemplate.query(sql, new RowMapper<SimpleGrantedAuthority>() {
            public SimpleGrantedAuthority mapRow(ResultSet rs, int rowNum) throws SQLException{
                return new SimpleGrantedAuthority(rs.getString("authority"));
            }
        }, username);
		
		user.setAuthorities(authorities);
		
		log.info("User found: " + user);
		
		return user;
	}
	
}
