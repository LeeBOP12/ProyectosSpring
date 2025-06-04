package pe.edu.upeu.test;

import pe.edu.upeu.config.Conexion;

public class Test {
	public static void main(String[] args) {
		if (Conexion.getConexion()!=null) {
			System.out.println("CONECTADO :D");
		} else {
			System.out.println("DESCONECTADO :(");
		}
	}
}
