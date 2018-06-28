package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import model.Baza;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		
		Baza.getInstance();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
