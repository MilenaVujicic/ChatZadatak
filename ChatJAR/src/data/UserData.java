package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.User;

public class UserData {

	private HashMap<String, User> allUsers;
	private List<String> loggedUsers;
	
	public UserData() {
		allUsers = new HashMap<String, User>();
		loggedUsers = new ArrayList<String>();
		User admin = new User();
		admin.setUsername("admin");
		admin.setPassword("admin");
		allUsers.put("admin", admin);
	}
	
	
	public boolean userExists(String username) {
		for (User u : allUsers.values())
			if(u.getUsername().equals(username))
				return true;
		return false;
	}
	
	public boolean userPassword(String username, String password){
		if(userExists(username)) 
			if(allUsers.get(username).getPassword().equals(password))
				return true;
		return false;
		
	}


	public HashMap<String, User> getAllUsers() {
		return allUsers;
	}


	public void setAllUsers(HashMap<String, User> allUsers) {
		this.allUsers = allUsers;
	}


	public List<String> getLoggedUsers() {
		return loggedUsers;
	}


	public void setLoggedUsers(List<String> loggedUsers) {
		this.loggedUsers = loggedUsers;
	}
	
	
}
