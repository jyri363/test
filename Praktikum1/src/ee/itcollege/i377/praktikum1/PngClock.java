package ee.itcollege.i377.praktikum1;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class PngClock
 */
@WebServlet("/PngClock")
public class PngClock extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("image/png");
		 OutputStream out = response.getOutputStream();
		RenderedImage rendImage1 = myCreateImage();
			// Write generated image to a file
			try {
				ImageIO.write((java.awt.image.RenderedImage) rendImage1, "png",out);
			} catch (IOException e) {
			}
	}

	// Returns a generated image.
	public static RenderedImage myCreateImage() {
	    int width = 120;
	    int height = 100;

	    // Create a buffered image in which to draw
	    BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

	    // Create a graphics contents on the buffered image
	    Graphics2D g2d = bufferedImage.createGraphics();

	    // Draw graphics
	    g2d.setColor(Color.white);
	    g2d.fillRect(0, 0, width, height);
	    g2d.setColor(Color.black);
	    g2d.drawString(getDateTime(), 0, 50);

	    // Graphics context no longer needed so dispose it
	    g2d.dispose();

	    return bufferedImage;
	}

}
