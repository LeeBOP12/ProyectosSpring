package pe.edu.upeu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.dao.UsuarioDao;
import pe.edu.upeu.daoimpl.UsuarioDaoImpl;
import pe.edu.upeu.enity.Usuario;

/**
 * Servlet implementation class UsuarioController
 */
@WebServlet("/usuario")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UsuarioDao udao = new UsuarioDaoImpl();
	private Gson gson = new Gson();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UsuarioController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int op = Integer.parseInt(request.getParameter("opc"));
		switch (op) {
		case 1:
			out.println(gson.toJson(udao.listarT())); 
			break;
		case 2:
			int idu = Integer.parseInt(request.getParameter("id"));
			out.println(gson.toJson(udao.listar(idu)));
			break;
		case 3:
			Usuario nuevo = new Usuario();
			nuevo.setUsername(request.getParameter("nombre"));
			nuevo.setClave(request.getParameter("clave"));
			out.println(gson.toJson(udao.agregar(nuevo))); 
			break;

		case 4:
			Usuario actualizar = new Usuario();
			actualizar.setIdusuario(Integer.parseInt(request.getParameter("id"))); // Asignar ID
			actualizar.setUsername(request.getParameter("nombre")); // Asignar nombre
			actualizar.setClave(request.getParameter("clave")); // Asignar clave
			out.println(gson.toJson(udao.editar(actualizar))); // Actualizar usuario
			break;
		case 5:
			out.println(gson.toJson(udao.eliminar(Integer.parseInt(request.getParameter("id"))))); // Eliminar usuario
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
