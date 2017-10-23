package app;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author matt cano
 */
public class Environment {

    private String env = null;

    public Environment() {
        try (InputStream in = new FileInputStream("foodmood.properties")) {
            Properties prop = new Properties();
            prop.load(in);
            env = prop.getProperty("Environment");
        } catch (Exception e) {
            System.out.println("Error getting environemnt");
        }
    }

    public String getEnvironment(){
        return env;
    }
}
