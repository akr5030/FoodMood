package foodmood;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.System.out;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import testHarness.TestHarness;

/**
 *
 * @author aswecker
 */
public class FoodController implements Initializable {

    private static final int Food_ID = 1;
    private static final int Food_Name_ID = 1;
    private static final int Serving_Size_ID = 1;
    private static final int Food_Group_ID = 1;

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE_SEPARATOR = "\n";
    private static final String FILE_HEADER = "id,Name,Serving_Size,Food_Group";

    public FoodController() {
    }

    /**
     * Initializes the controller class.
     *
     * @param url the url (path) to the associated FXML document
     * @param rb the application's resource bundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        addFoods();
//        TestHarness.getInstance().testFoodController();
//        TestHarness.getInstance().changeScene("/foodmood/FoodRecordView.fxml");
    }

    /**
     * Gives the user the option to add a food.
     */
    /**
     * Gives the user the option to add a food.
     *
     * @param fileName
     */
    public void addFoods() {

//        Food food1 = new Food(1, "Pizza", 1, "Grain, Veggie, Milk");
//        Food food2 = new Food(2, "Tacos", 1, "Meat");
//
//        List<Food> foods = new ArrayList<Food>();
//        foods.add(food1);
//        foods.add(food2);
//
//        // Added File object because the file didn't seem to get created on Mac. Javadoc says this can happen
//        File file = new File("data/food.csv");
//        FileWriter fileWriter = null;
//
//        try {
//            fileWriter = new FileWriter(file); // added directory to make test cleanup easier
//            fileWriter.append(FILE_HEADER.toString());
//            fileWriter.append(NEW_LINE_SEPARATOR);
//            for (Food fd : foods) {
//                fileWriter.append(String.valueOf(fd.getId()));
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(String.valueOf(fd.getFoodName()));
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(String.valueOf(fd.getServingSize()));
//                fileWriter.append(COMMA_DELIMITER);
//                fileWriter.append(String.valueOf(fd.getFoodGroup()));
//                fileWriter.append("\n");
//            }
//        } catch (IOException ex) {
//            // changed to logger to get more debugging info
//            Logger.getLogger(FoodController.class.getName()).log(Level.SEVERE,
//                    "Error writing food data", ex);
//        } finally {
//            try {
//                if (fileWriter != null) {
//                    fileWriter.flush();
//                    fileWriter.close();
//                }
//            } catch (IOException ex) {
//                out.println("Error");
//            }
//        }

    }

    /**
     * Reads the file.
     */
    public void readFoods() {

//        BufferedReader fileReader = null;
//        try {
//            List<Food> foods = new ArrayList<Food>();
//            String line = "";
//            fileReader = new BufferedReader(new FileReader("food.csv."));
//            fileReader.readLine();
//
//            while ((line = fileReader.readLine()) != null) {
//                String[] obj = line.split(COMMA_DELIMITER);
//                if (obj.length > 0) {
//                    Food fd = new Food(Integer.parseInt(obj[Food_ID]), obj[Food_Name_ID], Integer.parseInt(obj[Serving_Size_ID]), obj[Food_Group_ID]);
//                    foods.add(fd);
//                }
//                for (Food fd : foods) {
//                    out.println(fd.toString());
//                }
//            }
//        } catch (Exception ex) {
//            out.println("Error");
//        } finally {
//            try {
//                fileReader.close();
//            } catch (IOException ex) {
//                out.println("Error");
//            }
//        }
    }
}
