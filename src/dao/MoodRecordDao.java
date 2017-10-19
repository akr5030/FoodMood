package dao;

import foodmood.MoodRecord;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
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

    private final static String FILENAME_PATTERN = "%s.txt";
    private final HashMap<String, String> moodNames;

    // positions of parts of a mood record
    private static enum Record {
        RECORDID,
        ACCOUNTID,
        DATE,
        MOODID,
        MOODNAME,
        VALUE
    }

    public MoodRecordDao() {
        
        // Get the list of moods and their names
        moodNames = new HashMap<>();
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
    public ArrayList<MoodRecord> getMoodRecords(Date startDate, Date endDate, String accountId) throws DaoException {
        ArrayList<MoodRecord> records = new ArrayList<>();
        Path data = Paths.get(ConnectionManager.DATA_DIR, ConnectionManager.ACCOUNT_DATA_DIR, String.format(FILENAME_PATTERN, accountId));

        if (Files.exists(data)) {
            try (BufferedReader in = Files.newBufferedReader(data)) {
                while (in != null) {

                }
            } catch (IOException ex) {
                throw new DaoException("Could not read mood record file " + data.toAbsolutePath().toString(), ex);
            }
        }

        return records;
    }

    /**
     * Returns all of the mood records entered by any user within the specified
     * date range (inclusive)
     *
     * @param startDate the start of the date range (inclusive)
     * @param endDate the end of the date range (inclusive)
     * @return the list of mood records
     */
    public ArrayList<MoodRecord> getMoodRecords(Date startDate, Date endDate) {
        return null;
    }

    /**
     * Saves a single mood record
     *
     * @param moodRecord the mood record to save
     */
    public void saveMoodRecord(MoodRecord moodRecord) {

    }

    /**
     * Saves a list of mood records
     *
     * @param moodRecords the mood record to save
     */
    public void saveMoodRecords(List<MoodRecord> moodRecords) {

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

    /**
     * Returns a new MoodRecord by parsing information from a string
     *
     * @param line a string with record information
     * @return the new MoodRecord
     */
    private MoodRecord parseRecord(String line) {
        String[] attributes = line.split(",");

        return new MoodRecord(attributes[Record.RECORDID.ordinal()],
                attributes[Record.ACCOUNTID.ordinal()],
                LocalDate.parse(attributes[Record.DATE.ordinal()]),
                attributes[Record.MOODID.ordinal()],
                "",
                Double.parseDouble(attributes[Record.VALUE.ordinal()]));

    }
}
