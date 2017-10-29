package dao;

import accounts.Person;
import accounts.User;
import foodmood.Account;
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

/**
 * Provides methods to read and write accounts to the database.
 *
 * @author jsm158
 *
 */
public class AccountDao {

    User u;
    ArrayList<Person> personlist = new ArrayList<Person>();

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

        if (this.personlist.isEmpty() == true || this.personlist.size() == 1) {

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
        if (u.Getaccountid() == 001) {
            check = true;

        }

        return check;
    }

    public boolean checklogin(String username, String password) {

        boolean check = false;
        

        if ("JDoe".equals(username)
                && "123456".equals(password)) {
            check = true;
        }

        return check;

    }
}
