package analytics;

import dao.DaoException;
import dao.FoodRecordDao;
import foodmood.FoodController;
import foodmood.FoodRecord;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TreeView;
import testHarness.*;

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
    private ArrayList<FoodRecord> foods;

    /**
     * The tree list displaying the food records
     */
    @FXML
    private TreeView<FoodRecord> treeView;

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

        Logger.getLogger(FoodLogViewController.class.getName()).log(Level.INFO, "Loaded FoodLogViewController");

        try {

            getRecords(LocalDate.of(2017, Month.SEPTEMBER, 1), LocalDate.of(2017, Month.SEPTEMBER, 7));
            // Test getting the list of food records entered by the user
            // These records should have already been created in a previous step.
            handleChangeDatesButton(new ActionEvent());
            TestHarness.getInstance().testFoodLogViewControllerGetFoodRecords();

            // Test deleting a food record
            handleDeleteRecordButton(new ActionEvent());
            TestHarness.getInstance().testFoodLogViewControllerDeleteFood();

            // Move on to the next test
            TestHarness.getInstance().changeScene("/analytics/MoodLogView.fxml");

        } catch (DaoException ex) {
            Logger.getLogger(FoodLogViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateView()  {
        try {
            LocalDate startDate = LocalDate.of(2017, Month.SEPTEMBER, 1);
            LocalDate endDate = LocalDate.of(2017, Month.SEPTEMBER, 6);
            
            getRecords(startDate, endDate);
        } catch (DaoException ex) {
            Logger.getLogger(FoodLogViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteRecord() {
        if (!foods.isEmpty()) {

            try {
                FoodRecordDao dao = new FoodRecordDao();
                dao.saveFoodRecords(foods);
            } catch (DaoException ex) {
                Logger.getLogger(FoodLogViewController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
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
        updateView();
    }

    /**
     * Deletes the selected food record
     *
     * @param e the associated event
     */
    @FXML
    private void handleDeleteRecordButton(ActionEvent e) {
        deleteRecord();
    }

    /**
     * Updates the food list
     *
     * Throws an IllegalArgumentException if the startDate occurs after the end
     * date.
     *
     * @param startDate the start date
     * @param endDate the end date
     */
    private void getRecords(LocalDate startDate, LocalDate endDate) throws DaoException {
        foods = new ArrayList<>();
        
//        FoodController fc = new FoodController();
        
        
    }

}
