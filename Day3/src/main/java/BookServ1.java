

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
public class BookServ1 extends HttpServlet {
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
			
			
			PreparedStatement pst=con.prepareStatement("Select * from book");
			
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				int id=rs.getInt(1);
				String BookName=rs.getString(2);
				
				String AuthorName=rs.getString(4);
				int Price=rs.getInt(3);
				pw.println(id+"\t"+BookName+"\t"+AuthorName+"\t"+Price);
			}	
			
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
	}

}
