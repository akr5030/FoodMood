package dao;

import java.util.ArrayList;

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

    /**
     * Constructs a new MoodDao
     */
    public MoodDao() {
    }

    /**
     * Returns a list of all moods in the database
     *
     * @return a list of moods
     * @throws DaoException if there is an error connecting to the database or
     * executing the query
     */
    public ArrayList<Object> getAllMoods() throws DaoException {
        return null;
    }

    /**
     * Returns the mood object with the specified ID
     * 
     * This method returns null if there is no mood with the specified ID
     * 
     * @param moodId the mood ID
     * @return the specified mood or null if there is no match
     * @throws dao.DaoException 
     */
    public Object getMoodById(int moodId) throws DaoException {
        return null;
    }
}
