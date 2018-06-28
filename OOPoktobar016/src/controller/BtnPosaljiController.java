package controller;

import java.util.Calendar;

import javaFixEs.Datum;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Baza;
import model.Email;
import model.UserAccount;
import view.InboxPage;
import view.NewMessagePage;

public class BtnPosaljiController implements EventHandler<ActionEvent> {
		Baza baza;
		Datum todayDate;
		NewMessagePage page;
		
	public BtnPosaljiController(NewMessagePage page) {
		this.page = page;
		todayDate = new Datum(Calendar.getInstance().getTime());
		baza = Baza.getInstance();
		
		
	}

	@Override
	public void handle(ActionEvent event) {
		Email email = new Email(page.getFromUser().getUserAccount_email(),
								page.getTfPrimalac().getText(),
								page.getTfNaslov().getText(),
								page.getTaMessageBody().getText(),
								todayDate);
		
		page.getFromUser().getUserAccount_sendMails().add(email);
		baza.getUserAccounts().get(baza.getUserAccounts().indexOf(new UserAccount(page.getTfPrimalac().getText()))).getUserAccount_inboxMails().add(email);
		page.close();
		InboxPage.getInstance().setLblAmountOfMails();
		InboxPage.getInstance().getTvEmail().refresh();
		InboxPage.getInstance().show();
		baza.dodajMailUBazu(email);
		
	}
	
}
