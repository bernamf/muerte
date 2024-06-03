package Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.bean.Arma;
import modelo.bean.Caballero;
import modelo.bean.Escudo;
import modelo.dao.CaballeroDAO;

/**
 * Servlet implementation class StoreCaballeroServlet
 */
@WebServlet("/StoreCaballeroServlet")
public class StoreCaballeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StoreCaballeroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String nombre = request.getParameter("nombre");
	        String fuerzaParam = request.getParameter("fuerza");
	        String experienciaParam = request.getParameter("experiencia");
	        String armaIdParam = request.getParameter("arma_id");
	        String escudoIdParam = request.getParameter("escudo_id");

	        try {
	            int fuerza = (fuerzaParam == null || fuerzaParam.isEmpty()) ? 0 : Integer.parseInt(fuerzaParam);
	            int experiencia = (experienciaParam == null || experienciaParam.isEmpty()) ? 0 : Integer.parseInt(experienciaParam);
	            int armaId = Integer.parseInt(armaIdParam);
	            int escudoId = Integer.parseInt(escudoIdParam);

	            Arma arma = new Arma(armaId, null, 0, null);
	            Escudo escudo = new Escudo(escudoId, null, 0);
	            Caballero caballero = new Caballero(0, nombre, fuerza, experiencia, arma, escudo);

	            CaballeroDAO caballeroDAO = new CaballeroDAO();
	            caballeroDAO.insertCaballero(caballero);

	            response.sendRedirect("VerCaballeroServlet");
	        } catch (Exception e) {
	            request.setAttribute("error", "Error al insertar el caballero. Verifique los datos e intente nuevamente.");
	            request.getRequestDispatcher("/CrearCaballeroServlet").forward(request, response);
	        }
	    }
}


