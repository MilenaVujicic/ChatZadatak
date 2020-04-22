package beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import data.UserData;
import model.User;

@Stateless
@Path("/users")
@LocalBean
public class UserBean implements UserRemote, UserLocal{
	
	@Context
	ServletContext ctx;
	
	@PostConstruct
	public void init() {
		if(ctx.getAttribute("users") == null) {
			ctx.setAttribute("users", new UserData());
		}
	}
	
	@POST
	@Path("/register")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String registerUser(User u) {
		UserData userData = (UserData) ctx.getAttribute("users");
		if(userData.userExists(u.getUsername())) {
			return "failure";
		}
		
		userData.getAllUsers().put(u.getUsername(), u);
		return "success";
	}
	
	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User logUser(User u) {
		User ret = null;
		UserData userData = (UserData) ctx.getAttribute("users");
		if(userData.userPassword(u.getUsername(), u.getPassword())) {
			if(!userData.getLoggedUsers().contains(u.getUsername())) {
				userData.getLoggedUsers().add(u.getUsername());
				ret = userData.getAllUsers().get(u.getUsername());
			}else {
				ret = userData.getAllUsers().get(u.getUsername());
			}
		}

		return ret;
	}
	
	@GET
	@Path("/loggedIn")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> loggedUsers(){
		List<User> u = new ArrayList<User>();
		UserData userData = (UserData) ctx.getAttribute("users");
		for(String username : userData.getLoggedUsers()) {
			u.add(userData.getAllUsers().get(username));
		}
		return u;
	}

	@GET
	@Path("/registered")
	@Produces(MediaType.APPLICATION_JSON)
	public List<User> registeredUsers(){
		List<User> u = new ArrayList<User>();
		UserData userData = (UserData) ctx.getAttribute("users");
		for(User user : userData.getAllUsers().values()) {
			u.add(user);
		}
		return u;
	}
	
	@DELETE
	@Path("/loggedIn/{user}")
	public void logout(@PathParam("user") String username) {
		UserData userData = (UserData) ctx.getAttribute("users");		
		
		for(String s : userData.getLoggedUsers()) {
			if(s.equals(username)) {
				userData.getLoggedUsers().remove(s);
				return;
			}
		}
	
	}
}
