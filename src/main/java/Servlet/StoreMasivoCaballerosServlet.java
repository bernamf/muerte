package Servlet;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class StoreMasivoCaballerosServlet
 */
@WebServlet("/StoreMasivoCaballerosServlet")
public class StoreMasivoCaballerosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StoreMasivoCaballerosServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/insertarMasivoCaballeros.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String caballerosParam = request.getParameter("caballeros");

		// Depuración: registro del parámetro recibido
		System.out.println("caballerosParam: " + caballerosParam);

		String[] caballerosLines = caballerosParam.split("\\r?\\n");

		ArrayList<Caballero> caballeros = new ArrayList<>();

		for (String line : caballerosLines) {
			try {
				String[] parts = line.split(",");
				String nombre = parts[0].trim();
				int fuerza = Integer.parseInt(parts[1].trim());
				int experiencia = Integer.parseInt(parts[2].trim());
				int armaId = Integer.parseInt(parts[3].trim());
				int escudoId = Integer.parseInt(parts[4].trim());

				Arma arma = new Arma(armaId, null, 0, null);
				Escudo escudo = new Escudo(escudoId, null, 0);
				Caballero caballero = new Caballero(0, nombre, fuerza, experiencia, arma, escudo);

				caballeros.add(caballero);
			} catch (Exception e) {
				break;
			}
		}

		CaballeroDAO caballeroDAO = new CaballeroDAO();
		try {
			caballeroDAO.insertCaballeros(caballeros);
		} catch (Exception e) {

		}
		request.getRequestDispatcher("VerCaballeroServlet").forward(request, response);

	}
}
