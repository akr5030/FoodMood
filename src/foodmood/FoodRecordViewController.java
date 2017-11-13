package foodmood;

import dao.FoodDao;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

/**
 * FXML Controller class
 *
 * @author redjen
 */


        
public class FoodRecordViewController implements Initializable {

    private FoodDao f;
@FXML
private ListView foodListView;
    

    
    
    //private final ArrayList foods = new ArrayList();
    
    

    /**
     * Initializes the controller class.
     * @param url the url (path) to the associated FXML document
     * @param rb the application's resource bundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        //ListView<String> list = new ListView<>();
        
ObservableList<String> items = FXCollections.observableArrayList("Milk","Pizza");        

    
  
    
         
            
    foodListView.setItems( items);
    }

//        addFoodRecord();
//        TestHarness.getInstance().testFoodRecordControllerAdd();
//        TestHarness.getInstance().changeScene("/analytics/FoodLogView.fxml");
        
        
    /**
     * Allows the user to add a food record.
     */
    public void addFoodRecord() {
//        FoodRecord fr = new FoodRecord(1, 1, LocalDate.of(2017, 1, 1), "taco");
//        FoodRecordDao dao = new FoodRecordDao();
//        try {
//            dao.saveFoodRecord(fr);
//        } catch (DaoException ex) {
//            Logger.getLogger(FoodRecordViewController.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
}
