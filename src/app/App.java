package app;

import dao.ConnectionManager;
import dao.DaoException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * Default JavaFX main class to run the application (but not the tests!)
 *
 * Use the TestHarness to run the tests for M02-A03
 *
 * @author jsm158
 * @see testHarness.TestHarness
 * @since M02-A03
 */
public class App extends Application {

    @Override
    public void start(Stage primaryStage) {
        Parent root;
        Scene scene;

        try {
            root = FXMLLoader.load(getClass().getResource("Login.fxml"));
            scene = new Scene(root, 1280, 800);
            primaryStage.setTitle("FoodMood");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            ConnectionManager.createDatabaseIfNotExists();
        } catch (DaoException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, "Could not create data directory", ex);
        }
        launch(args);
        
    }

}
