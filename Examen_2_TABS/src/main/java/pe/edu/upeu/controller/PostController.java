package pe.edu.upeu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import pe.edu.upeu.dao.PostDao;
import pe.edu.upeu.daoimpl.PostDaoImpl;
import pe.edu.upeu.enity.Post;
import pe.edu.upeu.enity.Usuario;

/**
 * Servlet implementation class PostController
 */
@WebServlet("/post")
public class PostController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private PostDao pdao = new PostDaoImpl();
    private Gson gson = new Gson();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PostController() {
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
		    out.println(gson.toJson(pdao.listarT()));
			break;
		case 2:
			int idp = Integer.parseInt(request.getParameter("id"));
			out.println(gson.toJson(pdao.listar(idp)));
			break;
		case 3:
		    Post post = new Post();
		    post.setTitulo(request.getParameter("titulo"));
		    post.setDescripcion(request.getParameter("descripcion"));
		    post.setIdusuario(Integer.parseInt(request.getParameter("idusuario")));
		    out.println(gson.toJson(pdao.agregar(post)));
		    break;
		case 4:
			Post post2 = new Post();
			post2.setIdpost(Integer.parseInt(request.getParameter("id")));
			post2.setTitulo(request.getParameter("titulo"));
		    post2.setDescripcion(request.getParameter("descripcion"));
		    post2.setIdusuario(Integer.parseInt(request.getParameter("idusuario")));
			out.println(gson.toJson(pdao.editar(post2)));
			break;
		case 5:
			out.println(gson.toJson(pdao.eliminar(Integer.parseInt(request.getParameter("id")))));
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
