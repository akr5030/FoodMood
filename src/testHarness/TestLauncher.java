package testHarness;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Simple launcher class used to start the application for testing
 * 
 * This class does three things:
 * 
 * 1. Launch the application.
 * 2. Pass the stage to TestHarness, which handles changing views.
 * 3. Pass the view associated with the first test to TestHarness, which then
 *    loads the view and its controller.
 * 
 * @author jsm158
 */
public class TestLauncher extends Application {

    @Override
    public void start(Stage primaryStage) {

        TestHarness.getInstance().setStage(primaryStage);
        TestHarness.getInstance().changeScene("/analytics/FoodLogView.fxml");
    }
    
    @Override
    public void stop() {
        try {
            TestHarness.getInstance().testTearDown();
            super.stop();
        } catch (Exception ex) {
            Logger.getLogger(TestLauncher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
