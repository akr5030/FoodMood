package dao;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * The MoodRecordDao class provides an interface to read and write mood records
 * to the application database.
 * 
 * @author jsm158
 *
 */
public class MoodRecordDao {
    
    public MoodRecordDao() {
    }

    /**
     * Returns all of the mood records associated with the specified user and
     * within the specified date range (inclusive)
     *
     * @param startDate the start of the date range (inclusive)
     * @param endDate the end of the date range (inclusive)
     * @param accountId the ID of the account associated with the records
     * @return the list of mood records
     */
    public ArrayList<Object> getMoodRecords(Date startDate, Date endDate, int accountId) {
        return null;
    }

    /**
     * Returns all of the mood records entered by any user within the specified
     * date range (inclusive)
     *
     * @param startDate the start of the date range (inclusive)
     * @param endDate the end of the date range (inclusive)
     * @return the list of mood records
     */
    public ArrayList<Object> getMoodRecords(Date startDate, Date endDate) {
        return null;
    }

    /**
     * Saves a single mood record
     *
     * @param moodRecord the mood record to save
     */
    public void saveMoodRecord(Object moodRecord) {

    }

    /**
     * Saves a list of mood records
     *
     * @param moodRecords the mood record to save
     */
    public void saveMoodRecords(List<Object> moodRecords) {

    }
    
       /**
     * Generates a new, unique ID for the mood entry
     * 
     * Creating the ID elsewhere is not recommended as uniqueness needs to be
     * enforced.
     * 
     * @return a new unique ID
     */
    private UUID generateRecordId() throws DaoException {
        return null;
    }
}
