import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Dbcon {
	
	Connection conn;
	
	public void connection()
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn= DriverManager.getConnection("jdbc:mysql://localhost/book_db", "root", "1234");
		}
		catch(ClassNotFoundException | SQLException ex)
		{
			System.out.println("Error establishing connection: "+ex.getMessage());
			ex.printStackTrace();
		}
			
	}
	
	public void closeConnection() 
	{
		try {
		if(conn!= null) 
		{
			conn.close();
		}
		}
		catch(SQLException ex)
		{
			System.out.println("Error closing connection" + ex.getMessage());
		}
	}
	
	
	
	
	
	
	
}
