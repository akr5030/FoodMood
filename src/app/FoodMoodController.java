package app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * Main controller for the application
 * @author jsm158
 */
public class FoodMoodController implements Initializable {

    @FXML
    private Label label;

    /**
     * Auto-generated
     * @param event 
     */
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }

    /**
     * Initializes the controller class.
     *
     * @param url the url (path) to the associated FXML document
     * @param rb the application's resource bundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
