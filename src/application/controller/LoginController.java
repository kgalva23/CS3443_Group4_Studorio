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
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
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

    @FXML
    void loginHandle(ActionEvent event) throws IOException {
    	String userInput = usernameField.getText().toString();
    	String passwdInput = passwordField.getText().toString();
    	DataModel.login(userInput, passwdInput);
    	if (DataModel.userPasswordIsValid() == true) {
    		Alert error = new Alert(AlertType.CONFIRMATION);
			error.setTitle("Confirmation Message");
			error.setHeaderText("Login Successful!");
			error.setContentText("You will now be taken to the Chat Room");
			error.showAndWait();
			
    		URL url = new File("src/application/view/ChatRoom.fxml").toURI().toURL(); 
    		AnchorPane root = (AnchorPane)FXMLLoader.load(url);
        	Scene scene = new Scene(root,400,400);
        	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        	window.setScene(scene);
    	}
    	else {
    		Alert error= new Alert(AlertType.ERROR);
    		error.setTitle("Error Message");
    		error.setHeaderText("Password is Invalid!");
    		error.setContentText("Please try again.");
    		error.showAndWait();
    	}
    		
    	usernameField.clear();
    	passwordField.clear();

    	

    }
    
    @FXML
    void showPasswordHandle(ActionEvent event) {
    	ttPassword.setText(passwordField.getText());

    }

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

