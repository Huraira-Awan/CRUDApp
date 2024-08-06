
public class Books {
	String emailId;
	int bookId;
	String bookName;
	int bookPrice;
	String bookAuthor;
	
	public int getbookid()
	{
		return bookId;
	}
	public void Setbookid(int bookid)
	{
		this.bookId=bookid;
	}
	
	public String Getbookname() {return bookName;}
	public void Setbookname(String name) {
		this.bookName = name;
	}
	
	public int Getbookprice()
	{
		return bookPrice;
	}
	public void Setbookprice(int price)
	{
		this.bookPrice = price;
	}
	
	public String Getbookauthor() 
	{
		return bookAuthor;
	}
	
	public void Setbookauthor(String name) 
	{
		this.bookAuthor = name;
	}
	
	public String Getemailid()
	{
		return emailId;
	}
	
	public void Setemailid(String email)
	{
		this.emailId = email;
	}

}
