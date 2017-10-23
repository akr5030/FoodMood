package dao;

import app.Environment;
import foodmood.Mood;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods for reading mood objects from the database.
 *
 * Write functionality is not provided because our requirements do not allow the
 * creation of new moods. However, this could be added in the future.
 *
 * @author matt cano
 *
 */
public class MoodDao {

    Environment e = new Environment();
    ArrayList<Mood> m = new ArrayList<Mood>();

    /**
     * Constructs a new MoodDao
     */
    public MoodDao() throws DaoException {
        m = createMoods();
        if(e.getEnvironment()== "development"){
            System.out.println("Loaded Moods:");
            for(Mood md : m){
                System.out.println(md.getMoodName());
            }
        }
    }

    /**
     * Returns a list of all moods in the database
     *
     * @return a list of moods
     * @throws DaoException if there is an error connecting to the database or
     * executing the query
     */
    public ArrayList<Mood> getAllMoods() throws DaoException {
        return m;
    }

    /**
     * Returns the mood object with the specified ID
     *
     * This method returns null if there is no mood with the specified ID
     *
     * @param moodId the mood ID
     * @return the specified mood or null if there is no match
     * @throws dao.DaoException if there is an error connecting to the database
     * or executing the query
     */
    public Mood getMoodById(int moodId) throws DaoException {
        Mood rtnValue = null;
        try {
            for (Mood md : m) {
                if (md.getId() == moodId) {
                    rtnValue = md;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error in reading CSV file");
            //e.printStackTrace();
        }
        return rtnValue;
    }

    public ArrayList<Mood> createMoods() throws DaoException {
        Mood m = new Mood(1, "Excited");
        Mood m1 = new Mood(2, "Happy");
        Mood m2 = new Mood(3, "Meh");
        Mood m3 = new Mood(4, "Sad");
        Mood m4 = new Mood(5, "Angry");

        ArrayList<Mood> moods = new ArrayList<Mood>();

        try {
            moods.add(m);
            moods.add(m1);
            moods.add(m2);
            moods.add(m3);
            moods.add(m4);

        } catch (Exception ex) {
            System.out.println("Error creating moods....");
//            e.printStackTrace();
        }

        return moods;
    }
}
