package view;

import controller.BtnLoginController;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Baza;

public class LoginPage extends Stage {
	private static LoginPage instance = null;
	
	Baza baza;
	
	Label lblMailInput;
	TextField tfMailTextFileld;
	Button btnLogin;
	
	public LoginPage() {
		baza = baza.getInstance();
		
		lblMailInput = new Label("Unesite svoj email: ");
		tfMailTextFileld = new TextField();
		btnLogin = new Button("Pregled Poruka");
			btnLogin.setOnAction(new BtnLoginController(baza, this));
		
		HBox layout = new HBox(5);
			layout.getChildren().addAll(lblMailInput,
										tfMailTextFileld,
										btnLogin);
			
		layout.setAlignment(Pos.CENTER);
		Scene sc = new Scene(layout);
		setScene(sc);
		setWidth(600);
		setHeight(200);
		setResizable(false);
		setTitle("Ispit OOP - oktobar");
		show();

	}

	public static LoginPage getInstance() {
		if(instance == null) instance = new LoginPage();
		return instance;
	}
	
	public TextField getTfMailTextFileld() {
		return tfMailTextFileld;
	}
	

}
