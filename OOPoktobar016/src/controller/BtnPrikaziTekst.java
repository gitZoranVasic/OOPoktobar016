package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Baza;
import model.Email;
import view.InboxPage;

public class BtnPrikaziTekst implements EventHandler<ActionEvent> {

	Baza baza;
	InboxPage thisPage;
	
	public BtnPrikaziTekst(Baza baza, InboxPage thisPage) {
		this.baza = baza;
		this.thisPage = thisPage;
	}
	
	
	@Override
	public void handle(ActionEvent event) {
		Email email = thisPage.getTvEmail().getSelectionModel().getSelectedItem();
		thisPage.getTaEmailText().clear();
		thisPage.getTaEmailText().setText(email.getEmail_content());
		
	}

}
