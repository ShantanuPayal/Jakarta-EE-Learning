

import jakarta.servlet.ServletConfig;
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
import mypack.*;
/**
 * Servlet implementation class StudentGet
 */
public class StudentGet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Connection con;

	public void init()
	{
		try
		{
			con=SingletonCon.getCon();
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	
	}
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			PrintWriter pw=response.getWriter();
			
			
			PreparedStatement pst=con.prepareStatement("Select * from student");
			
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				int rollno=rs.getInt(1);
				String Name=rs.getString(2);
				int Age=rs.getInt(3);
				String Address=rs.getString(4);
				pw.println(rollno+"\t"+Name+"\t"+Age+"\t"+Address);
			}	
			
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

}
