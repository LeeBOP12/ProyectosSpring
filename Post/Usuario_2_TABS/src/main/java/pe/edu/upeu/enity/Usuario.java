package pe.edu.upeu.enity;

public class Usuario {
	private int idusuario;
	private String username;
	private String clave;
	public Usuario() {
		super();
	}
	public Usuario(int idusuario, String username, String clave) {
		super();
		this.idusuario = idusuario;
		this.username = username;
		this.clave = clave;
	}
	public int getIdusuario() {
		return idusuario;
	}
	public void setIdusuario(int idusuario) {
		this.idusuario = idusuario;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}

	
}
