package dao;

import java.util.ArrayList;

/**
 * Provides access for reading and writing Food objects to the application
 * database.
 *
 * @author jsm158
 *
 */
public class FoodDao {

    private final ConnectionManager cm;
    
    /**
     * Constructs a new FoodDao
     */
    public FoodDao() {
        cm = new ConnectionManager();
    }

    /**
     * Searches the application database for a food matching the specified term
     *
     * This method does not search any external databases.
     *
     * @param searchTerm a term to search for in the food name
     * @return a list of matching foods, or null if no match was found
     * @throws dao.DaoException if there is an error connecting to the database
     * or executing the query
     */
    public ArrayList<Object> searchByName(String searchTerm) throws DaoException {
        return null;
    }

    /**
     * Searches the application database for a food matching the specified term
     *
     * This method searches external database if includeExternal is true. If
     * external databases are not available or includeExternal is false then
     * only results from the application database will be returned. An exception
     * is not thrown in this case.
     *
     * @param searchTerm a term to search for in the food name
     * @param includeExternal search external databases if true, only the
     * application database if false
     * @return a list of matching foods, or null if no match was found
     * @throws dao.DaoException if there is an error connecting to the database
     * or executing the query
     */
    public ArrayList<Object> searchByName(String searchTerm, boolean includeExternal) throws DaoException {
        return null;
    }

    /**
     * Returns the food item with the specified ID
     *
     * If there is not food with the specified ID null is returned.
     *
     * @param foodId the food ID
     * @return the corresponding food or null if no match
     * @throws DaoException if there is an error connecting to the database or
     * executing the query
     */
    public Object getFood(int foodId) throws DaoException {
        return null;
    }

    /**
     * Saves the specified food to the application database.
     *
     * If there is an existing food object with the same ID it will be
     * overwritten with the new information.
     *
     * @param food the food item to save
     * @throws dao.DaoException if there is an error connecting to the database
     * or executing the query
     */
    public void saveFood(Object food) throws DaoException {

    }

}
