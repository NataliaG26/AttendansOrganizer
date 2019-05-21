package controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import exception.IdNotFoundException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.stage.FileChooser.ExtensionFilter;
import model.Attendee;
import model.DataBase;

public class AttendeeController implements Initializable {	
	
    public AttendeeController() {
    	organizer = new DataBase();
	}

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
    private TextField genderTextF;

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
    	File defaultDirectory = new File("File:data/AttendeesList.txt"); 
    	 fileChooser.getExtensionFilters().addAll(
    	         new ExtensionFilter("Text Files", "*.txt"));
    	 //fileChooser.setInitialDirectory(defaultDirectory);
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
    	try {
		Attendee r = organizer.searchAssitant(Integer.parseInt(pTextField.getText()), organizer.getRoot());
		makeItPaint(r);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IdNotFoundException e) {
			e.printStackTrace();
		}	
    }
 
	
	public void makeItPaint(Attendee b) {
		nameText.setText(b.getFirst_name());
		lastNameText.setText(b.getLast_name());
		emailText.setText(b.getEmail());
		genderTextF.setText(b.getGender());
		countryText.setText(b.getCountry());
		image.setImage(new Image(b.getPhoto()));
		bdText.setText(b.getBirthday());
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		AttendeeController attendeeController = new AttendeeController();
		image.setImage(new Image("File:picturesData/avatarBydefault.png"));
	}
	
}
