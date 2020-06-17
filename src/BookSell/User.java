package BookSell;

public class User 
{
	private String ID;
	private String password;
	
	public User(String id, String password)
	{
		this.ID = id;
		this.password = password;
	}
	public String getID()
	{
		return this.ID;
	}
	public String getPassword()
	{
		return this.password;
	}
}
