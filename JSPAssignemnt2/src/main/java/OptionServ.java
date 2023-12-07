

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class OptionServ
 */
public class OptionServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String module = request.getParameter("module"); 
		
		if ("java".equals(module)) {
	            request.getRequestDispatcher("j2se.jsp").forward(request, response);
	        } else if ("C++".equals(module)) {
	            request.getRequestDispatcher("cplusplus.jsp").forward(request, response);
	        } else if ("oracle".equals(module)) {
	            request.getRequestDispatcher("ora.jsp").forward(request, response);
	        }
	}

}
