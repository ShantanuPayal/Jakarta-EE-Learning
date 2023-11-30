import java.sql.*;

public class d1q1{
    // JDBC URL, username, and password of the database
	public static void main(String[] args) {
		String ss="jdbc:mysql://localhost:3306/jdbc";
		try(Connection con=DriverManager.getConnection(ss,"root","shantanu1"))
		{
			System.out.println("implemention class is "+con.getClass());
			
			Statement st=con.createStatement();
			int val=st.executeUpdate("insert into student values(1,'shantanu',20)");
			if(val>0)
			{
				System.out.println("new row inserted");
			}
			int val1=st.executeUpdate("delete from student where name='John'");
			
			
			ResultSet rs=st.executeQuery("select * from student");
			while(rs.next())
			{
				int rollno=rs.getInt("rollno");
				String name=rs.getString(2);
				String age=rs.getString(3);
				System.out.println(rollno+"\t"+name+"\t"+age);
			}
		}catch(Exception ee)
		{
			System.out.println(ee);
		}
	}
}
