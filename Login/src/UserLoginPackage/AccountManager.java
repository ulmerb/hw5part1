package UserLoginPackage;

import java.util.HashMap;
import java.util.Map;

public class AccountManager {
	Map<String, String> accounts;
	
	public AccountManager(){
		accounts = new HashMap<String, String>();
		accounts.put("Patrick", "1234");
		accounts.put("Molly", "FloPup");
	}
	
	public void addAccount(String name, String password){
		accounts.put(name, password);
	}
	
	public boolean correctPassword(String name, String password){
		if (!accountExists(name)) return false;
		if (accounts.get(name).equals(password)) return true;
		return false;
	}
	
	public boolean accountExists(String name){
		if (accounts.containsKey(name)) return true;
		return false;
	}
}
