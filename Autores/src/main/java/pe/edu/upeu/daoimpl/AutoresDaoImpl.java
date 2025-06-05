package pe.edu.upeu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.config.Conexion;
import pe.edu.upeu.dao.AutoresDao;
import pe.edu.upeu.enity.Autores;

public class AutoresDaoImpl implements AutoresDao {
	private Connection cn;
	private PreparedStatement pst;
	private ResultSet rs;
	
	@Override
	public boolean agregar(Autores t) {
		String sql = "INSERT INTO AUTORES (nombres, apellidos, pais, estado) VALUES (?, ?, ?, ?)";
		try {
			cn = Conexion.getConexion();
			pst = cn.prepareStatement(sql);
			pst.setString(1, t.getNombres());
			pst.setString(2, t.getApellidos());
			pst.setString(3, t.getPais());
			pst.setString(4, t.getEstado());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ERROR AL AGREGAR: "+e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public boolean editar(Autores t) {
		String sql = "UPDATE AUTORES SET nombres = ?, apellidos = ?, pais = ?, estado = ? WHERE IDAUTORES = ?";
		try {
			cn = Conexion.getConexion();
			pst = cn.prepareStatement(sql);
			pst.setString(1, t.getNombres());
			pst.setString(2, t.getApellidos());
			pst.setString(3, t.getPais());
			pst.setString(4, t.getEstado());
			pst.setInt(5, t.getIdautores());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ERROR AL EDITAR");
			return false;
		}
		return true;
	}

	@Override
	public boolean eliminar(int id) {
		String sql = "DELETE FROM AUTORES WHERE IDAUTORES = ?";
		try {
			cn = Conexion.getConexion();
			pst = cn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ERROR AL ELIMINAR");
			return false;
		}
		return true;
	}

	@Override
	public Autores listar(int id) {
		String sql = "SELECT * FROM AUTORES WHERE IDAUTORES = ?";
		Autores autores = new Autores();
		try {
			cn = Conexion.getConexion();
			pst = cn.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				autores.setIdautores(rs.getInt("idautores"));
				autores.setNombres(rs.getString("nombres"));
				autores.setApellidos(rs.getString("apellidos"));
				autores.setPais(rs.getString("pais"));
				autores.setEstado(rs.getString("estado"));
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL LISTAR : "+e);
		}
		return autores;
	}

	@Override
	public List<Autores> listarT() {
		String sql = "SELECT * FROM AUTORES";
		List<Autores> autors = new ArrayList<>();
		try {
			cn = Conexion.getConexion();
			pst = cn.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Autores autores = new Autores();
				autores.setIdautores(rs.getInt("idautores"));
				autores.setNombres(rs.getString("nombres"));
				autores.setApellidos(rs.getString("apellidos"));
				autores.setPais(rs.getString("pais"));
				autores.setEstado(rs.getString("estado"));
				autors.add(autores);
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL LISTAR : "+e);
		}
		return autors;
	}

}
