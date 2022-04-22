package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ChatRoomController {
	
	    //local variables
		@FXML
		private AnchorPane display_ChatRoom;
		
		@FXML
		private TextArea display_chatText;

	    @FXML
	    private TextArea send_chat; 


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
	    	
	    }
}
