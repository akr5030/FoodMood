package dao;

import java.util.ArrayList;

/**
 * Provides methods to read and write accounts to the database.
 *
 * @author jsm158
 *
 */
public class AccountDao {

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
    public ArrayList<Object> getAllAccounts() throws DaoException {
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
        return null;
    }

    /**
     * Saves the specified account by creating a new record or overwriting the
     * existing account
     *
     * @param account the account to save
     * @throws dao.DaoException if there is an error connecting to the database
     * or executing the query
     */
    public void saveAccount(Object account) throws DaoException {

    }

    /**
     * Permanently deletes the specified account
     *
     * @param account the account to delete
     * @throws DaoException if there is an error connecting to the database or
     * executing the query
     */
    public void deleteAccount(Object account) throws DaoException {

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

}
