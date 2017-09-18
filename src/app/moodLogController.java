package app;

import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;

/**
 *
 * @author aswecker
 */

@FXML
public class moodLogController {
    /**
     * The date picker for the date a user is logging food
     */
    private DatePicker startDatePicker;
    
    /**
     * The sliders for the moods
     */
    Slider aSlider = new Slider(0, 1, 0.5);
    Slider bSlider = new Slider(0, 1, 0.5);
    Slider cSlider = new Slider(0, 1, 0.5);
    Slider dSlider = new Slider(0, 1, 0.5);
    Slider eSlider = new Slider(0, 1, 0.5);
    
    /**
     * The save button
     */
    private Button saveButton;
    
}
