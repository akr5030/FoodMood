package dao;

import accounts.Person;
import accounts.User;
import static dao.ConnectionManager.ACCOUNT_DATA_DIR;
import static dao.ConnectionManager.DATA_DIR;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
//import sun.util.logging.PlatformLogger;

/**
 * Provides methods to read and write accounts to the database.
 *
 * @author jsm158
 *
 */
public class AccountDao {

    private final ConnectionManager cm;
    private final static int ACCOUNTID = 1;
    private final static int RECORDID = 2;
    private final static int FNAME = 3;
    private final static int LNAME = 4;
    private final static int USERNAME = 5;
    private final static int PASSWORD = 6;
    private final static String FILENAME_PATTERN = "%s_accounts.txt";
    private String username;
    private String password;
    Person p;
    StringBuilder sb = new StringBuilder();

    Scanner scan = new Scanner(AccountDao.class.getResourceAsStream(FILENAME_PATTERN)).useDelimiter(",");
    String user = scan.nextLine();
    String pass = scan.nextLine();

    /**
     * Constructs a new AccountDao
     */
    public AccountDao() {
        cm = new ConnectionManager();
    }

    protected String writeRecord(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append(user.getFName());
        sb.append(",");
        sb.append(user.getLName());
        sb.append(",");
        sb.append(user.getUsername());
        sb.append(",");
        sb.append(user.getPassword());
        return sb.toString();
    }

    /**
     * Returns a list of all accounts
     *
     * The list will be empty if no accounts were found.
     *
     * @return list of accounts
     * @throws dao.DaoException if there is an error connecting to the database
     * or executing the query
     */
    public ArrayList<Object> getAllAccounts() throws DaoException {

        Path data = Paths.get(DATA_DIR);
        if (!Files.exists(data)) {
            try {
                Files.createDirectory(data);
                Files.createDirectory(Paths.get(DATA_DIR, ACCOUNT_DATA_DIR));
            } catch (IOException ex) {
                throw new DaoException("Could not create data directory", ex);
            }
        }

        return null;
    }

    /**
     * Returns the account associated with the specified account ID.
     *
     * If there is no matching account null is returned.
     *
     * @param accountId the account ID to look up
     * @return the account or null if no account was found
     * @throws dao.DaoException if there is an error connecting to the database
     * or executing the query
     */
    public Object getAccount(int accountId) throws DaoException {
        Path data = Paths.get(ConnectionManager.DATA_DIR, ConnectionManager.ACCOUNT_DATA_DIR, String.format(FILENAME_PATTERN, accountId));

        boolean check = false;

        if (p.getUsername().equalsIgnoreCase(username)
                && p.getPassword().equalsIgnoreCase(password)) {
            check = true;
        }

        return null;
    }

    /**
     * Saves the specified account by creating a new record or overwriting the
     * existing account
     *
     * @param recordID
     * @param accountId
     * @param fName
     * @param lName
     * @param username
     * @param password
     * @param account the account to save
     * @throws dao.DaoException if there is an error connecting to the database
     * or executing the query
     */
    public void saveAccount(int recordID, int accountId, String fName, String lName, String username, String password) throws DaoException, IOException {
        //This should accept username and password and assign it.
        BufferedWriter bw = null;

        Path data = Paths.get(ConnectionManager.DATA_DIR, ConnectionManager.ACCOUNT_DATA_DIR, String.format(FILENAME_PATTERN, accountId));

        String recordId = UUID.randomUUID().toString();

        User user = new User(recordID, accountId, fName, lName, username, password);

        try {
            if (!Files.exists(data)) {
                Files.createFile(data);
            }
            bw = Files.newBufferedWriter(data, StandardOpenOption.APPEND);
            bw.write(writeRecord(user));
            bw.write("\n");
            bw.flush();
        } catch (IOException ex) {
            Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (bw != null) {
                try {
                    bw.close();
                } catch (IOException ex) {
                    Logger.getLogger(AccountDao.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    /**
     * Permanently deletes the specified account
     *
     * @param account the account to delete
     * @throws DaoException if there is an error connecting to the database or
     * executing the query
     */
    public boolean deleteAccount(Object account) throws DaoException {
        if (User.class.isAssignableFrom(account.getClass())) {
            User u = (User) account;

            return (this.user.equals(u.recordid()));
        } else {
            return false;
        }
    }

    /**
     * Permanently deletes the specified account
     *
     * @param accountId the ID of the account to delete
     * @throws dao.DaoException if there is an error connecting to the database
     * or executing the query
     */
    public void deleteAccount(int accountId) throws DaoException {
    }

    /**
     * Checks the user authentication
     *
     * @param usertext
     * @param passtext
     * @return
     */
    public boolean checklogin(String usertext, String passtext) {

        boolean check = false;

        if (p.getUsername().equalsIgnoreCase(username)
                && p.getPassword().equalsIgnoreCase(password)) {
            check = true;
        }

        return check;

    }
}
