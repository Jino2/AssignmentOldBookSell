package BookSell;

public class Admin extends User {
	UserSystem userSystem;
	
	public Admin(UserSystem us)
	{
		super("admin","nayana");
		this.userSystem = us;
	}
}
