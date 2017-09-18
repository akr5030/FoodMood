package foodmood;

import java.util.Date;

/**
 * Food Record Class
 *
 * The food record class is what a user has entered for a food.
 *
 * @author aswecker
 */

public class foodRecord {
    private int id;
    private int accountId;
    private Date date;
    private String food;
    
    
    /**
    * This is the default constructor for the Food Record Class.
    * @param id the id number of the food
    * @param accoundId the account number of the user
    * @param date the date the food was logged
    * @param food the food the user logged
    */ 
    public foodRecord(int id, int accountId, Date date, String food){
        this.id = id;
        this.accountId = accountId;
        this.date = date;
        this.food = food;
    }
    
    /**
    * Returns the food ID
    * @return An integer for the food ID
    */ 
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    /**
    * Returns the date
    * @return the date the user logged a food
    */ 
    public int getAccountId(){
        return accountId;
    }
    
    public void setAccountId(int accountId){
        this.accountId=accountId;
    }
    
    /**
    * Returns the date
    * @return the date a user logged a food
    */ 
    public Date getDate(){
        return date;
    }
    
    public void setDate(Date date){
        this.date=date;
    }
    
    /**
    * Returns the food name
    * @return A string of the food name
    */ 
    public String getFood(){
        return food;
    }
    
    public void setFood(String food){
        this.food=food;
    }
}
