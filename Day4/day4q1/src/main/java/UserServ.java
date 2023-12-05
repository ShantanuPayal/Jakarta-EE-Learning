

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import day4q1.UserFilter;

/**
 * Servlet implementation class UserServ
 */
public class UserServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			String uname=request.getParameter("uname");
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
		
			pw.println("in  servlet<br>");
			pw.println("<br>"+uname);
			
		}catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

}
