package application;

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

public class AboutController {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private Button homeButton;

    @FXML
    void handleHome(ActionEvent event) throws IOException {
    	
    	URL url = new File("src/application/view/MainMenu.fxml").toURI().toURL(); 
	AnchorPane root = (AnchorPane)FXMLLoader.load(url);
    	Scene scene = new Scene(root,400,400);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    
    }

}
