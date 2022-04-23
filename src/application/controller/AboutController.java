package application;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AboutController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button homeButton;

    @FXML
    void handleHome(ActionEvent event) throws IOException {
    	anchorPane = FXMLLoader.load(getClass().getResource("Main.fxml"));
    	Scene scene = new Scene(anchorPane);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    	
    	/*		fixme comment above
    	
    		URL url = new File("src/application/view/MainMenu.fxml").toURI().toURL(); 
		AnchorPane root = (AnchorPane)FXMLLoader.load(url);
    	Scene scene = new Scene(root,400,400);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	
    	
    	*/
    
    }

}

//import java.net.URL;		fixme
/*add something similar to this in main

@FXML
private Button aboutButton;

void handleAbout(ActionEvent event) throws IOException {
URL url = new File("src/application/view/About.fxml").toURI().toURL(); 
AnchorPane root = (AnchorPane)FXMLLoader.load(url);
Scene scene = new Scene(root,400,400);
Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
window.setScene(scene);

}


*/
