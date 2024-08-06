import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Operations {
	
	ResultSet rs;
	
	PreparedStatement pst;
	
	Scanner scan = new Scanner(System.in);
	
	Books b = new Books();
	
	Dbcon db = new Dbcon();
	
	public void Insert()
	{
		db.connection();
		try {
			
		System.out.print("Please Enter a Email Id");
		 b.Setemailid(scan.nextLine());
		 System.out.println("EmailID " +b.Getemailid());
		 
		 
		String 	qry = "SELECT user_emailId FROM book_tbl WHERE user_emailId = ?";
		
		pst = db.conn.prepareStatement(qry);
		pst.setString(1, b.Getemailid());
		rs= pst.executeQuery();
		rs = pst.getResultSet();
		if(rs.next())
		{
			System.out.println("Email already exists");
			System.out.println("Please enter a Valid EmailID");
			b.Setemailid(scan.nextLine());
		
			
			System.out.println("Please Enter book price:");
			b.Setbookprice(Integer.parseInt(scan.nextLine())); 
		
			System.out.print("Please Enter book name:");
			b.Setbookname(scan.nextLine());
			 
			
			System.out.println("Please Enter book author name:");
			b.Setbookauthor(scan.nextLine());			

		 String query = "INSERT INTO book_tbl(user_emailId,book_name,book_price,book_author) VALUES (?,?,?,?)";
		 pst =db.conn.prepareStatement(query);
		 pst.setString(1, b.Getemailid());
		 pst.setString(2,b.Getbookname());
		 pst.setInt(3, b.Getbookprice());
		 pst.setString(4, b.Getbookauthor());
		 
			 int rows;
			rows = pst.executeUpdate(); 
			 if(rows > 0) 
			 {
				 System.out.println("record inserted ");
			 }
			 else
			 {
				 System.out.println("record not inserted ");
			 }
			 
			 db.conn.close();
		
		}
		}
			 
		 catch(SQLException ex)
		 {
			 System.out.println("ERROR" +ex.getMessage());
		 }	 
		finally
		{
			db.closeConnection();
		}
	
		
		}
			
	

	
	public void Update()
	{
			db.connection();
			try {
				System.out.println("Please Enter Updated book ID:");
				 b.Setbookid(scan.nextInt());
		
				 System.out.println("Please Enter Updated book price:");
				 b.Setbookprice(scan.nextInt());
		
				 System.out.print("Please Enter Updated book name:");
				 b.Setbookname(scan.nextLine());
			 
			
				 System.out.print("Please Enter Updated author name:");
				 b.Setbookauthor(scan.nextLine());			

		 String query = "UPDATE book_tbl SET book_name = ?, book_price = ?, book_author = ? WHERE book_id = ?";
		 pst = db.conn.prepareStatement(query);
		 pst.setString(1, b.Getbookname());
		 pst.setInt(2, b.Getbookprice());
		 pst.setString(3, b.Getbookauthor());
		 pst.setInt(4, b.getbookid());
			 int rows;
			rows = pst.executeUpdate();
			 
			 if(rows > 0) 
			 {
				 System.out.println("record Updated ");
			 }
			 else
			 {
				 System.out.println("record not Updated successfully ");
			 }
			 db.conn.close();
		 }
		 catch(SQLException ex)
		 {
			 System.out.println("ERROR in update method"+ex.getMessage());
		 }	 
			finally
			{
				db.closeConnection();
			}
	}
	
	public void Delete()
	{
		db.connection();
		try {
		System.out.print("Please Enter book id:");
		b.Setbookid(scan.nextInt());
		
		String query = "DELETE FROM book_tbl WHERE book_id = ?";
		pst= db.conn.prepareStatement(query);
		pst.setInt(1, b.getbookid());		
		
			int rows;
			rows = pst.executeUpdate();
			 if(rows > 0) {
				 System.out.println("Record  Deleted successfully");
			 }
			 else {
				 System.out.println("Failed to Delete Record");
			 }
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		finally
		{
			db.closeConnection();
		}
	}
	
	public void SearchbyId() 
	{
		db.connection();
		try {
		System.out.print("Please Enter book id:");
		b.Setbookid(scan.nextInt());
		
		String query = "SELECT * FROM book_tbl WHERE book_id = ?";
		pst = db.conn.prepareStatement(query);
		pst.setInt(1, b.getbookid());
		rs = pst.executeQuery();
		
			 if(!rs.next()) {
				 System.out.println("Record not Found");
			 }
		 else {
				 rs = pst.getResultSet();
				 System.out.println("Record found successfully");
					int id = b.getbookid();
					String name = rs.getString("book_name");
					int price = rs.getInt("book_price");
					String autname = rs.getString("book_author");
					String email = rs.getString("user_emailId");
					
					System.out.println("Book ID:"+id+ "Email Id:"+email + "/nBook Name:"+ name + "/nBook Price:" +price+ "/nAuthor Name:"+autname);
					
			 }
		} catch (SQLException ex) 
		{
			System.out.println("ERROR in SearchById Method"+ex.getMessage());
		}
		finally
		{
			db.closeConnection();
		}
	}
	
	
}
