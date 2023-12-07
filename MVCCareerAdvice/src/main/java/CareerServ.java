

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mycareer.CareerExpert;

import java.io.IOException;

/**
 * Servlet implementation class CareerServ
 */
public class CareerServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		 // Get qualification details from the form
        int tenthMarks = Integer.parseInt(request.getParameter("tenthMarks"));
        int twelfthMarks = Integer.parseInt(request.getParameter("twelfthMarks"));

        // Create instance of CareerExpert
        CareerExpert expert = new CareerExpert();

        // Get career advice based on qualifications
        String advice = expert.getCareerAdvice(tenthMarks, twelfthMarks);

        // Add advice to request object attribute
        request.setAttribute("careerAdvice", advice);

        // Forward to CareerDetails.jsp
        RequestDispatcher dispatcher = request.getRequestDispatcher("CareerDetails.jsp");
        dispatcher.forward(request, response);
	}
	

}
