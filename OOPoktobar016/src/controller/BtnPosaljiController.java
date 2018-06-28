package controller;

import java.util.Calendar;

import javaFixEs.Datum;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import model.Email;
import view.NewMessagePage;

public class BtnPosaljiController implements EventHandler<ActionEvent> {

		Datum todayDate;
		NewMessagePage page;
		
	public BtnPosaljiController(NewMessagePage page) {
		this.page = page;
		todayDate = new Datum(Calendar.getInstance().getTime());
		
		
	}

	@Override
	public void handle(ActionEvent event) {
		
	}
	
}
