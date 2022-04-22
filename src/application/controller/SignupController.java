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
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
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

    @FXML
    void createHandle(ActionEvent event) throws IOException {
    	String usernameInput = usernameField.getText().toString();
    	String passwordInput = passwordField.getText().toString();
    	DataModel.createAccount(usernameInput, passwordInput);

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
