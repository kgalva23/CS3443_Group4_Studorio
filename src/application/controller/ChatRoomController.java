package application.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.model.DataModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ChatRoomController implements Initializable {

	    //local variables
		@FXML
		private AnchorPane display_ChatRoom;
		
	    @FXML
	    private Button MenuButton;

		@FXML
		private TextArea display_chatText;

	    @FXML
	    private TextArea send_chat; 
	    
	    @FXML
	    private ListView<String> activeUserList;


	    @FXML
	    void button_home(ActionEvent event) throws IOException {
	    	  display_ChatRoom = FXMLLoader.load(getClass().getResource("Main.fxml"));

	          Scene scene = new Scene(display_ChatRoom);
	          Stage need_scene = (Stage) ((Node)event.getSource()).getScene().getWindow();
	          need_scene.setScene(scene);
	          need_scene.show();
	    }


	    @FXML
	    void button_send(ActionEvent event) {
	    	String text1 = send_chat.getText();
	    
	    	display_chatText.setText(text1);
	    	
	    	System.out.println("Message Submitted");
	    	
	    	send_chat.clear();


	    }
	    
	    @FXML
	    void MenuReturn(ActionEvent event) throws IOException {
	    	URL url = new File("src/application/view/MainMenu.fxml").toURI().toURL(); 
			AnchorPane root = (AnchorPane)FXMLLoader.load(url);
	    	Scene scene = new Scene(root,400,400);
	    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
	    	window.setScene(scene);
	    	window.show();
	    }


		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			activeUserList.getItems().clear();

			
			for (String activeUser : DataModel.activeUsers) {
				//System.out.println(activeUser);

				if (!activeUserList.getItems().contains(activeUser))
					activeUserList.getItems().addAll(DataModel.activeUsers);
		
			}
			
			
			
		}
}
