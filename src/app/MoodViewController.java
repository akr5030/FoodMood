package app;

import dao.MoodRecordDao;
import java.net.URL;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;

/**
 * FXML Controller class
 *
 * @author waltereckard
 */
public class MoodViewController implements Initializable {

    //mood slider for excited
    @FXML
    private Slider moodExcited;

    //mood slider for happy
    @FXML
    private Slider moodHappy;

    //mood slider for meh
    @FXML
    private Slider moodMeh;

    //mood slider for sad
    @FXML
    private Slider moodSad;

    //mood slider for angry
    @FXML
    private Slider moodAngry;

    @FXML
    private DatePicker datePicker;

    private HashMap<Slider, Integer> moodIdMap;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        moodIdMap = new HashMap<>();
        moodIdMap.put(moodExcited, 1);
        moodIdMap.put(moodHappy, 2);
        moodIdMap.put(moodMeh, 3);
        moodIdMap.put(moodSad, 4);
        moodIdMap.put(moodAngry, 5);

        // set date to today (default)
        datePicker.setValue(LocalDate.now());
    }

    /**
     * Record the mood settings
     *
     * @param e the action event
     */
    @FXML
    public void handleSubmit(ActionEvent e) {

        // TODO need to hook up the code to get the current user's ID once feature is merged in
        String testAccountId = "account1";
        MoodRecordDao dao = new MoodRecordDao();

        // get the value for each slider and record it
        dao.saveMoodRecord(testAccountId, datePicker.getValue(),
                moodIdMap.getOrDefault(moodExcited, 0), moodExcited.getValue());
        dao.saveMoodRecord(testAccountId, datePicker.getValue(),
                moodIdMap.getOrDefault(moodHappy, 0), moodHappy.getValue());
        dao.saveMoodRecord(testAccountId, datePicker.getValue(),
                moodIdMap.getOrDefault(moodMeh, 0), moodMeh.getValue());
        dao.saveMoodRecord(testAccountId, datePicker.getValue(),
                moodIdMap.getOrDefault(moodSad, 0), moodSad.getValue());
        dao.saveMoodRecord(testAccountId, datePicker.getValue(),
                moodIdMap.getOrDefault(moodAngry, 0), moodAngry.getValue());

    }

}
