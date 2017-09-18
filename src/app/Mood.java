package app;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;

/**
 * Mood class
 *
 * The mood class gives the user the option to he moods the user has logged within the specified date
 * range. The moods are displayed as a line chart and as a list. Users can
 * delete mood records.
 *
 * On first launch it will display the records entered for the current day and
 * seven days previous. The user can change the date range.
 *
 * @author aswecker
 */

public class Mood {
    private int id;
    private String moodName;
    private Slider moodType;
    private DatePicker moodDate;
    
    /**
    * This is the default constructor for the Mood class.
    * @param id the id of the mood
    * @param moodName the name of the mood
    */ 
    public Mood(int id, String moodName){
        this.id = id;
        this.moodName = moodName;
    }
    
    /**
    * Returns the mood ID
    * @return An integer for the ID
    */ 
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    /**
    * Returns the mood name
    * @return A string for the name of the mood
    */ 
    public String getMoodName(){
        return moodName;
    }
    
    public void setMoodName(String moodName){
        this.moodName = moodName;
    }
    
}





