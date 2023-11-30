import java.sql.*;

class Product
{
	private int pid, qty;
	private double cost;
	private String  pname;
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Product(int pid, int qty, double cost, String pname)
	{
		this.pid=pid;
		this.qty=qty;
		this.cost=cost;
		this.pname=pname;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", qty=" + qty + ", cost=" + cost + ", pname=" + pname + "]";
	}
}	

public class d1q3 {

	public static void main(String[] args) 
	{
		String ss="jdbc:mysql://localhost:3306/jdbc";
		try(Connection con=DriverManager.getConnection(ss,"root","shantanu1"))
		{
			System.out.println("implemention class is "+con.getClass());
			Product prod=new Product(1,10,55.5,"Book");
			System.out.println("first instance: "+ prod);
			
			PreparedStatement pst=con.prepareStatement("insert into product values (?,?,?,?)");
			pst.setInt(1, prod.getPid());
			pst.setInt(2, prod.getQty());
			pst.setDouble(3, prod.getCost());
			pst.setString(4, prod.getPname());
			
			pst.executeUpdate();
			
			
			prod=null;
			
			PreparedStatement pst2 = con.prepareStatement("SELECT * FROM Product WHERE pid = ?");
	            pst2.setInt(1, 1); // 
	            ResultSet rs = pst2.executeQuery();

	            while (rs.next()) {
	                int pid = rs.getInt(1);
	                int qty = rs.getInt(2);
	                double cost = rs.getDouble(3);
	                String pname = rs.getString(4);

	     
	                Product retrievedprod = new Product(pid, qty, cost, pname);
	               System.out.println("Retrieved Product: " + retrievedprod);
					
	            	}
	          
			       
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		

	}
}