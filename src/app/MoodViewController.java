package app;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;

/**
 * FXML Controller class
 *
 * @author waltereckard
 */
public class MoodViewController implements Initializable {

    //mood slider for excited
    @FXML
    private Slider Excited;
    
    //mood slider for happy
    @FXML
    private Slider Happy;
    
    //mood slider for meh
    @FXML
    private Slider Meh;
    
    //mood slider for sad
    @FXML
    private Slider Sad;
    
    //mood slider for angry
    @FXML
    private Slider Angry;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
