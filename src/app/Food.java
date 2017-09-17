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
    private int id;
    private String foodGroup;   
    
    /**
    * This is the default constructor for the Food class.
    * @param foodName
    * @param servingSize
    * @param foodDate
    */     
    public Food(int id, String foodName, int servingSize, String foodGroup, DatePicker foodDate){
        this.id = id;
        this.foodName = foodName;
        this.servingSize = servingSize;
        this.foodGroup = foodGroup;
        this.foodDate = foodDate;
    }
    
   /**
    * Returns the id
    * @return An integer for the id
    */  
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    /**
    * Returns the foodName
    * @return A string for the food name
    */    
    public String getFoodName(){
        return foodName;
    }
    
    public void setFoodName(String foodName){
        this.foodName=foodName;
    }
    
    /**
     * Returns the servingSize
     * @return An integer for the serving size
     */
    public int getServingSize(){
        return servingSize;
    }
    
    public void setServingSize(int servingSize){
        this.servingSize=servingSize;
    }
    
    /**
     * Returns the foodDate
     * @return A DatePicker for the food date
     */
    public DatePicker getFoodDate(){
        return foodDate;
    }
    
    public void setFoodDate(DatePicker foodDate){
        this.foodDate=foodDate;
    }
    
    /**
     * Returns the foodGroup
     * @return A string for the food group
     */
    public String getFoodGroup(){
        return foodGroup;
    }
    
    public void setFoodGroup(String foodGroup){
        this.foodGroup=foodGroup;
    }
}
