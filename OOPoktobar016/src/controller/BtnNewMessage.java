package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Baza;
import view.InboxPage;
import view.NewMessagePage;

public class BtnNewMessage implements EventHandler<ActionEvent> {
	
	Baza baza;
	InboxPage inboxPage;
	
	public BtnNewMessage(InboxPage inboxPage) {
		this.inboxPage = inboxPage;
		baza = Baza.getInstance();
	}
	
	@Override
	public void handle(ActionEvent event) {
		NewMessagePage newMessage = new NewMessagePage(inboxPage.getThisUsr());
		inboxPage.hide();
		
	}

}
