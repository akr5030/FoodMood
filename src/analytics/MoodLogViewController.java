package analytics;

import foodmood.MoodRecord;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TreeView;

/**
 * FXML Controller class for the mood log view.
 *
 * The mood log shows the moods the user has logged within the specified date
 * range. The moods are displayed as a line chart and as a list. Users can
 * delete mood records.
 *
 * On first launch it will display the records entered for the current day and
 * seven days previous. The user can change the date range.
 *
 * @author jsm158
 */
public class MoodLogViewController implements Initializable {

    // TODO replace Object with real classes
    /**
     * ObservableList for the mood records to display
     */
    

    /**
     * The line chart for displaying moods
     */
    @FXML
    private LineChart lineChart;

    /**
     * The tree view for displaying the list of moods
     */
    @FXML
    private TreeView treeView;

    /**
     * The date picker for the start date
     */
    @FXML
    private DatePicker startDatePicker;

    /**
     * The date picker for the end date
     */
    @FXML
    private DatePicker endDatePicker;

    @FXML
    private ComboBox moodComboBox;

    /**
     * Constructs a new MoodLogViewController
     */
    public MoodLogViewController() {
    }

    /**
     * Initializes the controller class.
     *
     * @param url the url (path) to the associated FXML document
     * @param rb the application's resource bundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
//        // functionality is tested in MoodController
//        TestHarness.getInstance().finishTestRun();
    }

    /**
     * Updates the view to show the selected date range
     *
     * @param e the action event associated with the button
     */
    @FXML
    private void handleUpdateViewButton(ActionEvent e) {

    }

    /**
     * Deletes the selected mood record
     *
     * @param e the associated event
     */
    @FXML
    private void handleDeleteRecordButton(ActionEvent e) {
        // TODO
    }

    /**
     * Updates the ObservableList for mood records for the selected mood and
     * date range.
     *
     * Throws an IllegalArgumentException if the startDate occurs after the end
     * date.
     *
     * @param startDate the start date
     * @param endDate the end date
     */
    private void getRecords(Date startDate, Date endDate) {

    }

}
