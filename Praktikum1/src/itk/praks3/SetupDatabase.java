package itk.praks3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetupDatabase
 */
@WebServlet("/SetupDatabase")
public class SetupDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Class.forName("org.hsqldb.jdbcDriver");
			Connection conn = DriverManager.getConnection("jdbc:hsqldb:/home/hsqldb/testdb", "sa", "");
			response.setContentType("text/plain");
			PrintWriter out = response.getWriter();
			out.println("Using database: " +
			        conn.getMetaData().getDatabaseProductName() + " " +
			        conn.getMetaData().getDatabaseProductVersion() + " at " +
			        conn.getMetaData().getURL());
			Statement s = conn.createStatement();
			s.execute("CREATE TABLE guard (id IDENTITY, name VARCHAR(50), age INT)");
			s.execute("insert into guard values (1, 'Mõmmi', 12)");
			s.execute("insert into guard values (2, 'Leena', 16)");
			s.execute("insert into guard values (3, 'Paul', 20)");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
