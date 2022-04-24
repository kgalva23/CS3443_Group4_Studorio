package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MenuController {
	
	@FXML
    private Button searchButton;

    @FXML
    private Button chatButton;
    
    @FXML
    private Button signupButton;
    
    @FXML
    private Button loginButton;
    
    @FXML
    private Button aboutButton;

    @FXML
    void chatHandle(ActionEvent event) throws IOException {
    	URL url = new File("src/application/view/ChatRoom.fxml").toURI().toURL(); 
		AnchorPane root = (AnchorPane)FXMLLoader.load(url);
    	Scene scene = new Scene(root,800,800);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);

    }

    @FXML
    void searchHandle(ActionEvent event) throws IOException {
    	URL url = new File("src/application/view/Search.fxml").toURI().toURL(); 
		AnchorPane root = (AnchorPane)FXMLLoader.load(url);
    	Scene scene = new Scene(root,410,410);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);

    }
    
    @FXML
    void loginHandle(ActionEvent event) throws IOException {
    	URL url = new File("src/application/view/Login.fxml").toURI().toURL(); 
		AnchorPane root = (AnchorPane)FXMLLoader.load(url);
    	Scene scene = new Scene(root,400,400);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);

    }

    @FXML
    void signupHandle(ActionEvent event) throws IOException {
    	URL url = new File("src/application/view/Signup.fxml").toURI().toURL(); 
		AnchorPane root = (AnchorPane)FXMLLoader.load(url);
    	Scene scene = new Scene(root,400,400);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);

    }

    @FXML
    void aboutHandle(ActionEvent event) throws IOException {
    	URL url = new File("src/application/view/about.fxml").toURI().toURL(); 
		AnchorPane root = (AnchorPane)FXMLLoader.load(url);
    	Scene scene = new Scene(root,550,500);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);

    }
   


}
