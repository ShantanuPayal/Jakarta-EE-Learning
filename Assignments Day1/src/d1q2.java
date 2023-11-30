import java.sql.*;
import java.util.*;
public class d1q2 {

	public static void main(String[] args) {
		
		String ss="jdbc:mysql://localhost:3306/jdbc";
		
		try(Connection con=DriverManager.getConnection(ss,"root","shantanu1"))
		{
			System.out.println("Implementation of class "+con.getClass());
			System.out.println("Enter the designamtion: ");
			Scanner sc=new Scanner(System.in);
			String des=sc.next();
			
			PreparedStatement pst=con.prepareStatement("select * from employee where desig=?");
			
			pst.setString(1,des);
			ResultSet rs=pst.executeQuery();
		    while (rs.next()) {
		      
		       int id=rs.getInt(1);
		       String name=rs.getString(2);
		       String desig=rs.getString(3);
		       System.out.println(id+"\t"+name+"\t"+desig);
		       
		    }
		}catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
}
