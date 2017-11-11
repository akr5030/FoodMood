package dao;

import foodmood.Food;
import foodmood.Mood;
import java.util.ArrayList;

/**
 * Provides access for reading and writing Food objects to the application
 * database.
 *
 * @author matt cano
 *
 */
public class FoodDao {

    private final ConnectionManager cm;
    ArrayList<Food> f = new ArrayList<Food>();
    
    /**
     * Constructs a new FoodDao
     */
    public FoodDao() throws DaoException {
        cm = new ConnectionManager();
        f = createFoods();
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
    public ArrayList<Food> searchByName(String searchTerm) throws DaoException {
        ArrayList<Food> fl = new ArrayList<Food>();
        try {
            for (Food fd : f) {
                if (fd.getFoodName().contains(searchTerm)) {
                    fl.add(fd);
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error in reading CSV file");
            //e.printStackTrace();
        }
        return fl;
    }

//    /**
//     * Searches the application database for a food matching the specified term
//     *
//     * This method searches external database if includeExternal is true. If
//     * external databases are not available or includeExternal is false then
//     * only results from the application database will be returned. An exception
//     * is not thrown in this case.
//     *
//     * @param searchTerm a term to search for in the food name
//     * @param includeExternal search external databases if true, only the
//     * application database if false
//     * @return a list of matching foods, or null if no match was found
//     * @throws dao.DaoException if there is an error connecting to the database
//     * or executing the query
//     */
//    public ArrayList<Food> searchByName(String searchTerm, boolean includeExternal) throws DaoException {
//        return null;
//    }

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
    public Food getFood(int foodId) throws DaoException {
        Food rtnValue = null;
        try {
            for (Food fd : f) {
                if (fd.getId() == foodId) {
                    rtnValue = fd;
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Error in reading CSV file");
            //e.printStackTrace();
        }
        return rtnValue;
    }

//    /**
//     * Saves the specified food to the application database.
//     *
//     * If there is an existing food object with the same ID it will be
//     * overwritten with the new information.
//     *
//     * @param food the food item to save
//     * @throws dao.DaoException if there is an error connecting to the database
//     * or executing the query
//     */
//    public void saveFood(Food food) throws DaoException {
//
//    }
//    
    /**
     * Creates the list of Foods to pick from.
     *
     * @throws dao.DaoException if there is an error connecting to the database
     * or executing the query
     */
    public ArrayList<Food> createFoods() throws DaoException {
        Food f = new Food(1, "Milk", 1,"Dairy");
        Food f1 = new Food(2, "Eggs", 2,"Dairy");
        Food f2 = new Food(3, "Steak", 2,"Meat");
        Food f3 = new Food(4, "Bacon", 2,"Meat");
        Food f4 = new Food(5, "Soup", 1,"Vegetable");
        Food f5 = new Food(6, "Chicken", 1,"Meat");
        Food f6 = new Food(7, "Soda", 1,"Junk");
        Food f7 = new Food(8, "Chips", 2,"Junk");
        Food f8 = new Food(9, "Tomato", 1,"Vegetable");
        Food f9 = new Food(9, "Lettuce", 1,"Vegetable");
        Food f10 = new Food(9, "Corn", 1,"Vegetable");
        Food f11= new Food(9, "Pork", 1,"Meat");
        Food f12= new Food(9, "Cheese", 1,"Dairy");
        Food f13= new Food(9, "Cereal", 1,"Bread");
        Food f14= new Food(9, "Bread", 1,"Bread");
        Food f15= new Food(9, "Roll", 1,"Bread");

        ArrayList<Food> foods = new ArrayList<Food>();

        try {
            foods.add(f);
            foods.add(f1);
            foods.add(f2);
            foods.add(f3);
            foods.add(f4);
            foods.add(f5);
            foods.add(f6);
            foods.add(f7);
            foods.add(f8);
            foods.add(f9);
            foods.add(f10);
            foods.add(f11);
            foods.add(f12);
            foods.add(f13);
            foods.add(f14);
            foods.add(f15);

        } catch (Exception ex) {
            System.out.println("Error creating moods....");
//            e.printStackTrace();
        }

        return foods;
    }

}
