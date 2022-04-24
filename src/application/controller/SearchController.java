package application.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SearchController {
	
	private String[] interestOptions = {"Numbers", "Art", "Health", "Machines", "Athletics", "Business"};
	private ArrayList<String[]> rooms = new ArrayList<String[]>();
	private String[] shownRooms = new String[8];
	private int counter = 0;
	private int roomCounter = 0;

    @FXML
    private ChoiceBox<String> interestBox3;

    @FXML
    private ChoiceBox<String> interestBox2;

    @FXML
    private ChoiceBox<String> interestBox1;

    @FXML
    private Button suggestButton;

    @FXML
    private Button moveButton;

    @FXML
    private ListView<String> roomList;

    @FXML
    private Button homeButton;

    @FXML
    void suggest(ActionEvent event) {
    	for (int j=0; j < shownRooms.length; j++) {
    		shownRooms[j] = "";
    	}
    	roomList.getItems().clear();
    	for (int i=0; i < rooms.size(); i++) {
        	if (interestBox1.getSelectionModel().getSelectedItem().equals(rooms.get(i)[1]) || interestBox1.getSelectionModel().getSelectedItem().equals(rooms.get(i)[2]) || interestBox1.getSelectionModel().getSelectedItem().equals(rooms.get(i)[3])) {
        		counter++;
        	}
        	if (interestBox2.getSelectionModel().getSelectedItem().equals(rooms.get(i)[1]) || interestBox2.getSelectionModel().getSelectedItem().equals(rooms.get(i)[2]) || interestBox2.getSelectionModel().getSelectedItem().equals(rooms.get(i)[3])) {
        		counter++;
        	}
        	if (interestBox3.getSelectionModel().getSelectedItem().equals(rooms.get(i)[1]) || interestBox3.getSelectionModel().getSelectedItem().equals(rooms.get(i)[2]) || interestBox3.getSelectionModel().getSelectedItem().equals(rooms.get(i)[3])) {
        		counter++;
        	}
        	if (counter == 3) {
        		shownRooms[roomCounter] = rooms.get(i)[0];
        		roomCounter++;
        	}
        	counter = 0;
    	}
    	roomCounter = 0;
    	roomList.getItems().addAll(shownRooms);
    }

    @FXML
    void home(ActionEvent event) throws IOException {
    	URL url = new File("src/application/view/MainMenu.fxml").toURI().toURL(); 
		AnchorPane root = (AnchorPane)FXMLLoader.load(url);
    	Scene scene = new Scene(root,400,400);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    	window.show();
    }

    @FXML
    void move(ActionEvent event) throws IOException {
    	URL url = new File("src/application/view/ChatRoom.fxml").toURI().toURL(); 
		AnchorPane root = (AnchorPane)FXMLLoader.load(url);
    	Scene scene = new Scene(root,800,800);
    	Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
    	window.setScene(scene);
    }
    
    public void initialize() throws FileNotFoundException {
    	interestBox1.getItems().addAll(interestOptions);
    	interestBox2.getItems().addAll(interestOptions);
    	interestBox3.getItems().addAll(interestOptions);
    	
		File file = new File("Data", "Rooms");
		Scanner scan = new Scanner(file);
		while (scan.hasNext()) {
			String nextLine = scan.nextLine();
			String[] newRoom = new String[4];
			newRoom = nextLine.split(",");
			rooms.add(newRoom);
		}
		for (int i=0; i < rooms.size(); i++) {
			shownRooms[i] = rooms.get(i)[0];
		}
		scan.close();
		roomList.getItems().addAll(shownRooms);
    }
}