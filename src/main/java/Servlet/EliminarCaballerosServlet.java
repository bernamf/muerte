package Servlet;



import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.CaballeroDAO;

/**
 * Servlet implementation class EliminarCaballerosServlet
 */
@WebServlet("/EliminarCaballerosServlet")
public class EliminarCaballerosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarCaballerosServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 final long serialVersionUID = 1L;
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String idParam = request.getParameter("id");

        if (idParam == null || idParam.trim().isEmpty()) {
            request.setAttribute("error", "ID no puede estar vacío.");
            request.getRequestDispatcher("/verCaballeros").forward(request, response);
            return;
        }

        int id = Integer.parseInt(idParam);
        CaballeroDAO caballeroDAO = new CaballeroDAO();

        try {
            caballeroDAO.eliminarCaballero(id);
            response.sendRedirect("VerCaballeroServlet");
        } catch (Exception e) {
            request.setAttribute("error", "Error al eliminar el caballero.");
            request.getRequestDispatcher("/verCaballeros").forward(request, response);
        }
    }
}

