import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.*;

public class Pagination {
	
	ResultSet rs;
	Connection conn;
	PreparedStatement pst;
	Scanner scan = new Scanner(System.in);
	Dbcon db = new Dbcon();

	public List<Books> viewAllBooks(int offset , int noOfRecords)
	{
		int record;
		record = (offset*noOfRecords)-noOfRecords;
		String query = "SELECT * FROM book_tbl LIMIT ? OFFSET ?";
		
		List<Books> list = new ArrayList<Books>();
		Books book = null;
		try 
		{
			db.connection();
			pst = db.conn.prepareStatement(query);
			pst.setInt(1,noOfRecords);
			pst.setInt(2,record);
			rs = pst.executeQuery();
			if(!rs.next())
			{
				System.out.println("Record not Found");
			}
			
			else
			{
//				System.out.println(" BookID  BookName ");
			do
				{
				
					
					 book = new Books();
					 book.Setbookid(rs.getInt(1)); 
		             book.Setbookname(rs.getString(2));
		             book.Setbookprice(rs.getInt(3));
		             book.Setbookauthor(rs.getString(4));
		            list.add(book);
		            
		                System.out.println("BookID " + book.getbookid());
						System.out.println("Book Name " + book.Getbookname());
						System.out.println("Book Price " + book.Getbookprice());
						System.out.println("Book Author " + book.Getbookauthor());
						System.out.println("--------------------------");
				}
			while(rs.next());
				rs.close();	
			}
			
		}
		
		catch(SQLException ex)
		{
			System.out.println("ERROR in getting all records" + ex.getMessage());
			ex.printStackTrace();
		}
		finally
		{
			db.closeConnection();
		}
		return list;	
	}
}
