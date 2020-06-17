package BookSell;

import java.util.Vector;

public class GeneralUserDescription {
	String name;
	String Telephone;
	Vector<Integer> sellBook = new Vector<Integer> ();
	String Email;
	boolean active;
	
	public GeneralUserDescription(String name, String tel, String mail)
	{
		this.name = name;
		this.Telephone = tel;
		this.Email = mail;
		this.active = true; 
	}
	public GeneralUserDescription(String name, String tel, String mail, boolean a)
	{
		this.name = name;
		this.Telephone = tel;
		this.Email = mail;
		this.active = a; 
	}
	public boolean changeActive()
	{
		this.active = !this.active;
		return true;
	}
	void delSellBook(int serialNum)
	{
		Integer temp=this.Find(serialNum);
		this.sellBook.remove(temp);
	}
	void insSellBook(int serialNum)
	{
		Integer temp=this.Find(serialNum);
		if(temp == null)
		{
			this.sellBook.add((Integer)serialNum);
		}
	}
	Integer Find(int num)
	{
		for(Integer i : this.sellBook)
		{
			if(i == num)
				return i;
		}
		return null;
	}	
}
