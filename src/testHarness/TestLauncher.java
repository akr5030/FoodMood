package testHarness;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author redjen
 */
public class TestLauncher extends Application {
    
    @Override
    public void start(Stage primaryStage) {

        Parent root;
        
        try {
            root = FXMLLoader.load(getClass().getResource("/analytics/FoodLogView.fxml"));
            Scene scene = new Scene(root, 300, 250);
            
            primaryStage.setTitle("FoodMood");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException ex) {
            Logger.getLogger(TestLauncher.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    private static void setUp() {
        
    }
    
    private static void tearDown() {
        
    }
    
}
