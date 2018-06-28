package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Baza;
import view.InboxPage;

public class BtnPrikaziController implements EventHandler<ActionEvent> {
	
	Baza baza;
	InboxPage thisPage;
	
	public BtnPrikaziController(Baza baza, InboxPage thisPage) {
		this.baza = baza;
		this.thisPage = thisPage;
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		if(thisPage.getCmbInboxRoom().getSelectionModel().getSelectedItem().equals("Primljenje")) {
			thisPage.getTvEmail().setItems(thisPage.getThisUsr().getUserAccount_inboxMails());
		}else {
			thisPage.getTvEmail().setItems(thisPage.getThisUsr().getUserAccount_sendMails());
		}
		
	}
	
	
	
	
}
