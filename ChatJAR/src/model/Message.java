package model;

import java.util.Calendar;

public class Message {

	private User reviecer;
	private User sender;
	private Calendar dateCreated;
	private String subject;
	private String content;
	
	public Message() {
		super();
	}

	public Message(User reviecer, User sender, Calendar dateCreated, String subject, String content) {
		super();
		this.reviecer = reviecer;
		this.sender = sender;
		this.dateCreated = dateCreated;
		this.subject = subject;
		this.content = content;
	}

	public User getReviecer() {
		return reviecer;
	}

	public void setReviecer(User reviecer) {
		this.reviecer = reviecer;
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
