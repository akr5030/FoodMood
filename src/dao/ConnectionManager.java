package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Provides file locations, creation of data directory, and deletion of data
 * directory
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

    /**
     * Constructs a new ConnectionManager
     */
    public ConnectionManager() {
    }

    /**
     * Create the data directory if it does not already exist
     *
     * @throws DaoException if the directory cannot be created
     */
    public static void createDatabaseIfNotExists() throws DaoException {

        Path data = Paths.get(DATA_DIR);
        if (!Files.exists(data)) {
            try {
                Files.createDirectory(data);
                Files.createDirectory(Paths.get(DATA_DIR, ACCOUNT_DATA_DIR));
            } catch (IOException ex) {
                throw new DaoException("Could not create data directory", ex);
            }
        }

    }

    /**
     * Deletes the data directory
     */
    public static void deleteDatabase() {

        deleteDatabaseHelper(Paths.get(DATA_DIR));

    }

    /**
     * Helper method to recursively delete the files and subdirectories within
     * the data directory
     *
     * Java requires that directories be empty before you can delete them
     *
     * @param path the path of the file/directory to be deleted
     */
    private static void deleteDatabaseHelper(final Path path) {
        if (path != null) {

            try {
                if (!Files.isDirectory(path)) {
                    Files.delete(path);
                } else {
                    
                    // see http://www.oracle.com/technetwork/articles/java/ma14-java-se-8-streams-2177646.html
                    // for an explanation of streams and foreach
                    Files.newDirectoryStream(path).forEach(filePath -> deleteDatabaseHelper(filePath));
                    Files.delete(path);
                }

            } catch (IOException ex) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
