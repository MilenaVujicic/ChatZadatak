package beans;

import java.util.List;

import javax.ejb.Remote;

import model.User;

@Remote
public interface UserRemote {
	public String registerUser(User u);
	public String logUser(User u);
	public List<User> loggedUsers();
	public List<User> registeredUsers();
	public void logout();
}
