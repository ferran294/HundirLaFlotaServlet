package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import partidas.Partida;

/**
 * Servlet implementation class SolucionPartidaServlet
 */
public class SolucionPartidaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public SolucionPartidaServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Falta validar el codigo y excepcion por si la session no existe
		HttpSession sesion = request.getSession(false);
		Partida partida = (Partida) sesion.getAttribute("partida");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String[] vectorLetras = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q",
				"R", "S", "T" }; // Vector para un tablero max de 20x20
		int numFilas = partida.getNumFilas();
		int numColumnas = partida.getNumCol();

		// Falta arreglar el tema de sacar la solucion
		out.println("<html>");
		out.println("<head><title> Hundir la Flota</title></head>");
		out.println("<body align='center'>");
		out.println("<h1> Hundir la Flota</h1>");
		out.println("<br>");
		out.println("<p>Solucion PARTIDA</p><br>");
		out.println("<p>Barcos navegando: " + partida.getQuedan() + "  Barcos hundidos: "
				+ (partida.getNumBarcos() - partida.getQuedan()) + "</p><br>");
		out.println("<p>Numeros de disparos efectuados: " + partida.getDisparos() + "</p><br>");
		out.println("<table align='center'>");
		out.println("<tr>");
		out.println("<td></td>");

		for (int i = 0; i < numColumnas; i++) { // Escribe la primera fila que												// representa las letras
			out.println("<td align='center'>" + vectorLetras[i] + "</td>");
		}
		out.println("</tr>");
		for (int fila = 0; fila < numFilas; fila++) {
			out.println("<tr>");
			out.println("<td align='center'>" + fila + "</td>");
			for (int col = 0; col < numColumnas; col++) {
				if (partida.getCasilla(fila, col) != -1) {
					out.println("<td style='background-color:red'></td>");
				}else{
					out.println("<td style='background-color:blue'></td>");
				}
			}
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("<br>");
		out.println("<a href='NuevaPartidaServlet'>Nueva Partida</a>");
		out.println("<a href='SalirPartidaServlet'>Salir</a>");
		out.println("</body>");
		out.println("</html>");

	}

}
