package application.model;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DataModel {
	
	private static HashMap<String,String> account = new HashMap<String,String>();		//Create a HashMap to store string objects with username being the key and password being the value
	static LinkedList<String> userlist = new LinkedList<String>();		//create a LinkedList to store user IDs in
	
	//private static boolean userIDValid = true;		//boolean variable for whether userID is valid or not
	private static boolean passwordIsValid = true;		//boolean variable for whether userID is valid or not
	
	//when the user clicks on the button to sign up an account
	public static void createAccount(String username, String password) throws IOException {
			
		//if the inventory HashMap contains the item as a key already, then update it's value by adding the quantity chosen by the user
		if (account.containsKey(username)) {
			//print error message -> username already exists
			//userIDValid = false;
			
			Alert error= new Alert(AlertType.ERROR);
			error.setTitle("Error Message");
			error.setHeaderText("Username already exists!");
			error.setContentText("Please create an account with a different username.");
			error.showAndWait();
			
		}
		//else, add the username to the account HashMap along with the password written by the user
		else {
			account.put(username, password);
		}
			
		System.out.println(account);
	}
		
		
	//create a list with major mapped to user
	//create a list with email mapped to user
		
	public static void login(String testUsername, String testPassword) {
		passwordIsValid = true;
		
		
		
		if (account.containsKey(testUsername)) {
			String userValue = account.get(testUsername);
			System.out.println(userValue);
			
			// code messes up right here
			if(testPassword.equals(userValue)) {
				//passwordIsValid = true;
				System.out.println("Password valid");
			}
			else {
				passwordIsValid = false;
				System.out.println("Password invalid");
			}			
			
		}
		else
			passwordIsValid = false;
		
		
		
		
		
			
		
	}
	
	//Method that returns a boolean value to determine if the user ID is valid or not
	public static boolean userPasswordIsValid() {
		return passwordIsValid;
	}
			

}
