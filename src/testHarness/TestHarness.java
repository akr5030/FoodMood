package testHarness;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Test harness for M02-A03 System Component API Stubs and Automated System
 * Tests
 *
 * The test harness is responsible for launching the application and running
 * tests. It's designed somewhat like JUnit in that it has methods to set up the
 * test environment (create data,etc), run tests, log test results, and tear
 * down the test environment (delete data, etc).
 *
 * The test process requires a bit of coordination and agreement on the order in
 * which tests run since each controller is responsible for calling the next.
 * After all code is checked in we should review the order and update as needed
 * to make sure all tests are run.
 *
 *
 * <h2>Running tests</h2>
 *
 * This class has a main method and can be run in NetBeans. Make sure to "run
 * file" instead of using "run". The tests messages and results will be printed
 * to the console.
 *
 *
 * <h2>Creating tests and running them from method stubs</h2>
 *
 * The test design we decided on is to run the application logic, write out the
 * resulting data to a file as if we were using a database, then read the file
 * in the test method to make sure that it contains the expected data. The test
 * creation process is as follows:
 *
 * <ol>
 * <li>Add any logic needed to create test data (such as our list of moods or
 * other files that hold data) in the {@link #testSetUp() testSetup}
 * method.</li>
 *
 * <li>Create a new method name testControllernameTitleOfTest (in the same
 * section as the other test methods).</li>
 *
 * <li>Write your test code. Call logTestStart on the first line to print a
 * message that your test is starting. Call logTestResult in the last line to
 * print the test result. If no more tests should be run if this one passes
 * (which might be the case for method stubs that create data needed for later
 * tests), call {@link #finishTestRun() finishTestRun()} to quit the
 * application.</li>
 *
 * <li>Write the method stub in your controller class.</li>
 *
 * <li>Run the test from your method stub (after the code that does stuff) by
 * calling the appropriate test method as TestHarness.getInstance().testName().
 * You can run multiple tests.</li>
 *
 * <li>Once all tests in the class have finished, load the next view to run its
 * tests (at the end of your initialize method stub) with
 * {@link #changeScene(java.lang.String) TestHarness.getInstance().changeScene}
 * OR call {@link #finishTestRun() TestHarness.getInstance().finishTestRun()} if
 * there are no more tests to be run.</li>
 * </ol>
 *
 * <h2>How it works</h2>
 *
 * <p>
 * The first thing this class does is start the application using the
 * TestLauncher class, which is a simple "JavaFX main" class. It starts the
 * application, sets the primary stage (similar to a Swing frame) in the
 * TestHarness, then calls changeScene to load the first view (similar to
 * loading a JPanel in a frame in Swing).
 *
 * <p>
 * Changing the scene normally in JavaFX will change the displayed view. This
 * may not actually happen in the TestHarness, and that's OK. The assignment
 * specifies that the view needs to be instantiated, but not that it should be
 * shown. The important part, and what <i>does</i> happen, is the controller is
 * instantiated.</p>
 *
 * <p>
 * Each controller should contain method stubs that simulate what would occur if
 * the application were actually running and had user interaction. Instead of
 * getting data from the user, we just hard code what we need and pass it as
 * parameters as needed. This is just for testing. Unlike normal classes, this
 * code shouldn't go into the constructor. Instead, it goes into the initialize
 * method.</p>
 *
 * <p>
 * The controllers need to call the appropriate tests, defined in this class.
 * Once the tests complete then the controller needs to call the view for the
 * next set of tests that are need to be run. This is done by passing the path
 * and file name of the associate view (fxml file) as a parameter in
 * TestHarness.getInstance().changeScene. That controller is then loaded and
 * run. The finishTestRun method is called when the last test is completed to
 * print the pass/fail statistics and quit the application.</p>
 *
 * <p>
 * See {@link analytics.FoodLogViewController FoodLogViewController} for an
 * example of how this might work.</p>
 *
 * <p>
 * The tests are written as single methods in this class, similar to how you
 * would write tests in JUnit. Each test method contains the logic needed to
 * verify that the controller and associated models have done the right
 * thing.</p>
 *
 * @author jsm158
 * @see TestLauncher
 * @see
 * <a href="https://psu.instructure.com/courses/1867553/assignments/9418764#submit">assignment
 * page</a>
 * @since M02-A03
 */
public class TestHarness {

    // Reference to the application's stage, set by setStage 
    private Stage primaryStage;

    // counters for test passes and failures
    private int testsPassed;
    private int testsFailed;

    private final static Logger logger = Logger.getLogger("TestHarness");

    private TestHarness() {
        testsPassed = 0;
        testsFailed = 0;
    }

    public boolean testFoodLogViewControllerGetFoodRecords() {
        logTestStart("testFoodLogViewControllerGetFoodRecords");
        // TODO write test

        logTestResult("testFoodLogViewControllerGetFoodRecords", false);
        return false;
    }

    public boolean testFoodLogViewControllerDeleteFood() {
        logTestStart("testFoodLogViewControllerDeleteFood");
        // TODO write test

        logTestResult("testFoodLogViewControllerDeleteFood", false);
        return false;
    }

    public boolean testMoodLogViewControllerGetMoodRecords() {
        logTestStart("testMoodLogViewControllerGetMoodRecords");
        // TODO write test

        logTestResult("testMoodLogViewControllerGetMoodRecords", false);
        return false;
    }

    /**
     * Prints overall test statistics and exits the application
     *
     * Call this after the last test
     *
     */
    public void finishTestRun() {
        logger.log(Level.INFO, String.format("TESTS COMPLETE. Total tests: %d [%d passed, %d failed",
                testsPassed + testsFailed, testsPassed, testsFailed));
        primaryStage.close();
        Platform.exit();
    }

    /**
     * Performs tasks that need to be done before tests start, such as test data
     * creation
     */
    public static void testSetUp() {

    }

    /**
     * Performs tasks that need to be done after all tests have completed, such
     * as deleting test data
     */
    public void testTearDown() {

    }

    /**
     * Loads the specified view's controller (which runs the next set of tests)
     *
     * This method is for testing only. The view itself may actually not display
     * and that's OK. If the controller is running, the view has actually been
     * initialized per the assignment requirements. The controller logic is
     * running anyway and the test method stubs are running.
     *
     * The path to the view is relative to the src folder and should be in the
     * form of "/packagename/classname.fxml". If the path is incorrect or the
     * file does not exist then the test will fail.
     *
     * Errors in document loading might be tricky to spot. Usually, it's because
     * there's a variable reference to a form field defined in the controller
     * that does not actually exist in the view. Check the view IDs to fix it by
     * opening the fxml file in Scenebuilder, selecting the element, then
     * setting the ID in the Code panel on the right.
     *
     * @param document the path to the view as a string
     */
    public void changeScene(String document) {
        Pane root;
        Scene scene;

        if (primaryStage == null) {
            Logger.getLogger(TestHarness.class.getName()).log(Level.SEVERE,
                    "Cannot change scene because the stage has not been set.");
            Platform.exit();
        }

        try {
            Logger.getLogger(TestHarness.class.getName()).log(Level.INFO, document);

            root = FXMLLoader.load(getClass().getResource(document));
            scene = new Scene(root, 800, 600);
            primaryStage.setTitle(document);
            primaryStage.setScene(scene);
        } catch (IOException ex) {
            logger.log(Level.SEVERE,
                    "Error changing scene to " + document, ex);
            Platform.exit();
        }
    }

    /**
     * Sets the application's stage
     *
     * This must be set by TestLauncher so that tests can run
     *
     * @see TestLauncher
     *
     * @param primaryStage the primary stage
     */
    public void setStage(Stage primaryStage) {
        this.primaryStage = primaryStage;
    }

    /**
     * Gets an instance of this class
     *
     * @return the instance
     */
    public static TestHarness getInstance() {
        return TestHarnessHolder.INSTANCE;
    }

    /**
     * Runs the application and tests
     *
     * @param args
     */
    public static void main(String[] args) {
        logger.log(Level.INFO,
                "Starting application and tests.");
        testSetUp();
        Application.launch(TestLauncher.class, args);
    }

    /**
     * Helper method to print a message that a test is starting
     *
     * @param testName the name of the test
     */
    private void logTestStart(String testName) {
        logger.log(Level.INFO, String.format("%nStarting %s test", testName));
    }

    /**
     * Helper method to print the result of a test using a pre-defined string
     *
     * If the test passes the message will be logged at the info level. If it
     * failed, the level will be severe.
     *
     * @param testName the name of test
     * @param passed true if the test passed, otherwise false
     */
    private void logTestResult(String testName, boolean passed) {
        String messageFormat = "Result for %s: %b";

        if (passed) {
            testsPassed++;
            logger.log(Level.INFO, String.format(messageFormat, testName, passed));
        } else {
            testsFailed++;
            logger.log(Level.SEVERE, String.format(messageFormat, testName, passed));
        }
    }

    private static class TestHarnessHolder {

        private static final TestHarness INSTANCE = new TestHarness();
    }
}
