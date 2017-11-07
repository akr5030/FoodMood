package dao;

import accounts.Person;
import accounts.User;
import java.util.ArrayList;

/**
 * Provides methods to read and write accounts to the database.
 *
 * @author jsm158
 *
 */
public class AccountDao {

    User u;
    ArrayList<Person> personList; 

    /**
     * Constructs a new AccountDao
     */
    public AccountDao() {

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
    public boolean getAllAccounts(User u) throws DaoException {

        boolean check = false;

        if (this.personList.isEmpty() == true || this.personList.size() == 1) {

            check = true;

        }

        return check;

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
    public boolean getAccount(int accountId) throws DaoException {

        boolean check = false;
        if (u.getAccountId()== 001) {
            check = true;

        }

        return check;
    }
    
    /**
     * Checks the username and password so a user can login.
     * @param username the username a user enters
     * @param password the password a user enters
     * @return allows the user to login
     */

    public boolean checklogin(String username, String password) {

        boolean check = false;
        

        if ("JDoe".equals(username)
                && "123456".equals(password)) {
            check = true;
        }

        return check;

    }
}
