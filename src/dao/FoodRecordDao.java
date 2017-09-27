package dao;

import foodmood.FoodRecord;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Provides the ability to read and write food records to the database.
 *
 * These records are the food items that users have entered into the
 * application, not individual food items. 
 *
 * @author jsm158
 */
public class FoodRecordDao {
    
    private final ConnectionManager cm;

    public FoodRecordDao() {
        this.cm = new ConnectionManager();
    }

    /**
     * Returns the food entries created by the specified account within the
     * specified date range
     *
     * The start and end dates are inclusive.
     *
     * @param startDate the first date for records to include (inclusive)
     * @param endDate the end date for records to include (inclusive)
     * @param accountId the ID of the account
     * @return a list of food records
     * @throws dao.DaoException if there is an error connecting to the database
     * or executing the query
     */
    public ArrayList<FoodRecord> getFoodRecords(LocalDate startDate, LocalDate endDate, int accountId) throws DaoException {
        return null;
    }

    /**
     * Returns the food entries created by any account within the specified date
     * range The start and end dates are inclusive.
     *
     * @param startDate the first date for records to include (inclusive)
     * @param endDate the end date for records to include (inclusive)
     * @return a list of food records
     * @throws dao.DaoException if there is an error connecting to the database
     * or executing the query
     */
    public ArrayList<FoodRecord> getFoodRecords(LocalDate startDate, LocalDate endDate) throws DaoException {
        return null;
    }

    /**
     * Saves the specified food record
     *
     * @param foodRecord the food record to save
     * @throws dao.DaoException if there is an error connecting to the database
     * or executing the query
     */
    public void saveFoodRecord(FoodRecord foodRecord) throws DaoException {

    }

    /**
     * Saves the specified food records
     *
     * @param foodRecords the food records to save
     * @throws dao.DaoException if there is an error connecting to the database
     * or executing the query
     */
    public void saveFoodRecords(List<FoodRecord> foodRecords) throws DaoException {

    }
    
    /**
     * Generates a new, unique ID for the food entry
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
