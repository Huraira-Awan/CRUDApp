
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Operations ops = new Operations();
		Pagination pg = new Pagination();
		
	try (Scanner scan = new Scanner(System.in)) {
		boolean bool= true;

			while(bool) 
			{
				System.out.println("1:Insert book record");
				System.out.println("2:Update book record");
				System.out.println("3:Delete book record");
				System.out.println("4:Search book record by id");
				System.out.println("5:To get all book records");
				System.out.println("6:Exit");
				int choice;
				
				System.out.print("Please enter your choice");
				choice = scan.nextInt();		
				
				
					switch (choice) 
					{
					case 1:
						
						ops.Insert();
							break;
						
					case 2:
						ops.Update();
							break;
						
					case 3:
						ops.Delete();
							break;
						
					case 4:
						ops.SearchbyId();
							break;
					case 5:
						
						System.out.println("Enter Page No: ");
						int offset = scan.nextInt();
						
						System.out.println("Enter No of records");
						int numofrecord = scan.nextInt();
						
						pg.viewAllBooks(offset, numofrecord);
						
							break;
					case 6:
						System.out.println("");
						bool = false;
						break;
					}
				
			}
	}	

	}

}
