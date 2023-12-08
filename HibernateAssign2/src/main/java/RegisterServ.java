

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mypack.Register;

import java.io.IOException;
import java.io.PrintWriter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Servlet implementation class RegisterServ
 */
public class RegisterServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	     try {
	            Configuration cfg = new Configuration();
	            cfg.configure("hibernate.cfg.xml");
	            SessionFactory factory = cfg.buildSessionFactory();
	            Session session = factory.openSession();
	        Transaction tr = session.beginTransaction();

	            response.setContentType("text/html");
	            
	            PrintWriter out = response.getWriter();
	            String name = request.getParameter("name");
	            String address = request.getParameter("address");
	            String email = request.getParameter("email");
	            String login = request.getParameter("login");
	            String password = request.getParameter("password");
	            
	            System.out.println(name);

	            Register register = new Register();
	            register.setName(name);
	            register.setAddress(address);
	            register.setEmail(email);
	            register.setLogin(login);
	            register.setPassword(password);
	            
	           System.out.println(register.getName());
	            session.persist(register);

	           tr.commit();
	            session.close();
		            
	            // Redirect to a success page or do further processing
	            response.sendRedirect("Success.jsp");
	            
	     }catch(Exception ee)
	     {
	    	 ee.printStackTrace();
	     }
	}

}
