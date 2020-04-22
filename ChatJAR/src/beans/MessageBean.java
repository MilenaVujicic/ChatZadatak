package beans;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import data.MessageData;
import data.UserData;
import model.Message;
import model.User;

@Stateless
@Path("/messages")
@LocalBean
public class MessageBean implements MessageRemote, MessageLocal{

	@Context
	ServletContext ctx;
	
	@PostConstruct
	public void init() {
		if(ctx.getAttribute("messages") == null) {
			ctx.setAttribute("messages", MessageData.getInstance());
		}
		if(ctx.getAttribute("users") == null) {
			ctx.setAttribute("users", UserData.getInstance());
			System.out.println("UserDataMessage");
		}
	}
	
	@POST
	@Path("/all")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String sendToAll(Message m) {
		Calendar c = Calendar.getInstance();
		String content = m.getContent();
		String subject = m.getSubject();
		User sender = m.getSender();
		MessageData msgData = (MessageData) ctx.getAttribute("messages");
		UserData userData = (UserData) ctx.getAttribute("users"); 
		for(User u : userData.getAllUsers().values()) {
			Message msg = new Message();
			msg.setContent(content);
			msg.setDateCreated(c);
			msg.setReceiver(u);
			msg.setSender(sender);
			msg.setSubject(subject);
			msgData.getReceivedMessages().put(msg, u.getUsername());
			msgData.getSentMessages().put(msg, sender.getUsername());
		}
		return "success";
	}
	
	@POST
	@Path("/{user}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String sendToUser(@PathParam("user") String username, Message m) {
		return "success";	
	}
	
	@GET
	@Path("/{user}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> allUserMessages(@PathParam("user") String username) {
		List<Message> m = new ArrayList<Message>();
		MessageData msgData = (MessageData) ctx.getAttribute("messages");
		for(Message msg : msgData.getReceivedMessages().keySet()) {
			if(msg.getReceiver().getUsername().equals(username))
					m.add(msg);
		}
		return m;
		
	}
	
	
}
