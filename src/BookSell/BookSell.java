package BookSell;

public class BookSell {
	int serialNumber;
	BookSellDescription desc;
	
	public BookSell(String SellerID,String title,String ISBN,String author,String publisher,int publicYear,int price,String state,int serialNum)
	{
		this.serialNumber = serialNum;
		this.desc = new BookSellDescription(SellerID, title, ISBN, author, publisher, publicYear, price, state);
	}
	public void setTitle(String title)
	{
		this.desc.title=title;
	}
	public void setISBN(String isbn)
	{
		this.desc.ISBN=isbn;
	}
	public void setAuthor(String author)
	{
		this.desc.author=author;
	}
	public void setPublisher(String publisher)
	{
		this.desc.publisher = publisher;
	}
	public void setPublicYear(int y)
	{
		this.desc.publicYear=y;
	}
	public void setPrice(int p)
	{
		this.desc.price=p;
	}
	public void setState(String s)
	{
		this.desc.state=s;
	}
	public String getSellerID()
	{
		return this.desc.SellerID;
	}
	public int getSerial()
	{
		return this.serialNumber;
	}
	void printBookSell()
	{
		System.out.println("Serial Number:"+this.serialNumber);
		this.desc.printDesc();
	}
}
