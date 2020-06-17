package BookSell;

import java.util.Vector;

public class BookSellManager {
	Vector<BookSell> sellList;
	int recentSerialNumber;
	public BookSellManager()
	{
		this.sellList = new Vector<BookSell>();
		this.recentSerialNumber = 0;
	}
	public boolean insBookSell(BookSell sell)
	{
		BookSell t = this.Find(sell.serialNumber);
		if(t != null)
		{
			//there exist sell
			return false;
		}
		else
		{
			this.sellList.add(sell);
			return true;
		}
		
	}
	public boolean delBookSell(int serialNum)
	{
		BookSell t = this.Find(serialNum);
		if(t!=null)
		{
			this.sellList.remove(t);
			return true;
		}
		else
		{
			return false;			
		}
	}
	
	public BookSell Find(int serialNum)
	{
		for(BookSell item:this.sellList)
		{
			if(item.serialNumber == serialNum)
				return item;
		}
		return null;
	}
	
	public void printAllSell()
	{
		if(this.sellList.size() == 0) 
		{
			System.out.println("No Data");
			return;
		}
		for(BookSell item:this.sellList)
		{
			item.printBookSell();
			System.out.println("------------------------");
		}
	}
	public int RecentSerial()
	{
		return this.recentSerialNumber++;
	}
}
