package pe.edu.upeu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.dao.AutoresDao;
import pe.edu.upeu.daoimpl.AutoresDaoImpl;
import pe.edu.upeu.enity.Autores;

/**
 * Servlet implementation class AutoresController
 */
@WebServlet("/autores")
public class AutoresController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AutoresDao autdao = new AutoresDaoImpl();
	private Gson gson = new Gson();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AutoresController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int op = Integer.parseInt(request.getParameter("opc"));
		switch (op) {
		case 1:
			out.println(gson.toJson(autdao.listarT())); 
			break;
		case 2:
			int idu = Integer.parseInt(request.getParameter("id"));
			out.println(gson.toJson(autdao.listar(idu)));
			break;
		case 3:
			Autores autores = new Autores();
			autores.setNombres(request.getParameter("nombres"));
			autores.setApellidos(request.getParameter("apellidos"));
			autores.setPais(request.getParameter("pais"));
			autores.setEstado(request.getParameter("estado"));
			out.println(gson.toJson(autdao.agregar(autores))); 
			break;

		case 4:
			Autores autores2 = new Autores();
			autores2.setIdautores(Integer.parseInt(request.getParameter("id"))); // Asignar ID
			autores2.setNombres(request.getParameter("nombres"));
			autores2.setApellidos(request.getParameter("apellidos"));
			autores2.setPais(request.getParameter("pais"));
			autores2.setEstado(request.getParameter("estado"));
			out.println(gson.toJson(autdao.editar(autores2)));
			break;
		case 5:
			out.println(gson.toJson(autdao.eliminar(Integer.parseInt(request.getParameter("id"))))); // Eliminar usuario
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
