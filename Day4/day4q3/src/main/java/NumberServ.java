

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import day4q3pojo.NumberPojo;

/**
 * Servlet implementation class NumberServ
 */
public class NumberServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String num=request.getParameter("number");
		int ipnum=Integer.parseInt(num);
		
		NumberPojo np1=new NumberPojo();
		int sqr=np1.getSquare(ipnum);
		
		
		PrintWriter pw=response.getWriter();
		pw.println("in servlet");
		pw.println("<br>");
		pw.println("square of "+ num + "is equal to "+ sqr);
		
		
	}

}
