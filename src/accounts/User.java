package accounts;

/**
 * This is the User class that gets user information.
 *
 * @author aswecker
 */
public class User implements Person {

    private String fName = "John";
    private String lName = "Doe";
    private int accountId = 001;
    private String username = "JDoe";
    private String password = "123456";

    public User(int inaccountid, String infname, String inlname, String inusername, String inpassword) {

        this.fName = infname;
        this.lName = inlname;
        this.accountId = inaccountid;
        this.username = inusername;
        this.password = inpassword;

    }

    @Override
    public String getFName() {

        return this.fName;

    }

    @Override
    public void setFName(String infname) {

        this.fName = infname;

    }

    @Override
    public String getLName() {

        return this.lName;
    }

    @Override
    public void setLName(String inlname) {

        this.lName = inlname;

    }

    @Override
    public int getAccountId() {

        return this.accountId;

    }
    
@Override
    public void setAccountId(int inaccountid) {
      this.accountId = inaccountid;
    }
    

    @Override
    public String getUsername() {

        return this.username;
    }

    @Override
    public void setUsername(String inusername) {

        this.username = inusername;

    }

    @Override
    public String getPassword() {

        return this.password;

    }

    @Override
    public void setPassword(String inpassword) {

        this.password = inpassword;

    }

    

}
