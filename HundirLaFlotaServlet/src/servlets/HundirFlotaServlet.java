package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import partidas.Partida;

/**
 * Servlet implementation class HundirFlotaServlet
 */
public class HundirFlotaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HundirFlotaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession(true);
		
		Partida partida = ( Partida ) session.getAttribute("partida");
		
		String cabecera;
		
		if ( partida == null ) {
			partida = new Partida(8, 8, 6);
			session.setAttribute( "partida", partida );			
		
		} else if ( partida.getQuedan() == 0 ) {
			String coords = request.getParameter( "pos" );
			String [] pos = coords.split( "," );
			partida.pruebaCasilla( Integer.parseInt( pos[ 0 ]) , Integer.parseInt( pos[ 1 ]) );
		}
		
		
		
		response.setContentType( "text/html" );
		ServletOutputStream out = response.getOutputStream();
		
		out.println( "<h1>Hundir la flota</h1>" );
		out.println( "<p>NUEVA PARTIDA"
				+ "<br>Barcos Navegando: " + partida.getQuedan() + " Barcos Hundidos: "
				+ ( partida.getNumBarcos() - partida.getQuedan() ) + "<br>Número de disparos efectuados: "
				+ partida.getDisparos() + "</p>" );
		
	}
	
	
}
