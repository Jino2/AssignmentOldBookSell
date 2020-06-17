package BookSell;

import java.util.Vector;

public class UserSystem {
	Vector<GeneralUser> users; 
	
	public UserSystem()
	{
		users = new Vector<GeneralUser>();
		System.out.println("User system created");
	}
	public boolean RegisterAcc(GeneralUser u)
	{
		String inputId = u.getID();
		GeneralUser t = Find(inputId);
		if(t != null)
		{
			//there exist user
			return false;
		}
		else
		{
			//no such user
			this.users.add(u);
			return true;
		}
	}
	int[] DeleteAcc(String ID)
	{
		GeneralUser t = Find(ID);
		int sellBook[];
		if(t!=null)
		{
			//there exist user
			int size = t.desc.sellBook.size();
			sellBook = new int[size];
			for(int i =0;i<size;i++)
			{
				sellBook[i] = t.desc.sellBook.elementAt(i);
			}
			this.users.remove(t);
			return sellBook;
		}
		else
		{
			return null;
		}
	}
	boolean ChangeActive(String ID)
	{
		GeneralUser t = this.Find(ID);
		if(t!=null)
		{
			t.changeActive();
			return true;
		}
		else
		{
			return false;
		}
	}

	public GeneralUser Find(String ID)
	{
		for(GeneralUser item:this.users)
		{
			if(item.getID().equals(ID))
				return item;
		}
		return null;
	}
	public boolean Find(String ID, String password)
	{
		for(GeneralUser item:this.users)
		{
			if(item.getID().contentEquals(ID) && item.getPassword().equals(password))
				return true;
		}
		return false;
	}
	public String getEmail(String ID)
	{	
		GeneralUser t = this.Find(ID);
		return t.getEmail();
	}
}
