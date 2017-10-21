package dao;

import foodmood.Mood;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

////    private final ConnectionManager cm;
    private static final String FILE_PATH = "data/Moods.csv";
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE = "\n";
    private static final String FILE_HEADER = "Id,MoodName";

    private static final int MOOD_ID_INDEX = 0;
    private static final int MOOD_NAME_INDEX = 1;

    /**
     * Constructs a new MoodDao
     */
    public MoodDao() throws DaoException {
        File f = new File(FILE_PATH);
        if (!f.exists() && !f.isDirectory()) {
            createMoods();
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
        BufferedReader reader = null;
        ArrayList<Mood> moods = new ArrayList<Mood>();
        try {
            String ln = "";

            reader = new BufferedReader(new FileReader(FILE_PATH));
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

            //TestHarness.getInstance().testMoodControllerRead(moods);
        } catch (IOException | NumberFormatException e) {
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
        return moods;
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
        BufferedReader reader = null;
        Mood rtnValue = null;
        try {
            String ln = "";
            reader = new BufferedReader(new FileReader(FILE_PATH));
            reader.readLine();

            boolean found = false;
            while ((ln = reader.readLine()) != null && !found) {
                String[] obj = ln.split(COMMA_DELIMITER);
                if (obj.length == 2) {
                    Mood md = new Mood(Integer.parseInt(obj[MOOD_ID_INDEX]), obj[MOOD_NAME_INDEX]);
                    if (md.getId() == moodId) {
                        rtnValue = md;
                        found = true;
                    }
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error in reading CSV file");
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing fileReader");
                e.printStackTrace();
            }
        }
        return rtnValue;
    }

    public void createMoods() throws DaoException {
        Mood m = new Mood(1, "Excited");
        Mood m1 = new Mood(2, "Happy");
        Mood m2 = new Mood(3, "Meh");
        Mood m3 = new Mood(4, "Sad");
        Mood m4 = new Mood(5, "Angry");

        List<Mood> moods = new ArrayList<Mood>();

        moods.add(m);
        moods.add(m1);
        moods.add(m2);
        moods.add(m3);
        moods.add(m4);

        File file = new File(FILE_PATH);
        FileWriter writer = null;

        try {
            writer = new FileWriter(file);
            writer.append(FILE_HEADER);
            writer.append(COMMA_DELIMITER);
            writer.append(NEW_LINE);

            for (Mood md : moods) {
                writer.append(String.valueOf(md.getId()));
                writer.append(COMMA_DELIMITER);
                writer.append(md.getMoodName());
                writer.append(NEW_LINE);
            }
        } catch (IOException e) {
            System.out.println("Error writing CSV file");
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.flush();
                    writer.close();
                }
            } catch (IOException e) {
                System.out.println("Error closing the fileWriter");
                e.printStackTrace();
            }
        }
    }
}
