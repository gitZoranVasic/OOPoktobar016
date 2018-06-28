package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import javaFixEs.Datum;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Baza {

	private static Baza instance = null;
	

	private ObservableList<UserAccount> userAccounts;

	public Baza() {
		userAccounts = FXCollections.observableArrayList();
		loadData();
	}
	
	
	private void loadData() {
		
		try {
			FileReader load = new FileReader("email.txt");
			BufferedReader buffer = new BufferedReader(load);
			String line;
			while((line = buffer.readLine()) != null) {
				String parseMain[] = line.split(";");
				
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
				Datum datum = new Datum(sdf.parse(parseMain[4]));
				
				//make a mail
				Email email = new Email(parseMain[0], parseMain[1], parseMain[2], parseMain[3], datum);
				
				//provera korisnickih naloga!
				UserAccount tempUserFrom = new UserAccount(parseMain[0]);
				UserAccount tempUserTo   = new UserAccount(parseMain[1]);
				if(!userAccounts.contains(tempUserFrom)) 
					userAccounts.add(tempUserFrom);
				if(!userAccounts.contains(tempUserTo)) 
					userAccounts.add(tempUserTo);
				
				//put the mails where they belong
				userAccounts.get(userAccounts.indexOf(tempUserFrom)).getUserAccount_sendMails().add(email);
				userAccounts.get(userAccounts.indexOf(tempUserTo)).getUserAccount_sendMails().add(email);
				
				
			}//while
			
			
			
			buffer.close();
			load.close();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Baza getInstance() {
		if(instance == null) instance = new Baza();
		return instance;
	}
	
	public ObservableList<UserAccount> getUserAccounts() {
		return userAccounts;
	}
	
	
	
}
