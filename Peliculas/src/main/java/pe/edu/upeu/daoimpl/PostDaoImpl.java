package pe.edu.upeu.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.upeu.config.Conexion;
import pe.edu.upeu.dao.PostDao;
import pe.edu.upeu.enity.Post;

public class PostDaoImpl implements PostDao {
	private Connection c;
	private PreparedStatement pst;
	private ResultSet rs;
	@Override
	public int agregar(Post t) {
		String sql = "INSERT INTO POST (titulo, descripcion, idusuario) VALUES (?, ?, ?)";
		int x = 0;
		try {
			c = Conexion.getConexion();
			pst = c.prepareStatement(sql);
			pst.setString(1, t.getTitulo());
			pst.setString(2, t.getDescripcion());
			pst.setInt(3, t.getIdusuario());
			x = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ERROR AL AGREGAR : "+e);
		}
		return x;
	}

	@Override
	public int editar(Post t) {
		String sql = "UPDATE POST SET titulo = ?, descripcion = ?, idusuario = ? where idpost = ?";
		int x = 0;
		try {
			c = Conexion.getConexion();
			pst = c.prepareStatement(sql);
			pst.setString(1, t.getTitulo());
			pst.setString(2, t.getDescripcion());
			pst.setInt(3, t.getIdusuario());
			pst.setInt(4, t.getIdpost());
			x = pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("ERROR AL EDITAR : "+e);
		}
		return x;
	}

	@Override
	public int eliminar(int id) {
		String sql = "DELETE FROM POST WHERE IDPOST = ?";
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
	public Post listar(int id) {
		String sql = "SELECT * FROM POST WHERE IDPOST = ?";
		Post post = new Post();
		try {
			c = Conexion.getConexion();
			pst = c.prepareStatement(sql);
			pst.setInt(1, id);
			rs = pst.executeQuery();
			while (rs.next()) {
				post.setIdpost(rs.getInt("idpost"));
				post.setTitulo(rs.getString("titulo"));
				post.setDescripcion(rs.getString("descripcion"));
				post.setIdusuario(rs.getInt("idusuario"));
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL LISTAR : "+e);
		}
		return post;
	}

	@Override
	public List<Post> listarT() {
		String sql = "SELECT * FROM POST";
		List<Post> posts = new ArrayList<>();
		try {
			c = Conexion.getConexion();
			pst = c.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				Post post = new Post();
				post.setIdpost(rs.getInt("idpost"));
				post.setTitulo(rs.getString("titulo"));
				post.setDescripcion(rs.getString("descripcion"));
				post.setIdusuario(rs.getInt("idusuario"));
				posts.add(post);
			}
		} catch (SQLException e) {
			System.out.println("ERROR AL LISTAR : "+e);
		}
		return posts;
	}

}
