package testHarness;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

/**
 * Simple launcher class used to start the application for testing
 *
 * This class does three things:
 *
 * <ol>
 * <li> Launch the application. </li>
 * <li> Pass the stage to TestHarness, which handles changing views.</li>
 * <li>3. Pass the view associated with the first test to TestHarness, which
 * then loads the view and its controller.</li>
 * </ol>
 *
 * @author jsm158
 * @since M02-A03
 */
public class TestLauncher extends Application {

    @Override
    public void start(Stage primaryStage) {

        Platform.setImplicitExit(true);
        TestHarness.getInstance().setStage(primaryStage);
        TestHarness.getInstance().changeScene("/foodmood/FoodView.fxml");
    }

    /**
     * Stop the application
     *
     * The application doesn't shut down normally since it's started from an
     * external class. System.exit has to be called here to shut down all
     * threads.
     */
    @Override
    public void stop() {
        try {
            System.exit(0);

        } catch (Exception ex) {
            Logger.getLogger(TestLauncher.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
