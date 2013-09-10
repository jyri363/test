package ee.itcollege.i377.praktikum1;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ReloadCounterServlet
 */
public class ReloadCounterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReloadCounterServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession sess = request.getSession();
		Integer c = (Integer) sess.getAttribute("c");
		if(c==null)
			c = new Integer(1);
		else
			c = new Integer(c.intValue()+1);
		sess.setAttribute("c",c);
		out.print("Sina oled siin  "+c+((c.intValue() == 1) ? ". kord." : ". korda."));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
