package accounts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aswecker
 */
public class accountModel implements Initializable {

    private static final int ID = 1;
    private static final int First_Name = 1;
    private static final int Last_Name = 1;
    private static final int Username = 1;
    private static final int Password = 1;
    
    private static final String COMMA_DELIMITER = ",";
    private static final String NEW_LINE = "\n";
    private static final String FILE_HEADER = "Id,First_Name,Last_Name,Username,Password";
    
  

   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addUser();
        readUser();
    }

    // Add a user
    public void addUser() {
        User u = new User(1, "Test", "User", "TestUser", "password");
        User u1 = new User(2, "John", "Doe", "JohnDoe", "password");
        List<User> Users = new ArrayList<User>();

        Users.add(u);
        Users.add(u1);

        File file = new File("data/Accounts.csv");
        FileWriter writer = null;

        try {
            writer = new FileWriter(file);
            writer.append(FILE_HEADER);
            writer.append(COMMA_DELIMITER);
            writer.append(NEW_LINE);

            for (User usr : Users) {
                writer.append(String.valueOf(usr.Getuserid()));
                writer.append(COMMA_DELIMITER);
                writer.append(usr.Getfname());
                writer.append(COMMA_DELIMITER);
                writer.append(usr.Getlname());
                writer.append(COMMA_DELIMITER);
                writer.append(usr.Getusername());
                writer.append(COMMA_DELIMITER);
                writer.append(usr.Getpassword());
                writer.append(NEW_LINE);
            }
        } catch (Exception e) {
            System.out.println("Error writing CSV file");
            e.printStackTrace();
        } finally {
            try {
                writer.flush();
                writer.close();
            } catch (IOException e) {
                System.out.println("Error closing the fileWriter");
                e.printStackTrace();
            }
        }
    }

    /**
     * Read the file.
     */
    public void readUser() {
        BufferedReader reader = null;
        try {
            List<User> users = new ArrayList<User>();
            String ln = "";

            reader = new BufferedReader(new FileReader("data/Accounts.csv"));
            reader.readLine();

            while ((ln = reader.readLine()) != null) {
                String[] obj = ln.split(COMMA_DELIMITER);
                if (obj.length > 0) {
                    User usr = new User(Integer.parseInt(obj[ID]), obj[First_Name], obj[Last_Name], obj[Username], obj[Password]);
                   users.add(usr);
                }
                

            }
            
            

        } catch (Exception e) {
            System.out.println("Error in reading CSV file");
            e.printStackTrace();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error closing fileReader");
                e.printStackTrace();
            }
        }
    }
}

