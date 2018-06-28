package view;


import controller.BtnPosaljiController;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Baza;
import model.UserAccount;

public class NewMessagePage extends Stage {
	
	Baza baza;
	UserAccount fromUser;
	
	TextField tfPrimalac, tfNaslov;
	TextArea taMessageBody;
	Button btnPosalji;
	
	public NewMessagePage(UserAccount fromUser) {
		baza = Baza.getInstance();
		this.fromUser = fromUser;
		tfPrimalac = new TextField();
		tfNaslov = new TextField();
		taMessageBody = new TextArea();
			taMessageBody.setMinHeight(50);
			taMessageBody.setMaxWidth(200);
		btnPosalji = new Button("Posalji");
			btnPosalji.setOnAction(new BtnPosaljiController(this));
		
		GridPane gpLayout = new GridPane();
			//column 0;
			gpLayout.add(new Label("Primalac: "),	    0, 0);
			gpLayout.add(new Label("Naslov: "),   		0, 1);
			gpLayout.add(new Label("Tekst poruke: "),   0, 2);
			gpLayout.add(btnPosalji, 					0, 3);
			
			//column 1;
			gpLayout.add(tfPrimalac, 					1, 0);
			gpLayout.add(tfNaslov, 						1, 1);
			gpLayout.add(taMessageBody,					1, 2);
			//GFridPane property
			gpLayout.setAlignment(Pos.CENTER);
			gpLayout.setVgap(7);
			gpLayout.setHgap(10);
			gpLayout.setPadding(new Insets(30));
			
			
			Scene sc = new Scene(gpLayout);
			setMaxWidth(500);
			setScene(sc);
			setTitle("OOP Ispit - Oktobar");
			show();
			
		
		
		
	}

	public UserAccount getFromUser() {
		return fromUser;
	}

	public TextField getTfPrimalac() {
		return tfPrimalac;
	}

	public TextField getTfNaslov() {
		return tfNaslov;
	}

	public TextArea getTaMessageBody() {
		return taMessageBody;
	}

	public Button getBtnPosalji() {
		return btnPosalji;
	}
	
	
}
