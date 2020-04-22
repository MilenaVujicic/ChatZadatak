package model;

import java.util.Calendar;

public class Message {

	private User receiver;
	private User sender;
	private Calendar dateCreated;
	private String subject;
	private String content;
	
	public Message() {
		super();
	}

	public Message(User receiver, User sender, Calendar dateCreated, String subject, String content) {
		super();
		this.receiver = receiver;
		this.sender = sender;
		this.dateCreated = dateCreated;
		this.subject = subject;
		this.content = content;
	}

	public User getReceiver() {
		return receiver;
	}

	public void setReceiver(User receiver) {
		this.receiver = receiver;
	}

	public User getSender() {
		return sender;
	}

	public void setSender(User sender) {
		this.sender = sender;
	}

	public Calendar getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Calendar dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	
}
