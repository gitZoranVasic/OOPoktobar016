package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Baza;
import model.UserAccount;
import view.InboxPage;
import view.LoginPage;

public class BtnLoginController implements EventHandler<ActionEvent>{

	Baza baza;
	LoginPage loginPage;
	
	public BtnLoginController(Baza baza, LoginPage loginPage) {
		this.loginPage = loginPage;
		this.baza = baza;
	}
	
	@Override
	public void handle(ActionEvent event) {
		doIt();
	}
	
	private void doIt() {
		UserAccount tempAcc = new UserAccount(loginPage.getTfMailTextFileld().getText());
		if(baza.getUserAccounts().contains(tempAcc)) {
			InboxPage.getInstance(baza.getUserAccounts().get(baza.getUserAccounts().indexOf(tempAcc)));
			loginPage.close();
		}else {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setContentText("Uneti email ne postoji!");
			alert.show();
		}
	}
	
	
	
}
