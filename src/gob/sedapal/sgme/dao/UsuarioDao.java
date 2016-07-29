package gob.sedapal.sgme.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Repository;

import gob.sedapal.sgme.domain.Sede;
import gob.sedapal.sgme.domain.Usuario;

@Repository
public class UsuarioDao {

protected static Logger log = Logger.getLogger(UsuarioDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public Usuario loadUserByUsername(int idUsuario){
		log.info("calling loadUserByUsername: " + idUsuario);
		
		//Select UserDetail
		String sql = "SELECT idUsuario,nombre,apellidoPaterno,apellidoMaterno,"
				+ "nroDocumento,idTipoDocumento,idRol,email,estado "
				+ "FROM Usuario WHERE idUsuario = ?";
		
		Usuario user = jdbcTemplate.queryForObject(sql, new RowMapper<Usuario>() {
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Usuario user = new Usuario();
            	user.setNombre(rs.getString("nombre"));
        		user.setApellidoPaterno(rs.getString("apellidoPaterno"));
        		user.setApellidoMaterno(rs.getString("apellidoMaterno"));
        		user.setNroDocumento(rs.getString("nroDocumento"));
        		user.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
        		user.setIdRol(rs.getInt("idRol"));
        		user.setEmail(rs.getString("email"));
        		user.setEstado(rs.getString("estado"));
                return user;
            }
        }, idUsuario);
		
				
		log.info("User found: " + user);
		
		return user;
	}
	
	public List<Usuario> listarUsuarios(){
		log.info("calling listarUsuarios: ");
		
		String sql = "SELECT * FROM usuario";
		
		List<Usuario> lista = jdbcTemplate.query(sql, new RowMapper<Usuario>() {
            public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException{
            	Usuario vo = new Usuario();
            	vo.setIdUsuario(rs.getInt("idUsuario"));
        		vo.setNombre(rs.getString("nombre"));
        		vo.setApellidoPaterno(rs.getString("apellidoPaterno"));
                return vo;
            }
        });
		
		log.info(lista);
		
		return lista;
	}
	
	
}
