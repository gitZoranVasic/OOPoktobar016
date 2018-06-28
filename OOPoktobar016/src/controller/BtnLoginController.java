package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Baza;
import model.UserAccount;
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
		if(baza.getUserAccounts().contains(new UserAccount(loginPage.getTfMailTextFileld().getText()))) {
			System.out.println("Ovde!!!");
		}
	}
	
	
	
}
