package foodmood;




/**
 * Food class
 *
 * The food class shows the way a user will log a food. It gives options for the
 * user to type a food name, a serving size (in grams), and the food group.
 *
 * @author aswecker
 */
public class Food {

    private String foodName;
    private int servingSize;
    private int id;
    private String foodGroup;

    /**
     * This is the default constructor for the Food class.
     *
     * @param id the food id
     * @param foodName name of the food a user is logging
     * @param servingSize the serving size of the food
     * @param foodGroup the type of food group the user is logging
     */
    public Food(int id, String foodName, int servingSize, String foodGroup) {
        this.id = id;
        this.foodName = foodName;
        this.servingSize = servingSize;
        this.foodGroup = foodGroup;
    }

    /**
     * Returns the id
     *
     * @return An integer for the id
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns the foodName
     *
     * @return A string for the food name
     */
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * Returns the servingSize
     *
     * @return An integer for the serving size Serving size would be measured in
     * grams (g)
     */
    public int getServingSize() {
        return servingSize;
    }

    public void setServingSize(int servingSize) {
        this.servingSize = servingSize;
    }

    /**
     * Returns the foods group
     *
     * @return A string for the food group
     */
    public String getFoodGroup() {
        return foodGroup;
    }

    public void setFoodGroup(String foodGroup) {
        this.foodGroup = foodGroup;
    }
    
}
