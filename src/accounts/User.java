package accounts;

/**
 *
 * @author aswecker
 */
public class User implements Person{

    private String fname = "";
    private String lname = "";
    private int userid = 0;
    private String username = " ";
    private String password = "";
    
    

    public User(int inuserid, String infname, String inlname, String inusername, String inpassword) {

        this.userid = inuserid;
        this.fname = infname;
        this.lname = inlname;
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
    public int Getuserid() {

        return this.userid;

    }

    @Override
    public void Setuserid(int inuserid) {

        this.userid = inuserid;

    }

    @Override
    public String Getusername() {

        return this.username;
    }
    @Override
    public void Setusername(String inusername){
        
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

