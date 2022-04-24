package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import application.model.DataModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class LoginController {

	 @FXML
	 private TextField usernameField;

	 @FXML
	 private Tooltip ttPassword;

	 @FXML
	 private CheckBox showPasswordCheck;

	 @FXML
	 private Button loginButton;

	 @FXML
	 private Button menuButton;

	 @FXML
	 private PasswordField passwordField;

    @FXML
    void passwordHandle(ActionEvent event) {

    }

    @FXML
    void userHandle(ActionEvent event) {

    }

    //Login Handle calls the login method from the DataModel class when the login button is clicked,
    //and if the username and password are valid the Chat Room scene is loaded
    @FXML
    void loginHandle(ActionEvent event) throws IOException {
    	String userInput = usernameField.getText().toString();
    	String passwdInput = passwordField.getText().toString();
    	DataModel.login(userInput, passwdInput);
    	if (DataModel.userPasswordIsValid() == true) {
			
    		URL url = new File("src/application/view/ChatRoom.fxml").toURI().toURL(); 
    		AnchorPane root = (AnchorPane)FXMLLoader.load(url);
        	Scene scene = new Scene(root,800,800);
        	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        	window.setScene(scene);
    	}
	
    	usernameField.clear();
    	passwordField.clear();

    }
    
    //This method shows the password if the "Show password" checkbox is marked
    @FXML
    void showPasswordHandle(ActionEvent event) {
    	if (showPasswordCheck.isSelected())
    		ttPassword.setText(passwordField.getText());
    	else
    		ttPassword.setText(null);
    }

    //This method returns the user to the menu when the Menu button is clicked
    @FXML
    void menuReturn(ActionEvent event) throws IOException {
    	URL url = new File("src/application/view/MainMenu.fxml").toURI().toURL(); 
		AnchorPane root = (AnchorPane)FXMLLoader.load(url);
    	Scene scene = new Scene(root,400,400);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

}

