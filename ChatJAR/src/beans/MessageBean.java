package beans;

import java.util.ArrayList;
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
import model.Message;

@Stateless
@Path("/messages")
@LocalBean
public class MessageBean implements MessageRemote, MessageLocal{

	@Context
	ServletContext ctx;
	
	@PostConstruct
	public void init() {
		if(ctx.getAttribute("messages") == null) {
			ctx.setAttribute("messages", new MessageData());
		}
	}
	
	@POST
	@Path("/all")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String sendToAll(Message m) {
		
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
		
		return m;
		
	}
	
	
}
