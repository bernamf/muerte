package Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Arma;
import modelo.bean.Escudo;
import modelo.dao.CaballeroDAO;

/**
 * Servlet implementation class CrearCaballeroServlet
 */
@WebServlet("/CrearCaballeroServlet")
public class CrearCaballeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrearCaballeroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		  CaballeroDAO armaDAO = new CaballeroDAO();
		  CaballeroDAO escudoDAO = new CaballeroDAO();

	        ArrayList<Arma> armas = armaDAO.getAllArmas();
	        ArrayList<Escudo> escudos = escudoDAO.getAllEscudos();

	        request.setAttribute("armas", armas);
	        request.setAttribute("escudos", escudos);
	        request.getRequestDispatcher("/crearCaballero.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
