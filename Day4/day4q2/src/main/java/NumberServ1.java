

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import numpack1.NumberPojo1;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class NumberServ1
 */
public class NumberServ1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
		String num=request.getParameter("number");
		int ipnum=Integer.parseInt(num);
		
		NumberPojo1 np1=new NumberPojo1();
		int sqr=np1.getSquare(ipnum);
		
		
		PrintWriter pw=response.getWriter();
		pw.println("in servlet");
		pw.println("<br>");
		pw.println("square of "+ num + "is equal to "+ sqr);
	}

}
