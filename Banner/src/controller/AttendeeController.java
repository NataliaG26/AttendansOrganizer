package controller;

import java.io.File;
import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import model.DataBase;

public class AttendeeController {
	
    @FXML
    private ImageView image;

    @FXML
    private TextField countryText;

    @FXML
    private TextField bdText;

    @FXML
    private TextField emailText;

    @FXML
    private TextField lastNameText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField loadTextField;

    @FXML
    private TextField pTextField;

    @FXML
    private TextField sTextField;

    @FXML
    private AnchorPane paintPane;
    
    @FXML
    private Label sta1;

    @FXML
    private Label stp1;
    
    private DataBase organizer;

    @FXML
    void attendeePaint(ActionEvent event) {

    }
    
    /* This method connect uses a FileChoser to load the list of attendants to the event 
     */
    @FXML
    void fileLoaderOption(ActionEvent event) {
    	Window w = null;
    	FileChooser fileChooser = new FileChooser();
    	fileChooser.setTitle("Open Resource File");
    	fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
    	 fileChooser.getExtensionFilters().addAll(
    	         new ExtensionFilter("Text Files", "*.txt"));
    	 File selectedFile = fileChooser.showOpenDialog(w );
    	 if (selectedFile != null && selectedFile.canRead()) {
    			loadTextField.setText(selectedFile.getAbsolutePath());
    	 } else
    		 JOptionPane.showMessageDialog(null,"Wrong option, this can't be loaded");
    }

    @FXML
    void loadList(ActionEvent event) {
    	try {
			organizer.loadFile(loadTextField.getText());
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Wrong file, this can't be loaded");
		}
    }

    @FXML
    void paintParticipants(ActionEvent event) {

    }

    @FXML
    void searchAttendee(ActionEvent event) {

    }

    @FXML
    void searchParticipant(ActionEvent event) {

    }

	public void initialize() {
		organizer = new DataBase();
		image.setImage(new Image("File:picturesData/avatarBydefault.png"));
	}
	
}
