package application;
	
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javaFixEs.Datum;
import javafx.application.Application;
import javafx.stage.Stage;
import model.Baza;
import model.Email;
import view.LoginPage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
			Baza.getInstance();
			LoginPage.getInstance();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
