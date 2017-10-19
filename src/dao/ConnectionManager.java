package dao;

/**
 * Provides a connection to the application database.
 *
 * We chose to use files for storage, so this class returns the location of
 * files, directories, and paths.
 *
 * @author jsm158
 *
 */
public class ConnectionManager {

    public static final String DATA_DIR = "data";
    public static final String ACCOUNT_DATA_DIR = "accountData";
    public static final String MOOD_RECORD_FILE = "moodRecords.txt";

    /**
     * Constructs a new ConnectionManager
     */
    public ConnectionManager() {
    }

}
