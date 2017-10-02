package foodmood;

import dao.DaoException;
import dao.FoodRecordDao;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import testHarness.TestHarness;

/**
 * FXML Controller class
 *
 * @author redjen
 */
public class FoodRecordViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        addFoodRecord();
        TestHarness.getInstance().testFoodRecordControllerAdd();
        TestHarness.getInstance().changeScene("/analytics/FoodLogView.fxml");
        
    }    
    
    public void addFoodRecord() {
        FoodRecord fr = new FoodRecord(1, 1, LocalDate.of(2017, 1, 1), "taco");
        FoodRecordDao dao = new FoodRecordDao();
        try {
            dao.saveFoodRecord(fr);
        } catch (DaoException ex) {
            Logger.getLogger(FoodRecordViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
