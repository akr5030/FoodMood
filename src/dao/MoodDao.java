package dao;

import foodmood.Mood;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Provides methods for reading mood objects from the database.
 *
 * Write functionality is not provided because our requirements do not allow the
 * creation of new moods. However, this could be added in the future.
 *
 * @author jsm158
 *
 */
public class MoodDao {
    
    private final ConnectionManager cm;
    private static final String COMMA_DELIMITER = ",";
    //private static final String NEW_LINE = "\n";
    //private static final String FILE_HEADER = "Id,MoodName";

    private static final int MOOD_ID_INDEX = 0;
    private static final int MOOD_NAME_INDEX = 1;

    /**
     * Constructs a new MoodDao
     */
    public MoodDao() {
        this.cm = new ConnectionManager();
    }

    /**
     * Returns a list of all moods in the database
     *
     * @return a list of moods
     * @throws DaoException if there is an error connecting to the database or
     * executing the query
     */
    public ArrayList<Mood> getAllMoods() throws DaoException {
        BufferedReader reader = null;
        try {
            ArrayList<Mood> moods = new ArrayList<Mood>();
            String ln = "";

            reader = new BufferedReader(new FileReader("data/Moods.csv"));
            reader.readLine();

            while ((ln = reader.readLine()) != null) {
                String[] obj = ln.split(COMMA_DELIMITER);
                if (obj.length > 0) {
                    Mood md = new Mood(Integer.parseInt(obj[MOOD_ID_INDEX]), obj[MOOD_NAME_INDEX]);
                    moods.add(md);
                }

                //Print Moods
//                for (Mood md : moods) {
//                    System.out.println(md.toString());
//                }

            }
            return moods;
            //TestHarness.getInstance().testMoodControllerRead(moods);

        } catch (Exception e) {
            System.out.println("Error in reading CSV file");
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error closing fileReader");
                e.printStackTrace();
            }
        }
    }

    /**
     * Returns the mood object with the specified ID
     * 
     * This method returns null if there is no mood with the specified ID
     * 
     * @param moodId the mood ID
     * @return the specified mood or null if there is no match
     * @throws dao.DaoException if there is an error connecting to the database or
     * executing the query
     */
    public Mood getMoodById(int moodId) throws DaoException {
        BufferedReader reader = null;
        Mood rtnValue = null;
        try {
            String ln = "";
            reader = new BufferedReader(new FileReader("data/Moods.csv"));
            reader.readLine();

            while ((ln = reader.readLine()) != null) {
                String[] obj = ln.split(COMMA_DELIMITER);
                if (obj.length > 0) {
                    Mood md = new Mood(Integer.parseInt(obj[MOOD_ID_INDEX]), obj[MOOD_NAME_INDEX]);
                    if(md.getId() == moodId){
                        rtnValue = md;
                    }
                }
            }
            return rtnValue;
        } catch (Exception e) {
            System.out.println("Error in reading CSV file");
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error closing fileReader");
                e.printStackTrace();
            }
        }
    }
    
}
