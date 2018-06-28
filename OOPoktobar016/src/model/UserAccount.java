package model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class UserAccount {
	
	private String userAccount_email;
	
	private ObservableList<Email> userAccount_sendMails;
	private ObservableList<Email> userAccount_inboxMails;
	
	public UserAccount(String userAccount_email) {
		
		this.userAccount_email = userAccount_email;
		
		userAccount_inboxMails = FXCollections.observableArrayList();
		userAccount_sendMails  = FXCollections.observableArrayList();
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof UserAccount) {
			UserAccount tempUsr = (UserAccount) obj;
			if(tempUsr.getUserAccount_email().equals(userAccount_email)) return true;
		}
		return false;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return userAccount_email;
	}	
	
	public String getUserAccount_email() {
		return userAccount_email;
	}

	public ObservableList<Email> getUserAccount_sendMails() {
		return userAccount_sendMails;
	}

	public ObservableList<Email> getUserAccount_inboxMails() {
		return userAccount_inboxMails;
	}
	
	
	
	
	
}
