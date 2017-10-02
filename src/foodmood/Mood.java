package foodmood;


/**
 * Mood class
 *
 * The mood class gives the user the option to log moods. The mood
 * name is the field that a user can edit.
 *
 * @author aswecker
 */

public class Mood {
    private int id;
    private String moodName;
    
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





