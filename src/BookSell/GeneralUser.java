package BookSell;

public class GeneralUser extends User{
	GeneralUserDescription desc;
	
	public GeneralUser(GeneralUserDescription desc, String id, String password)
	{
		super(id,password);
		this.desc=desc;
	}
	
	String getEmail()
	{
		return this.desc.Email;
	}
	
	public boolean delBookSell(int serialNum)
	{
		Integer t = this.desc.Find(serialNum);
		if (t == null)
		{
			return false;
		}
		else 
		{
			this.desc.delSellBook(serialNum);
			return true;
		}
	}
	public boolean insBookSell(int serialNum)
	{
		Integer t = this.desc.Find(serialNum);
		if(t!=null)
		{
			//same thing exist
			return false;
		}
		else
		{
			//no such exist
			this.desc.insSellBook(serialNum);
			return true;
		}
	}
	public void changeActive()
	{
		this.desc.changeActive();
	}
	public boolean Find(int serialNum)
	{
		if(this.desc.Find(serialNum) == null)
			return false;
		return true;
	}
	public boolean isActive()
	{
		return this.desc.active;
	}
	void printUser()
	{
		System.out.println("ID : "+ this.getID());
		System.out.println("PW : "+ this.getPassword());
		this.desc.printDesc();
	}
}
