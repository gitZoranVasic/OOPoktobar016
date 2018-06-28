package view;

import controller.BtnNewMessage;
import controller.BtnPrikaziController;
import controller.BtnPrikaziTekst;
import javaFixEs.Datum;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Baza;
import model.Email;
import model.UserAccount;

public class InboxPage extends Stage {
	private static InboxPage instance = null;
	
	UserAccount thisUsr;
	
	Label lblAmountOfMails;
	Button btnPrikazi, btnPrikaziTekst, btnNovaPoruka;
	TableView<Email> tvEmail;
	TextArea taEmailText;
	ComboBox<String> cmbInboxRoom;
	
	public InboxPage(UserAccount thisUsr) {
		
		setWidth(900);
		//setHeight(900);
		
		this.thisUsr = thisUsr;
		
			//Labels setup
		lblAmountOfMails = new Label();
			setLblAmountOfMails();
		
			//Buttons setup
		btnPrikazi = new Button("Prikazi");
			btnPrikazi.setOnAction(new BtnPrikaziController(Baza.getInstance(), this));
		btnPrikaziTekst = new Button("Prikazi tekst");
			btnPrikaziTekst.setOnAction(new BtnPrikaziTekst(Baza.getInstance(), this));
		btnNovaPoruka = new Button("Nova poruka");
			btnNovaPoruka.setOnAction(new BtnNewMessage(this));
		
			//Text Area setup
		taEmailText = new TextArea();
			taEmailText.setEditable(false);
			taEmailText.setMinHeight(400);
		
			//Combo box setup
		ObservableList<String> cmbNames = FXCollections.observableArrayList();
			cmbNames.addAll("Primljenje", "Poslate");
			cmbInboxRoom = new ComboBox<>();
				cmbInboxRoom.setItems(cmbNames);
				cmbInboxRoom.getSelectionModel().select(0);
			
			//TableView setup
		tvEmail = new TableView<>();
				//TableColumn setup
			TableColumn<Email, String> tcFrom = new TableColumn<>("Posljilac");
				tcFrom.setCellValueFactory(new PropertyValueFactory<>("email_sendFrom"));
			TableColumn<Email, String> tcTo = new TableColumn<>("Primalac");
				tcTo.setCellValueFactory(new PropertyValueFactory<>("email_sendTo"));
			TableColumn<Email, Datum> tcDate = new TableColumn<>("Datum");
				tcDate.setCellValueFactory(new PropertyValueFactory<>("email_date"));
			TableColumn<Email, String> tcTitle = new TableColumn<Email, String>("Naslov");
				tcTitle.setCellValueFactory(new PropertyValueFactory<>("email_header"));
				tvEmail.getColumns().addAll(tcFrom,tcTo,tcDate,tcTitle);
				tvEmail.setItems(thisUsr.getUserAccount_inboxMails());
				tvEmail.setMaxHeight(200);
		
		VBox mainLayout = new VBox(5);
			HBox chHbox = new HBox(5);
				chHbox.getChildren().addAll(cmbInboxRoom, btnPrikazi);
				chHbox.setAlignment(Pos.CENTER);
			mainLayout.getChildren().addAll(lblAmountOfMails,chHbox,tvEmail,btnPrikaziTekst,taEmailText,btnNovaPoruka);
			mainLayout.setAlignment(Pos.CENTER);
		
		
		Scene sc = new Scene(mainLayout);
		setScene(sc);
		
		setTitle("Ispit OOP - oktobar");
		setResizable(false);
		show();
		
		
		
	}
	
	
	public ComboBox<String> getCmbInboxRoom() {
		return cmbInboxRoom;
	}


	public void setCmbInboxRoom(ComboBox<String> cmbInboxRoom) {
		this.cmbInboxRoom = cmbInboxRoom;
	}


	public static InboxPage getInstance() {
		return instance;
	}


	public UserAccount getThisUsr() {
		return thisUsr;
	}


	public TableView<Email> getTvEmail() {
		return tvEmail;
	}


	public void setLblAmountOfMails() {
		lblAmountOfMails.setText("Ukupno poruka: " + this.thisUsr.getUserAccount_inboxMails().size() + " dolazne i " + thisUsr.getUserAccount_sendMails().size() + " odlazne");
	}
	
	public Label getLblAmountOfMails() {
		return lblAmountOfMails;
	}


	public Button getBtnPrikazi() {
		return btnPrikazi;
	}


	public Button getBtnPrikaziTekst() {
		return btnPrikaziTekst;
	}


	public Button getBtnNovaPoruka() {
		return btnNovaPoruka;
	}


	public TextArea getTaEmailText() {
		return taEmailText;
	}


	public static InboxPage getInstance(UserAccount thisUsr) {
		if(instance == null) instance = new InboxPage(thisUsr);
		return instance;
	}
	
	
	
	
	
	
	
	
	
}
