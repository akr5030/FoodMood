package testHarness;

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
 *
 * @author jsm158
 * @since M02-A03
 */
public class TestLauncher extends Application {

    @Override
    public void start(Stage primaryStage) {

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent t) {
                Platform.exit();
                System.exit(0);
            }
        });
        Platform.setImplicitExit(true);
        TestHarness.getInstance().setStage(primaryStage);
        TestHarness.getInstance().changeScene("/analytics/FoodLogView.fxml");
    }

}
