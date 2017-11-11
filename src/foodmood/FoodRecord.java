package foodmood;

import java.time.LocalDate;
import java.util.Date;
import java.util.Objects;

/**
 * Food Record Class
 *
 * The food record class is what a user has entered for a food.
 *
 * @author aswecker
 */

public class FoodRecord implements Quantifiable {
    private final String id;
    private final int accountId;
    private final LocalDate date;
    private final int foodId;
    private final String foodName;
    private final double value;
    
    
    /**
    * This is the default constructor for the Food Record Class.
    * @param id the id number of the food
    * @param accountId the account number of the user
    * @param date the date the food was logged
    * @param food the food the user logged
    */ 
    public FoodRecord(String id, int accountId, LocalDate date, int foodId, String foodName, double value){
        this.id = id;
        this.accountId = accountId;
        this.date = date;
        this.foodId = foodId;
        this.foodName = foodName;
        this.value = value;
    }
    
    /**
    * Returns the food ID
    * @return An integer for the food ID
    */ 
    public int getId(){
        return id;
    }
    
    /**
    * Returns the accountID
    * @return the date the user logged a food
    */ 
    public int getAccountId(){
        return accountId;
    }
    
    /**
    * Returns the date
    * @return the date a user logged a food
    */
    @Override
    public LocalDate getDate(){
        return date;
    }
    
    /**
    * Returns the associated food name
    * @return A string of the food name
    */ 
    @Override
    public String getName(){
        return foodName;
    }
    
    /**
    * Returns the value logged for the food
    * @return the value
    */ 
    @Override
    public double getValue(){
        return value;
    }
    
    /**
     * Returns the ID of the associated food
     *
     * @return the food ID
     */
    public int getFoodId() {
        return foodId;
    }
    
    @Override
    public boolean equals(Object o) {
        if (FoodRecord.class.isAssignableFrom(o.getClass())) {
            FoodRecord f = (FoodRecord) o;
            return (this.id.equals(f.id));
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.id);
        return hash;
    }
    
}
