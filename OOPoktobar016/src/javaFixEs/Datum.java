package javaFixEs;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Datum extends Date{
	
	public Date date;
	
	public Datum(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString() {
		return new SimpleDateFormat("dd-MM-yyyy").format(date);
	}
	
}
