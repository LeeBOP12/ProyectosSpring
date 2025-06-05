package pe.edu.upeu.enity;

public class Post {
	private int idpost;
	private String titulo;
	private String descripcion;
	private int idusuario;
	public Post() {
		super();
	}
	public Post(int idpost, String titulo, String descripcion, int idusuario) {
		super();
		this.idpost = idpost;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.idusuario = idusuario;
	}
	public int getIdpost() {
		return idpost;
	}
	public void setIdpost(int idpost) {
		this.idpost = idpost;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	
	
}
