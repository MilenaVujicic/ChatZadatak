package beans;

import java.util.List;

import javax.ejb.Remote;

import model.Message;

@Remote
public interface MessageRemote {
	public String sendToAll(Message m);
	public String sendToUser(String username, Message m);
	public List<Message> allUserMessages(String username);
	
}
