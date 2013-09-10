package ee.itcollege.i377.praktikum1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NameServlet
 */
@WebServlet("/NameServlet")
public class NameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><head><title>Tere!</title></head>");
		out.print("<body>");
		out.println("<form method=\"POST\" action=\"/Praktikum1/NameServlet\">" +
					"sisesta nimi: <input type=\"TEXT\" name=\"nimi\"><br />"+
					"<input type=\"SUBMIT\" value=\"vajuta siia!\">"+
				"</form>");
		out.print("</body>");
		out.print("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();

	    out.println("<title>Tere! Tere!</title>" +
	       "<body bgcolor=FFFFFF>");

	    out.println("Tere! ");

	    String NIMI = request.getParameter("nimi");

	    if(NIMI != ""){
	      out.println("<br>"+NIMI+"<br>");
	    } else {
	      out.println("Pole mida kuvada.");
	    }

	    out.println("<a href=\"./NameServlet\">Sisesta uuesti </a>");
	    out.close();
	}

}
