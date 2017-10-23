package accounts;

/**
 * This is the User class that gets user information.
 *
 * @author aswecker
 */
public class User implements Person {

    private String fname = "John";
    private String lname = "Doe";
    private int accountid = 001;
    private String username = "JDoe";
    private String password = "123456";

    public User(int inaccountid, String infname, String inlname, String inusername, String inpassword) {

        this.fname = infname;
        this.lname = inlname;
        this.accountid = inaccountid;
        this.username = inusername;
        this.password = inpassword;

    }

    @Override
    public String Getfname() {

        return this.fname;

    }

    @Override
    public void Setfname(String infname) {

        this.fname = infname;

    }

    @Override
    public String Getlname() {

        return this.lname;
    }

    @Override
    public void Setlname(String inlname) {

        this.lname = inlname;

    }

    @Override
    public int Getaccountid() {

        return this.accountid;

    }

    @Override
    public void Setaccountid(int inaccountid) {

        this.accountid = inaccountid;

    }

    @Override
    public String Getusername() {

        return this.username;
    }

    @Override
    public void Setusername(String inusername) {

        this.username = inusername;

    }

    @Override
    public String Getpassword() {

        return this.password;

    }

    @Override
    public void Setpassword(String inpassword) {

        this.password = inpassword;

    }

}
