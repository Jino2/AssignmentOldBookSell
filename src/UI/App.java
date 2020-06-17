package UI;

import java.util.Scanner;
import BookSell.*;

public class App {
	User user;
	UserSystem userSystem;
	BookSellManager bookManager;
	public App()
	{
		userSystem = new UserSystem();
		bookManager = new BookSellManager();
		//field var declare
	}
	public void index()
	{
		int index;
		Scanner scan = new Scanner(System.in);
		boolean b = true;
		
		//log in sequence...
		while(b)
		{
			
			System.out.println("1. Login 2. Register 3. Exit");
			index = scan.nextInt();

			if(index == 1)
			{
				System.out.println("Login");
				b=!(this.LogIn());
			}
			else if (index == 2)
			{
				System.out.println("Register");
				this.Register();
			}
			else if(index == 3)
			{
				System.out.println("Exit...");
				System.exit(0);
			}
		}
		
		//application sequence...
		if(!this.user.getID().equals("admin"))
		{
			this.main_1();
		}
		else
		{
			this.main_2();
		}
	}
	boolean LogIn()
	{
		String id,password;
		Scanner scan = new Scanner(System.in);
		System.out.println("ID: ");
		id = scan.next();
		System.out.println("PW: ");
		password = scan.next();
		if(this.userSystem.Find(id, password))
		{
			GeneralUser t = this.userSystem.Find(id);
			this.user = t;
			if(t.isActive())
				return true;
			else
				return false;
		}
		else if(id.equals("admin") && password.equals("nayana"))
		{
			this.user = new Admin(this.userSystem);
			return true;
		}
		else
		{
			System.out.println("Wrong Account");
			return false;
		}
	}
	void Register()
	{
		String id,password, name, email,telephone;
		Scanner scan = new Scanner(System.in);
		System.out.println("ID:");
		id = scan.next();
		System.out.println("PW:");
		password = scan.next();
		System.out.println("Name:");
		name = scan.next();
		System.out.println("E-mail");
		email = scan.next();
		System.out.println("Telephone Number:");
		telephone = scan.next();
		if(!this.userSystem.Find(id, password))
		{
			//no such id,password
			GeneralUserDescription desc = new GeneralUserDescription(name, telephone, email);
			GeneralUser t = new GeneralUser(desc,id,password);
			this.userSystem.RegisterAcc(t);
			System.out.println("Register Success!!");
		}
		else
		{
			System.out.println("Already exist Account(id,pw)");
		}
		
	}
	void main_1()
	{
		int index=0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1. Search Book Sell");
		System.out.println("2. Create Book Sell");
		System.out.println("3. Delete Book Sell");
		System.out.println("4. Update Book Sell");
		System.out.println("5. Purchase");
		System.out.println("6. Index Page");
		index = scan.nextInt();
		switch (index)
		{
		case 1:
			this.bookManager.printAllSell();
			this.main_1();
			break;
		case 2:
			this.CreateBookSell();
			this.main_1();
			break;
		case 3:
			this.DeleteBookSell(false);
			this.main_1();
			break;
		case 4:
			this.UpdateBookSell();
			this.main_1();
			break;
		case 5:
			this.Purchase();
			this.main_1();
			break;
		case 6:
			this.index();
			break;
		default:
			System.out.println("Exit..");
			System.exit(0);
		}
	}
	void main_2()
	{
		int index=0;
		Scanner scan = new Scanner(System.in);
		
		System.out.println("1. Search Book Sell");
		System.out.println("2. Delete Book Sell");
		System.out.println("3. Search General Users");
		System.out.println("4. Delete General Users");
		System.out.println("5. Index Page");

		index = scan.nextInt();
		switch (index)
		{
		case 1:
			this.bookManager.printAllSell();
			this.main_2();
			break;
		case 2:
			this.DeleteBookSell(true);
			this.main_2();
			break;
		case 3:
		case 4:
		case 5: 
			this.user =null;
			this.index();
		default:
		}
	}
	void CreateBookSell()
	{
		String SellerID, title, ISBN, author, publisher,state;
		int publicYear, price, serialNum;
		Scanner scan = new Scanner(System.in);
		
		SellerID = this.user.getID();
		serialNum = this.bookManager.RecentSerial();
		System.out.println("Title:");
		title = scan.next();
		System.out.println("ISBN:");
		ISBN = scan.next();
		System.out.println("Author:");
		author = scan.next();
		System.out.println("publisher:");
		publisher = scan.next();
		System.out.println("Publication Year:");
		publicYear = scan.nextInt();
		System.out.println("PRice:");
		price = scan.nextInt();
		System.out.println("State:");
		state = scan.next();

		GeneralUser user_t = (GeneralUser) this.user;
		BookSell sell_t = 	new BookSell(SellerID,title,ISBN,author,publisher,publicYear,price,state,serialNum);
		if(this.bookManager.insBookSell(sell_t))
		{
			user_t.insBookSell(sell_t.getSerial());
		}		
	}
	void DeleteBookSell(boolean isAdmin)
	{
		int serial2del;
		boolean canDel;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Insert Seiral Number to Delete:");
		serial2del = scanner.nextInt();

		GeneralUser t;
		if(isAdmin)
		{
			BookSell sell_t = this.bookManager.Find(serial2del);
			String sellerID = sell_t.getSellerID();
			t=this.userSystem.Find(sellerID);
			canDel = t.delBookSell(serial2del);
		}
		else
		{
			t = (GeneralUser)this.user;
			canDel = t.delBookSell(serial2del);
		}
		if(canDel)
		{
			this.bookManager.delBookSell(serial2del);
			System.out.println("Successfully Delete!");
		}
		else
		{
			System.out.println("Fail to Delete");
		}
	}

