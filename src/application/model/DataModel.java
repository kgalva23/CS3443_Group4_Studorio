package application.model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class DataModel {
	
	private static HashMap<String,String> account = new HashMap<String,String>();		//Create a HashMap to store string objects with username being the key and password being the value
	private static LinkedList<String> userList = new LinkedList<String>();		//create a LinkedList to store user IDs in
	private static LinkedList<String> majorList = new LinkedList<String>();		//create a LinkedList to store majors in
	private static LinkedList<String> emailList= new LinkedList<String>();		//create a LinkedList to store emails in
	
	public static LinkedList<String> activeUsers= new LinkedList<String>();		//create a LinkedList to store active users in

	
	private static String userFilePath = "data/users.txt";		//create a txt file for users
	private static String majorFilePath = "data/majors.txt";			//create a txt file for majors
	private static String emailFilePath = "data/emails.txt";		//create a txt file for emails
	
	private static boolean passwordIsValid;		//boolean variable for whether password is valid or not
	
	//Method that runs when the user clicks on the button to sign up for an account
	public static void createAccount(String username, String password) throws IOException {
			
		//if the account HashMap contains the username as a key already, then display an error that the username already exists
		if (account.containsKey(username)) {
			Alert error= new Alert(AlertType.ERROR);
			error.setTitle("Error Message");
			error.setHeaderText("Username already exists!");
			error.setContentText("Please create an account with a different username.");
			error.showAndWait();
			
		}
		//else, add the username to the account HashMap along with the password written by the user
		//confirmation message is also displayed
		else {
			account.put(username, password);
			System.out.println("Password valid");
			Alert error = new Alert(AlertType.CONFIRMATION);
			error.setTitle("Confirmation Message");
			error.setHeaderText("Account successfully created!");
			error.setContentText("You now have an account available with Studorio.");
			error.showAndWait();
		}
			
	}
		
	//Method that runs whenever a user clicks on the login button
	public static void login(String testUsername, String testPassword) {
		//initialize passwordIsValid to be true
		passwordIsValid = true;
		
		//if account HashMap contains username
		if (account.containsKey(testUsername)) {
			String userValue = account.get(testUsername);
			
			// if password entered is equal to the username value, then print password is valid and display confirmation message
			if(testPassword.equals(userValue)) {
				System.out.println("Password valid");
				
				//if user is not active, add them to LinkedList of active users
				if (!activeUsers.contains(testUsername))
					activeUsers.add(testUsername);
				
				Alert error = new Alert(AlertType.CONFIRMATION);
				error.setTitle("Confirmation Message");
				error.setHeaderText("Login Successful!");
				error.setContentText("You will now be taken to the Chat Room");
				error.showAndWait();
			}
			//set password to be invalid and display error message
			else {
				
				passwordIsValid = false;
				System.out.println("Password invalid");
				Alert error= new Alert(AlertType.ERROR);
	    		error.setTitle("Error Message");
	    		error.setHeaderText("Password is Invalid!");
	    		error.setContentText("Please try again.");
	    		error.showAndWait();
			}			
			
		}
		//if account does not contain username entered, set passwordIsValid to false and display username does not exist!
		else {
			passwordIsValid = false;
			System.out.println("Username invalid!");
			Alert error= new Alert(AlertType.ERROR);
    		error.setTitle("Error Message");
    		error.setHeaderText("Username entered does not exist!");
    		error.setContentText("Please enter a valid username.");
    		error.showAndWait();
		}
			
		
	}
	
	//Method to write data entered by users into txt files
	public static void writeToFile(String userFile, String majorFile, String emailFile) {
		
		//add the Strings entered by the users to the appropriate files
		userList.add(userFile);
		majorList.add(majorFile);
		emailList.add(emailFile);
		
		
		//create a file which writes to the users txt file
		File userF = new File(userFilePath);
				
		BufferedWriter addBf = null;
		
		try {
			// create new BufferedWriter for the users txt file
        	addBf = new BufferedWriter(new FileWriter(userF));
        	
        	// iterate entries to store in the txt file
        	 for (String userElement : userList) {
            	// write key and value in the txt file
            	addBf.write(userElement);
  
                // create new line
            	addBf.newLine();
            }
            
            addBf.flush();
            
		}
        catch (IOException e) {
        		e.printStackTrace();
        }
        finally {
  
            try {
  
                // ensures the writer is closed at the end
            	addBf.close();
            }
            catch (Exception e) {
            }
        }
		
		
		//create a file which writes to the majors txt file
		File majorF = new File(majorFilePath);
				
		BufferedWriter Bf = null;
		
		try {
			// create new BufferedWriter for the majors txt file
        	Bf = new BufferedWriter(new FileWriter(majorF));
        	
        	// iterate entries to store in the txt file
        	 for (String majorElement : majorList) {
            	// write key and value in the txt file
        		 Bf.write(majorElement);
  
                // create new line
        		 Bf.newLine();
            }
            
        	 Bf.flush();
            
		}
        catch (IOException e) {
        		e.printStackTrace();
        }
        finally {
  
            try {
  
                // ensures the writer is closed at the end
            	Bf.close();
            }
            catch (Exception e) {
            }
        }
			
		
		//create a file which writes to the email txt file
				File emailF = new File(emailFilePath);
						
				BufferedWriter emailBf = null;
				
				try {
					// create new BufferedWriter for the email txt file
					emailBf = new BufferedWriter(new FileWriter(emailF));
		        	
		        	// iterate entries to store in the txt file
		        	 for (String emailElement : emailList) {
		            	// write key and value in the txt file
		        		 emailBf.write(emailElement);
		  
		                // create new line
		        		 emailBf.newLine();
		            }
		            
		        	 emailBf.flush();
		            
				}
		        catch (IOException e) {
		        		e.printStackTrace();
		        }
		        finally {
		  
		            try {
		  
		                // ensures the writer is closed at the end
		            	emailBf.close();
		            }
		            catch (Exception e) {
		            }
		        }
		
	}
	
	
	//Method that returns a boolean value to determine if the user ID is valid or not
	public static boolean userPasswordIsValid() {
		return passwordIsValid;
	}
			

}
