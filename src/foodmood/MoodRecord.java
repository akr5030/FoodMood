package foodmood;

import java.util.Date;

/**
 * Mood Record Class
 *
 * The food record class is what a user has entered for a mood.
 *
 * @author aswecker
 */

public class MoodRecord {
    private int id;
    private int accountId;
    private Date date;
    private String mood;
    
    
    /**
    * This is the default constructor for the Mood Record Class.
    * @param id the id number of the mood
    * @param accountId the account number of the user
    * @param date the date the mood was logged
    * @param mood the mood the user logged
    */ 
    public MoodRecord(int id, int accountId, Date date, String mood){
        this.id = id;
        this.accountId = accountId;
        this.date = date;
        this.mood = mood;
    }
    
    /**
    * Returns the mood ID
    * @return An integer for the mood ID
    */ 
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id=id;
    }
    
    /**
    * Returns the date
    * @return the date the user logged a mood
    */ 
    public int getAccountId(){
        return accountId;
    }
    
    public void setAccountId(int accountId){
        this.accountId=accountId;
    }
    
    /**
    * Returns the date
    * @return the date a user logged a mood
    */ 
    public Date getDate(){
        return date;
    }
    
    public void setDate(Date date){
        this.date=date;
    }
    
    /**
    * Returns the mood name
    * @return A string of the mood name
    */ 
    public String getMood(){
        return mood;
    }
    
    public void setMood(String mood){
        this.mood=mood;
    }
}
