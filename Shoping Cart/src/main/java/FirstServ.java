

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * Servlet implementation class FirstServ
 */

@WebServlet("/FirstServ")

public class FirstServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final String Url = "jdbc:mysql://localhost:3306/jdbc";
	   private static final String User = "root";
	    private static final String Password = "shantanu1";

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        Connection conn = null;


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(Url, User, Password);

            PreparedStatement pst = conn.prepareStatement("SELECT pname FROM Product");
            ResultSet rs = pst.executeQuery();

            ArrayList<String> productNames = new ArrayList<>();
            while (rs.next()) {
                productNames.add(rs.getString("pname"));
            }

            request.setAttribute("productNames", productNames);
            RequestDispatcher rd = request.getRequestDispatcher("Shop.jsp");
            rd.forward(request, response);

        

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
