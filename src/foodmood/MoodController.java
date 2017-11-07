package foodmood;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author mcano
 */
public class MoodController implements Initializable {

    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE = "\n";
    private static final String FILE_HEADER = "Id,MoodName";

    private static final int MOOD_ID_INDEX = 0;
    private static final int MOOD_NAME_INDEX = 1;

    /**
     * Initializes the controller class.
     *
     * @param url the url (path) to the associated FXML document
     * @param rb the application's resource bundle
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        addMood();
//        TestHarness.getInstance().testMoodControllerAdd();
//        readMood();
//        TestHarness.getInstance().changeScene("/analytics/MoodLogView.fxml");
    }

    /**
     * Add a mood to the 'database'.
     */
    // 
    public void addMood() {
//        Mood m = new Mood(1, "Happy");
//        Mood m1 = new Mood(1, "Sad");
//        List<Mood> moods = new ArrayList<Mood>();
//
//        moods.add(m);
//        moods.add(m1);
//
//        File file = new File("data/Moods.csv");
//        FileWriter writer = null;
//
//        try {
//            writer = new FileWriter(file);
//            writer.append(FILE_HEADER);
//            writer.append(COMMA_DELIMITER);
//            writer.append(NEW_LINE);
//
//            for (Mood md : moods) {
//                writer.append(String.valueOf(md.getId()));
//                writer.append(COMMA_DELIMITER);
//                writer.append(md.getMoodName());
//                writer.append(NEW_LINE);
//            }
//        } catch (Exception e) {
//            System.out.println("Error writing CSV file");
//            e.printStackTrace();
//        } finally {
//            try {
//                writer.flush();
//                writer.close();
//            } catch (IOException e) {
//                System.out.println("Error closing the fileWriter");
//                e.printStackTrace();
//            }
//        }
    }

    /**
     * Read the file from the 'database'.
     */
    public void readMood() {
//        BufferedReader reader = null;
//        try {
//            List<Mood> moods = new ArrayList<Mood>();
//            String ln = "";
//
//            reader = new BufferedReader(new FileReader("data/Moods.csv"));
//            reader.readLine();
//
//            while ((ln = reader.readLine()) != null) {
//                String[] obj = ln.split(COMMA_DELIMITER);
//                if (obj.length > 0) {
//                    Mood md = new Mood(Integer.parseInt(obj[MOOD_ID_INDEX]), obj[MOOD_NAME_INDEX]);
//                    moods.add(md);
//                }
//
//                //Print Moods
//                for (Mood md : moods) {
//                    System.out.println(md.toString());
//                }
//
//            }
//            
//            TestHarness.getInstance().testMoodControllerRead(moods);
//
//        } catch (Exception e) {
//            System.out.println("Error in reading CSV file");
//            e.printStackTrace();
//        } finally {
//            try {
//                reader.close();
//            } catch (IOException e) {
//                System.out.println("Error closing fileReader");
//                e.printStackTrace();
//            }
//        }
    }
}
