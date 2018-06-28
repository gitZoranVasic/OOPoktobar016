package model;

import javaFixEs.Datum;

public class Email {
	private String email_sendFrom;
	private String email_sendTo;
	private String email_header;
	private String email_content;
	private Datum  email_date;

	public Email(String email_sendFrom, String email_sendTo, String email_header, String email_content,
			Datum email_date) {
		this.email_sendFrom = email_sendFrom;
		this.email_sendTo = email_sendTo;
		this.email_header = email_header;
		this.email_content = email_content;
		this.email_date = email_date;
	}
	
	public String getEmail_sendFrom() {
		return email_sendFrom;
	}
	public String getEmail_sendTo() {
		return email_sendTo;
	}
	public String getEmail_header() {
		return email_header;
	}
	public String getEmail_content() {
		return email_content;
	}
	public Datum getEmail_date() {
		return email_date;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "from: " + email_sendFrom + " to: " + email_sendTo + " naslov: " + email_header;
	}
	
	
	
	
	
}
