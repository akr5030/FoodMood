package accounts;

/**
 * This is the User class that gets user information.
 * @author aswecker
 */
public class User implements Person{

    private final static int recordid = 0;
    private String fname = "";
    private String lname = "";
    public static final int userid = 0;
    private String username = " ";
    private String password = "";
    
    

    public User(int inrecordid, int inuserid, String infname, String inlname, String inusername, String inpassword) {

        
        this.fname = infname;
        this.lname = inlname;
        this.username = inusername;
        this.password = inpassword;

    }

    
    public int recordid() {

        return this.recordid;

    }
    
    public int userid() {

        return this.userid;

    }
    
    @Override
    public String getFName() {

        return this.fname;

    }

    @Override
    public void setFName(String infname) {

        this.fname = infname;

    }

    @Override
    public String getLName() {

        return this.lname;
    }

    @Override
    public void setLName(String inlname) {

        this.lname = inlname;

    }

    

    @Override
    public String getUsername() {

        return this.username;
    }
    @Override
    public void setUsername(String inusername){
        
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

