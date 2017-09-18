package analytics;

import foodmood.FoodRecord;
import foodmood.Mood;
import foodmood.MoodRecord;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.ScatterChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;

/**
 * The FoodMoodScatterplotViewController is the FXML controller for the
 * scatterplot analytics view of food vs mood.
 *
 * The user can select the mood and date range to be displayed. If the start
 * date occurs after the end date the plot will not be updated.
 *
 * @author jsm158
 */
public class FoodMoodScatterplotViewController implements Initializable {

    // TODO replace Object with the actual classes before submitting
    /**
     * The list of food records to include in the report
     */
    private ObservableList<FoodRecord> foods;

    /**
     * The list of mood records to include in the report
     */
    private ObservableList<MoodRecord> moods;

    /**
     * The scatter chart view
     */
    @FXML
    private ScatterChart<Integer, Integer> scatterChart;

    /**
     * The combo box for selecting the mood to display
     */
    @FXML
    private ComboBox<Object> moodSelectorComboBox;

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

    /**
     * Updates the view to show the selected date range and mood
     *
     * @param e the action event associated with the button
     */
    @FXML
    private void handleUpdateViewButton(ActionEvent e) {

    }

    /**
     * Updates the ObservableLists for food and mood records for the selected
     * mood and date range.
     *
     * Throws an IllegalArgumentException if the startDate occurs after the end
     * date.
     *
     * @param mood the mood to display
     * @param startDate the start date
     * @param endDate the end date
     */
    private void getRecords(Mood mood, Date startDate, Date endDate) {

    }
}
