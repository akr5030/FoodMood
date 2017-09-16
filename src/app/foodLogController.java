package app;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 *
 * @author aswecker
 */
public class foodLogController {
    /**
     * The date picker for the date a user is logging food
     */
    private DatePicker startDatePicker;
 
    /**
     * The radio button for breakfast
     */
    RadioButton button1 = new RadioButton("Breakfast");
    RadioButton button2 = new RadioButton("Lunch");
    RadioButton button3 = new RadioButton("Dinner");
    RadioButton button4 = new RadioButton("Snack");
    
    /**
     * The meal search
     */
    Label label1 = new Label("Search:");
    TextField textField = new TextField ();
    
    //lists food from API
    
    
    /**
     * The save button
     */
    private Button saveButton;

}
