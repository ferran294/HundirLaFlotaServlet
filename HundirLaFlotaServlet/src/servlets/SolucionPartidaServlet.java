package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Falta validar el codigo y excepcion por si la session no existe
		HttpSession sesion= request.getSession(false);
		Partida partida=(Partida) sesion.getAttribute(partida);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		//Falta arreglar el tema de sacar la solucion
		out.println("<html>");
		out.println("<head><title> Hundir la Flota</title></head>");
		out.println("<body>");
		out.println("<h1> Hundir la Flota</h1>");
		out.println("<br>");
		out.println("<p>Solucion PARTIDA</p><br>");
		out.println("<p>Barcos navegando: "+partida.getQuedan()+"  Barcos hundidos: "+(partida.getNumBarcos()-partida.getQuedan())+"</p><br>");
		out.println("<p>Numeros de disparos efectuados: "+partida.getDisparos()+"</p>");
		
		
	}

}
