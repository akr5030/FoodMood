package analytics;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TreeView;

/**
 * The controller for the FXML food log viewer.
 *
 * The user can select the date range to be displayed. If the start date occurs
 * after the end date the plot will not be updated. On first launch it will
 * display the records entered for the current day and seven days previous. The
 * user can change the date range.
 *
 * @author jsm158
 */
public class FoodLogViewController implements Initializable {

    /**
     * The list of food records to display
     */
    @FXML
    private ObservableList<Object> foods;

    /**
     * The tree list displaying the food records
     */
    @FXML
    private TreeView<Object> treeView;

    /**
     * The start date selector
     */
    @FXML
    private DatePicker startDatePicker;

    /**
     * The end date selector
     */
    @FXML
    private DatePicker endDatePicker;

    /**
     * Constructs a new FoodLogViewController
     */
    public FoodLogViewController() {
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

    /**
     * Handles the date change button by updating log view to show entries
     * between the selected dates.
     *
     * If the selected start date is later than the selected end date the view
     * will not be updated and an error message will be thrown.
     *
     * @param e
     */
    @FXML
    private void handleChangeDatesButton(ActionEvent e) {
        // TODO
    }

    /**
     * Deletes the selected food record
     *
     * @param e the associated event
     */
    @FXML
    private void handleDeleteRecordButton(ActionEvent e) {
        // TODO
    }

    /**
     * Updates the ObservableList
     *
     * Throws an IllegalArgumentException if the startDate occurs after the end
     * date.
     *
     * @param startDate the start date
     * @param endDate the end date
     */
    private void getRecords(Date startDate, Date endDate) {
        // TODO
    }

}
