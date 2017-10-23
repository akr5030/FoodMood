package app;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author walte
 */
public class LoginController implements Initializable {

    //username textfield for username
    @FXML
    private TextField username;

    //textfield for user password
    @FXML
    private PasswordField password;

    //validator for false login
    @FXML
    private Label errorLabel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    public void loginButtonHandler(ActionEvent event) {

        Node node;
        Stage stage;
        Scene scene;
        Parent root;
        
        try {
            // TODO implement this for real once the account changes are in
            // for now, just redirect to the app without authentication

            node = (Node) event.getSource();
            stage = (Stage) node.getScene().getWindow();
            /* Exception */
            root = FXMLLoader.load(getClass().getResource("FoodMood.fxml"));
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            errorLabel.setText("Login failed due to exception.");
        }
    }
}
