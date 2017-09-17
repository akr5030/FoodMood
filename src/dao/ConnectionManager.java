package dao;

import java.sql.Connection;

/**
 * Provides a connection to the application database.
 *
 * @author jsm158
 *
 */
public class ConnectionManager {

    private static final String HOST = "";
    private static final String USERNAME = "";
    private static final String PASSWORD = "";

    /**
     * Constructs a new ConnectionManager
     */
    public ConnectionManager() {
    }

    /**
     * Returns a connection to the application database
     *
     * @return a database connection
     * @throws dao.DaoException if there is an error connecting to the database
     */
    public Connection getConnection() throws DaoException {
        return null;
    }

}
