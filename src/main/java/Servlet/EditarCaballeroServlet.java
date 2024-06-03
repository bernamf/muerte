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
 * Servlet implementation class EditarCaballeroServlet
 */
@WebServlet("/EditarCaballeroServlet")
public class EditarCaballeroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditarCaballeroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 String idParam = request.getParameter("id");
	        int id = Integer.parseInt(idParam);
	        CaballeroDAO caballeroDAO = new CaballeroDAO();
	        Caballero caballero = caballeroDAO.obtenerCaballeroPorId(id);

	        request.setAttribute("caballero", caballero);
	        request.getRequestDispatcher("/editarCaballero.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idParam = request.getParameter("id");
        String nombre = request.getParameter("nombre");
        String fuerzaParam = request.getParameter("fuerza");
        String experienciaParam = request.getParameter("experiencia");
        String armaIdParam = request.getParameter("arma_id");
        String escudoIdParam = request.getParameter("escudo_id");

        int id = Integer.parseInt(idParam);
        int fuerza = Integer.parseInt(fuerzaParam);
        int experiencia = Integer.parseInt(experienciaParam);
        int armaId = Integer.parseInt(armaIdParam);
        int escudoId = Integer.parseInt(escudoIdParam);

        Caballero caballero = new Caballero(id, nombre, fuerza, experiencia, new Arma(armaId, null, 0, null), new Escudo(escudoId, null, 0));

        CaballeroDAO caballeroDAO = new CaballeroDAO();

        try {
            caballeroDAO.actualizarCaballero(caballero);
            response.sendRedirect("VerCaballeroServlet");
        } catch (Exception e) {
            request.setAttribute("error", "Error al actualizar el caballero.");
            request.getRequestDispatcher("/editarCaballero.jsp").forward(request, response);
        }
    }
}
	

