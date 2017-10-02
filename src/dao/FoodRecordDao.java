package dao;

import foodmood.FoodRecord;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    private final static String DATA_FILE = "data/foodrecord.csv";

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

        FoodRecord record = new FoodRecord(1, 1, LocalDate.now(), "test");
        ArrayList<FoodRecord> records = new ArrayList<>();
        records.add(record);

        return records;
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
        // for testing
        return getFoodRecords(startDate, endDate, 0);
    }

    public void saveFoodRecord(FoodRecord foodRecord) throws DaoException {
        ArrayList<FoodRecord> foods = new ArrayList<>();
        foods.add(foodRecord);
        saveFoodRecords(foods);
    }

    /**
     * Saves the specified food record
     *
     * @param foodRecord the food record to save
     * @throws dao.DaoException if there is an error connecting to the database
     * or executing the query
     */
    private void saveFoodRecord(FoodRecord foodRecord, PrintWriter pw) throws DaoException {
        pw.printf("%d,%d,%s,%s%n", foodRecord.getId(), foodRecord.getAccountId(),
                foodRecord.getDate().toString(), foodRecord.getFood());
    }

    /**
     * Saves the specified food records
     *
     * @param foodRecords the food records to save
     * @throws dao.DaoException if there is an error connecting to the database
     * or executing the query
     */
    public void saveFoodRecords(List<FoodRecord> foodRecords) throws DaoException {
        PrintWriter pw = null;
        File file = new File(DATA_FILE);

        try {

            pw = new PrintWriter(file);
            for (FoodRecord foodRecord : foodRecords) {
                saveFoodRecord(foodRecord, pw);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FoodRecordDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}
