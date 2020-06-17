package BookSell;

public class BookSellDescription {
	String title;
	String ISBN;
	String author;
	String SellerID;
	String publisher;
	int publicYear;
	int price;
	String state;
	public BookSellDescription(String SellerID,String title,String ISBN,String author,String publisher,int publicYear,int price,String state)
	{
		this.title =title;
		this.ISBN=ISBN;
		this.author=author;
		this.publisher=publisher;
		this.publicYear=publicYear;
		this.price=price;
		this.state=state;
		this.SellerID = SellerID;
	}
	void setDesc(String SellerID,String title,String ISBN,String author,String publisher,int publicYear,int price,String state)
	{
		this.title =title;
		this.ISBN=ISBN;
		this.author=author;
		this.publisher=publisher;
		this.publicYear=publicYear;
		this.price=price;
		this.state=state;
		this.SellerID = SellerID;
	}
	String getID()
	{
		return this.SellerID;
	}
	void printDesc()
	{
		System.out.println("Title: "+this.title);
		System.out.println("ISBN: "+this.ISBN);
		System.out.println("Author: "+this.author);
		System.out.println("Seller' ID: "+this.SellerID);
		System.out.println("Publisher: "+this.publisher);
		System.out.println("Publication Year: "+this.publicYear);
		System.out.println("PRICE: "+ this.price);
		System.out.println("STATE: "+this.state);
	}
}
