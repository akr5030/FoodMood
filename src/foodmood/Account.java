package foodmood;

/**
 * Account class
 *
 * The account class shows the way a users information will be stored. There
 * are columns for username, first name, last name, and password
 *
 * @author walte
 */
public class Account {
    private String userName;
    private String firstName;
    private String lastName;
    private String password;
    
    /**
     * This is the default constructor for the Account class.
     * @param userName1 the username
     * @param firstName1 the first name of the user
     * @param lastName1 the last name of the user
     * @param password1 the password of the user
     */
    
    private Account(String userName1,String firstName1, String lastName1, String password1)
    {
        this.userName = userName1;
        this.firstName = firstName1;
        this.lastName = lastName1;
        this.password = password1;
    }
    
    
}
