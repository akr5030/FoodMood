package dao;

import foodmood.Food;
import foodmood.FoodRecord;
import foodmood.MoodRecord;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;
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

    //private final ConnectionManager cm;
    private final static String DATA_FILE = "data/foodrecord.csv";
    private final static String FILENAME_PATTERN = "%s_foods.txt";
    private final HashMap<Integer, String> foodNames;
    
    private final static int RECORDID = 0;
    private final static int ACCOUNTID = 1;
    private final static int DATE = 2;
    private final static int FOODID = 3;
    private final static int VALUE = 4;

    public FoodRecordDao() {
        //this.cm = new ConnectionManager();
        FoodDao dao;
        ArrayList<Food> foods;
        foodNames = new HashMap<>();

        try {
            dao = new FoodDao();
            foods = dao.getAllFoods();
            if (foods != null) {
                foods.forEach(mood -> foodNames.put(mood.getId(), mood.getFoodName()));
            }
        } catch (DaoException ex) {
            Logger.getLogger(FoodRecordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
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
    public ArrayList<FoodRecord> getFoodRecords(LocalDate startDate, LocalDate endDate, String accountId) throws DaoException {
        Path data = Paths.get(ConnectionManager.DATA_DIR, ConnectionManager.ACCOUNT_DATA_DIR, String.format(FILENAME_PATTERN, accountId));

        ArrayList<FoodRecord> records = new ArrayList<>();

        if (Files.exists(data)) {
            String line;
            try (BufferedReader in = Files.newBufferedReader(data)) {
                while ((line = in.readLine()) != null) {
                    FoodRecord record = parseRecord(line);
                    if ((!record.getDate().isBefore(startDate)) && !record.getDate().isAfter(endDate.plusDays(1))) {
                        records.add(record);
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(FoodRecordDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Logger.getLogger(FoodRecordDao.class.getName()).log(Level.INFO,
                    String.format("%s not found", data.toAbsolutePath().toString()));
        }
        return records;

//        FoodRecord record = new FoodRecord(1, 1, LocalDate.now(), "test");
//        ArrayList<FoodRecord> records = new ArrayList<>();
//        records.add(record);
//
//        return records;
    }

    /**
     * Saves a single food record
     *
     * @param accountId the account ID
     * @param date the date
     * @param foodId the food id
     * @param value the value
     */

    private void saveFoodRecord(String accountId, LocalDate date, int foodId, double value) throws DaoException {
        BufferedWriter bw = null;
    
    
    


        Path data = Paths.get(ConnectionManager.DATA_DIR,
                ConnectionManager.ACCOUNT_DATA_DIR, String.format(FILENAME_PATTERN, accountId));

        String recordId = UUID.randomUUID().toString();

        FoodRecord record = new FoodRecord(recordId, accountId, date, foodId, "", value);

        try {
            if (!Files.exists(data)) {
                Files.createFile(data);
            }
            bw = Files.newBufferedWriter(data, StandardOpenOption.APPEND);
            String recordText = writeRecord(record);
            System.out.printf("New mood recorded: [%s]%n", recordText);
            bw.write(recordText);
            bw.write("\n");
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(FoodRecordDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(FoodRecordDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    /**
     * Deletes the specified record if it exists
     *
     * @param record the record to remove
     * @throws DaoException if an exception occurs
     */
    public void deleteRecord(FoodRecord record) throws DaoException {
        Path data = Paths.get(ConnectionManager.DATA_DIR,
                ConnectionManager.ACCOUNT_DATA_DIR, String.format(FILENAME_PATTERN, record.getAccountId()));
        ArrayList<FoodRecord> records = getFoodRecords(LocalDate.MIN, LocalDate.MAX.minusDays(1), record.getAccountId());

        boolean removed = records.remove(record);

        // remove the existing data and write the new list without the deleted record
        if (removed) {
            try {
                Files.deleteIfExists(data);
            } catch (IOException ex) {
                Logger.getLogger(FoodRecordDao.class.getName()).log(Level.SEVERE, null, ex);
            }

            try (BufferedWriter out = Files.newBufferedWriter(data)) {

                for (FoodRecord r : records) {
                    out.write(writeRecord(record));
                }

            } catch (IOException ex) {
                Logger.getLogger(FoodRecordDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    /**
     * Returns a new FoodRecord by parsing information from a string
     *
     * @param line a string with record information
     * @return the new MoodRecord
     * @throws dao.DaoException if the string is not in the correct format
     */
    protected FoodRecord parseRecord(String line) throws DaoException {
        String[] attributes = line.split(",");

        if (attributes.length != 5) {
            throw new DaoException("Record was in invalid format");
        }

        return new FoodRecord(attributes[RECORDID],
                attributes[ACCOUNTID],
                LocalDate.parse(attributes[DATE]),
                Integer.parseInt(attributes[FOODID]),
                foodNames.getOrDefault(attributes[FOODID], " "),
                Double.parseDouble(attributes[VALUE]));
    }
    
    /**
     * Generates a string representing the record for use in data files
     *
     * @param record the record
     * @return a string representation of the record
     */
    protected String writeRecord(FoodRecord record) {
        StringBuilder sb = new StringBuilder();
        sb.append(record.getId());
        sb.append(",");
        sb.append(record.getAccountId());
        sb.append(",");
        sb.append(record.getDate().toString());
        sb.append(",");
        sb.append(record.getFoodId());
        sb.append(",");
        sb.append(record.getValue());
        return sb.toString();
    }
}
