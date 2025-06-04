package pe.edu.upeu.enity;

public class Autores {
	private int idautores;
	private String nombres;
	private String apellidos;
	private String pais;
	private String estado;
	
	public Autores() {
		super();
	}

	public Autores(int idautores, String nombres, String apellidos, String pais, String estado) {
		super();
		this.idautores = idautores;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.pais = pais;
		this.estado = estado;
	}

	public int getIdautores() {
		return idautores;
	}

	public void setIdautores(int idautores) {
		this.idautores = idautores;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
}
