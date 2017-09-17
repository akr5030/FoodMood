/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javafx.scene.control.DatePicker;
import javafx.scene.control.Slider;

/**
 *
 * @author aswecker
 */
public class Mood {
    private int id;
    private Slider moodType;
    private DatePicker moodDate;
    
    /**
    * This is the default constructor for the Mood class.
    * @param moodType
    * @param moodDate
    */ 
    public Mood(Slider moodType, DatePicker moodDate){
        this.moodType = moodType;
        this.moodDate = moodDate;
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
    * Returns the moodType
    * @return A slider for the food name
    */ 
    public Slider getMoodType(){
        return moodType;
    }
    
    public void setMoodType(Slider moodType){
        this.moodType=moodType;
    }
    
    /**
     * Returns the moodDate
     * @return A date for the mood date
     */
    public DatePicker getMoodDate(){
        return moodDate;
    }
    
    public void setMoodDate(DatePicker moodDate){
        this.moodDate=moodDate;
    }
}





