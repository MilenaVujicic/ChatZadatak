package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import model.Message;

public class MessageData {
	private HashMap<Message, String> sentMessages;
	private HashMap<Message, String> receivedMessages;
	
	private static MessageData instance = null;
	
	public MessageData() {
		
		sentMessages = new HashMap<Message, String>();
		receivedMessages = new HashMap<Message, String>();
	}
	
	public List<Message> userSentMessages(String username){
		List<Message> retVal = new ArrayList<Message>();
		
		for(Message m : sentMessages.keySet()) {
			if(sentMessages.get(m).equals(username))
				retVal.add(m);
		}
		
		return retVal;
	}
	
	public List<Message> userReceivedMessages(String username){
		List<Message> retVal = new ArrayList<Message>();
		
		for(Message m : receivedMessages.keySet()) {
			if(receivedMessages.get(m).equals(username))
				retVal.add(m);
		}
		
		return retVal;
	}

	public HashMap<Message, String> getSentMessages() {
		return sentMessages;
	}

	public void setSentMessages(HashMap<Message, String> sentMessages) {
		this.sentMessages = sentMessages;
	}

	public HashMap<Message, String> getReceivedMessages() {
		return receivedMessages;
	}

	public void setReceivedMessages(HashMap<Message, String> receivedMessages) {
		this.receivedMessages = receivedMessages;
	}
	
	public static MessageData getInstance() {
		if(instance == null) {
			instance = new MessageData();
		}
		
		return instance;
	}
	
	
}
