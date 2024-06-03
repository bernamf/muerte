package Servlet;



import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Caballero;
import modelo.dao.CaballeroDAO;

/**
 * Servlet implementation class VerCaballeroServlet
 */
@WebServlet("/VerCaballeroServlet")
public class VerCaballeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**r
     * @see HttpServlet#HttpServlet()
     */
    public VerCaballeroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		CaballeroDAO caballeroDAO = new CaballeroDAO();
        ArrayList<Caballero> caballeros = caballeroDAO.getAllCaballeros();

        request.setAttribute("caballeros", caballeros);
        request.getRequestDispatcher("/verCaballeros.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
