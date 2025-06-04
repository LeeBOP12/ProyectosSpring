package pe.edu.upeu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.config.Conexion;
import pe.edu.upeu.dao.UsuarioDao;
import pe.edu.upeu.enity.Usuario;

public class UsuarioDaoImpl implements UsuarioDao{
	private Connection c;
	private PreparedStatement pst;
	private ResultSet rs;
	
	@Override
	public int agregar(Usuario t) {
		String sql = "INSERT INTO USUARIO (username, clave) VALUES (?, ?)";
		int x = 0;
		try {
			c = Conexion.getConexion();
			pst = c.prepareStatement(sql);
			pst.setString(1, t.getUsername());
			pst.setString(2, t.getClave());
			x = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ERROR AL AGREGAR : "+e);
		}
		return x;
	}

	@Override
	public int editar(Usuario t) {
		String sql = "UPDATE USUARIO SET username = ?, clave = ? where idusuario = ?";
		int x = 0;
		try {
			c = Conexion.getConexion();
			pst = c.prepareStatement(sql);
			pst.setString(1, t.getUsername());
			pst.setString(2, t.getClave());
			pst.setInt(3, t.getIdusuario());
			x = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ERROR AL EDITAR : "+e);
		}
		return x;
	}

	@Override
	public int eliminar(int id) {
		String sql = "DELETE FROM USUARIO WHERE IDUSUARIO = ?";
		int x = 0;
		try {
			c = Conexion.getConexion();
			pst = c.prepareStatement(sql);
			pst.setInt(1, id);
			x = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ERROR AL ELIMINAR : "+e);
		}
		return x;
	}

	@Override
	public Usuario listar(int id) {
		String sql = "SELECT * FROM USUARIO WHERE IDUSUARIO = ?";
		Usuario usuario = new Usuario();
		try {
			c = Conexion.getConexion();
			pst = c.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				usuario.setIdusuario(rs.getInt("idusuario"));
				usuario.setUsername(rs.getString("username"));
				usuario.setClave(rs.getString("clave"));
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL LISTAR : "+e);
		}
		return usuario;
	}

	@Override
	public List<Usuario> listarT() {
		String sql = "SELECT * FROM USUARIO";
		List<Usuario> usuarios = new ArrayList<>();
		try {
			c = Conexion.getConexion();
			pst = c.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setIdusuario(rs.getInt("idusuario"));
				usuario.setUsername(rs.getString("username"));
				usuario.setClave(rs.getString("clave"));
				usuarios.add(usuario);
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL LISTAR : "+e);
		}
		return usuarios;
	}

}
