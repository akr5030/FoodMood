package dao;

import foodmood.Mood;
import foodmood.MoodRecord;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The MoodRecordDao class provides an interface to read and write mood records
 * to the application database.
 *
 * @author jsm158
 *
 */
public class MoodRecordDao {

    private final static String FILENAME_PATTERN = "%s_moods.txt";
    private final HashMap<Integer, String> moodNames;

    // index of fields in a line
    private final static int RECORDID = 0;
    private final static int ACCOUNTID = 1;
    private final static int DATE = 2;
    private final static int MOODID = 3;
    private final static int VALUE = 4;

    public MoodRecordDao() {

        MoodDao dao;
        moodNames = new HashMap<>();

        try {
            dao = new MoodDao();
            ArrayList<Mood> moods = dao.getAllMoods();
            moods.forEach(mood -> moodNames.put(mood.getId(), mood.getMoodName()));
        } catch (DaoException ex) {
            Logger.getLogger(MoodRecordDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns all of the mood records associated with the specified user and
     * within the specified date range (inclusive)
     *
     * @param startDate the start of the date range (inclusive)
     * @param endDate the end of the date range (inclusive)
     * @param accountId the ID of the account associated with the records
     * @return the list of mood records
     * @throws dao.DaoException if the file could not be read
     */
    public ArrayList<MoodRecord> getMoodRecords(LocalDate startDate, LocalDate endDate, String accountId) throws DaoException {
        // TODO refactor this if  https://github.com/redjen/FoodMood/pull/14 is approved
        Path data = Paths.get(ConnectionManager.DATA_DIR, ConnectionManager.ACCOUNT_DATA_DIR, String.format(FILENAME_PATTERN, accountId));

        ArrayList<MoodRecord> records = new ArrayList<>();

        if (Files.exists(data)) {
            String line;
            try (BufferedReader in = Files.newBufferedReader(data)) {
                while ((line = in.readLine()) != null) {
                    MoodRecord record = parseRecord(line);
                    if ((!record.getDate().isBefore(startDate)) && !record.getDate().isAfter(endDate.plusDays(1))) {
                        records.add(record);
                    }
                }
            } catch (IOException | DaoException ex) {
                Logger.getLogger(MoodRecordDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            Logger.getLogger(MoodRecordDao.class.getName()).log(Level.INFO,
                    String.format("%s not found", data.toAbsolutePath().toString()));
        }
        return records;
    }

    /**
     * Saves a single mood record
     *
     * @param accountId
     * @param date
     * @param moodId
     * @param value
     */
    public void saveMoodRecord(String accountId, LocalDate date, int moodId, double value) {

        BufferedWriter bw = null;

        Path data = Paths.get(ConnectionManager.DATA_DIR,
                ConnectionManager.ACCOUNT_DATA_DIR, String.format(FILENAME_PATTERN, accountId));

        String recordId = UUID.randomUUID().toString();

        // TODO replace the empty string for moodId with the correct value once 
        MoodRecord record = new MoodRecord(recordId, accountId, date, moodId, "", value);

        try {
            if (!Files.exists(data)) {
                Files.createFile(data);
            }
            bw = Files.newBufferedWriter(data, StandardOpenOption.APPEND);
            bw.write(writeRecord(record));
            bw.write("\n");
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(MoodRecordDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(MoodRecordDao.class.getName()).log(Level.SEVERE, null, ex);
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
    public void deleteRecord(MoodRecord record) throws DaoException {
        Path data = Paths.get(ConnectionManager.DATA_DIR,
                ConnectionManager.ACCOUNT_DATA_DIR, String.format(FILENAME_PATTERN, record.getAccountId()));
        ArrayList<MoodRecord> records = getMoodRecords(LocalDate.MIN, LocalDate.MAX.minusDays(1), record.getAccountId());

        boolean removed = records.remove(record);

        // remove the existing data and write the new list without the deleted record
        if (removed) {
            try {
                Files.deleteIfExists(data);
            } catch (IOException ex) {
                Logger.getLogger(MoodRecordDao.class.getName()).log(Level.SEVERE, null, ex);
            }

            try (BufferedWriter out = Files.newBufferedWriter(data)) {

                for (MoodRecord r : records) {
                    out.write(writeRecord(record));
                }

            } catch (IOException ex) {
                Logger.getLogger(MoodRecordDao.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Returns a new MoodRecord by parsing information from a string
     *
     * @param line a string with record information
     * @return the new MoodRecord
     * @throws dao.DaoException if the string is not in the correct format
     */
    protected MoodRecord parseRecord(String line) throws DaoException {
        String[] attributes = line.split(",");

        if (attributes.length != 5) {
            throw new DaoException("Record was in invalid format");
        }

        return new MoodRecord(attributes[RECORDID],
                attributes[ACCOUNTID],
                LocalDate.parse(attributes[DATE]),
                Integer.parseInt(attributes[MOODID]),
                moodNames.getOrDefault(attributes[MOODID], ""),
                Double.parseDouble(attributes[VALUE]));
    }

    /**
     * Generates a string representing the record for use in data files
     *
     * @param record the record
     * @return a string representation of the record
     */
    protected String writeRecord(MoodRecord record) {
        StringBuilder sb = new StringBuilder();
        sb.append(record.getId());
        sb.append(",");
        sb.append(record.getAccountId());
        sb.append(",");
        sb.append(record.getDate().toString());
        sb.append(",");
        sb.append(record.getMoodId());
        sb.append(",");
        sb.append(record.getValue());
        return sb.toString();
    }
}
