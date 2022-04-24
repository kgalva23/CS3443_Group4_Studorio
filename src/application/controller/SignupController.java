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
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SignupController {

    @FXML
    private TextField usernameField;

    @FXML
    private ProgressIndicator progressIndicator;

    @FXML
    private TextField majorField;

    @FXML
    private Button menuButton;

    @FXML
    private Button createButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    private TextField emailField;
    
    @FXML
    private CheckBox showPasswordCheck;
    
    @FXML
    private Tooltip ttPassword;
    

    @FXML
    void passwordHandle(ActionEvent event) {

    }

    @FXML
    void userHandle(ActionEvent event) {

    }

    @FXML
    void majorHandle(ActionEvent event) {

    }

    @FXML
    void emailHandle(ActionEvent event) {

    }

    //createHandle calls the createAccount and writeToFile methods from the DataModel class
    //if all the required fields are filled out. If these fields are not filled out, the 
    //unfilled fields will turn red and an error will be displayed.
    @FXML
    void createHandle(ActionEvent event) throws IOException {
    	String usernameInput = usernameField.getText().toString();
    	String passwordInput = passwordField.getText().toString();
    	String majorInput = majorField.getText().toString();
    	String emailInput = emailField.getText().toString();
    	
    	if (usernameInput.isEmpty()) {
    		usernameField.setStyle("-fx-border-color: red ; -fx-border-width: 1.5px ;");
    	}
    	else
    		usernameField.setStyle("-fx-border-color: black ; -fx-border-width: 0px ;");
    		
    	if (passwordInput.isEmpty()) {
    		passwordField.setStyle("-fx-border-color: red ; -fx-border-width: 1.5px ;");
    	}
    	else
    		passwordField.setStyle("-fx-border-color: black ; -fx-border-width: 0px ;");
    	
    	if (emailInput.isEmpty()) {
    		emailField.setStyle("-fx-border-color: red ; -fx-border-width: 1.5px ;");
    	}
    	else 
    		emailField.setStyle("-fx-border-color: black ; -fx-border-width: 0px ;");
    		
    	if (!usernameInput.isEmpty() && !passwordInput.isEmpty() && !emailInput.isEmpty()) {
    		DataModel.createAccount(usernameInput, passwordInput);
    		DataModel.writeToFile(usernameInput, majorInput, emailInput);
    	}
    	else {
    		Alert error= new Alert(AlertType.ERROR);
    		error.setTitle("Error Message");
    		error.setHeaderText("Not all required fields are filled!");
    		error.setContentText("Please fill out all required fields.");
    		error.showAndWait();
    	}
		

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
