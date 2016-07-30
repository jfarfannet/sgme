package gob.sedapal.sgme.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import gob.sedapal.sgme.domain.Roles;

@Repository
public class RolDao {

	protected static Logger log = Logger.getLogger(RolDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<Roles> listarRoles(){
		log.info("calling listarRoles: ");
		
		String sql = "SELECT * FROM roles";
		
		List<Roles> lista = jdbcTemplate.query(sql, new RowMapper<Roles>() {
            public Roles mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Roles vo = new Roles();
            	vo.setIdRol(rs.getInt("idrol"));
            	vo.setDescRol(rs.getString("descrol"));
            	vo.setEstado(rs.getString("estado"));
                return vo;
            }
        });
		
		log.info(lista);
		
		return lista;
	}
}