	void UpdateBookSell()
	{
		int serial2up;
		boolean canUp;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Insert Serial Number to Update:");
		serial2up = scanner.nextInt();
		
		GeneralUser t = (GeneralUser)this.user;
		canUp = t.Find(serial2up);
		if(canUp)
		{
			BookSell sell_t = this.bookManager.Find(serial2up);
			System.out.println("Update Data");
			System.out.println("1. Title 2. ISBN 3. AUTHOR 4. PUBLISHER 5. PUBLICATION YEAR 6. PRICE 7. STATE");
			int index = scanner.nextInt();
			switch(index)
			{
			case 1:
				System.out.println("Title to Change");
				String title = scanner.next();
				sell_t.setTitle(title);
				break;
			case 2:
				System.out.println("ISBN to Change");
				String isbn = scanner.next();
				sell_t.setISBN(isbn);
				break;
			case 3:
				System.out.println("Author to Change");
				String author = scanner.next();
				sell_t.setAuthor(author);
				break;
			case 4:
				System.out.println("PUBLISHER to Change");
				String p = scanner.next();
				sell_t.setPublisher(p);;
				break;
			case 5:
				System.out.println("PUBLICATION YEAR to Change");
				int y = scanner.nextInt();
				sell_t.setPublicYear(y);
				break;
			case 6:
				System.out.println("PRICE to Change");
				int price = scanner.nextInt();
				sell_t.setPrice(price);
				break;
			case 7:
				System.out.println("STATE to Change");
				String state = scanner.next();
				sell_t.setTitle(state);
				break;
			}
		}
		else
		{
			System.out.println("Wrong Input");
		}
	}
	void Purchase()
	{
		String buyerID=this.user.getID();
		String sellerID;
		int serial2pur;
		Scanner scanner = new Scanner(System.in);
				
		System.out.println("Insert Seiral Number to Purchase:");
		serial2pur = scanner.nextInt();
		
		BookSell sell_t = this.bookManager.Find(serial2pur);
		if(sell_t == null)
		{
			System.out.println("No Sell data");
		}
		else 
		{
			sellerID = sell_t.getSellerID();
			System.out.println("Seller : "+this.userSystem.getEmail(sellerID)+", Buyer : "+ this.userSystem.getEmail(buyerID));
		}
	}
}
