/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import javafx.scene.control.DatePicker;

/**
 *
 * @author aswecker
 */
public class Food {
    private String foodName;
    private int servingSize;
    private DatePicker foodDate;
    
    
    public Food(String foodName, int servingSize, DatePicker foodDate){
        this.foodName = foodName;
        this.servingSize = servingSize;
        this.foodDate = foodDate;
    }
    
    public String foodName(){
        return foodName;
    }
    
    public int servingSize(){
        return servingSize;
    }
    
    public DatePicker foodDate(){
        return foodDate;
    }
}
