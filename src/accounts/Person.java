package accounts;

/**
 *
 * @author aswecker
 */
public interface Person {

    public String getFName();

    public void setFName(String infname);

    public String getLName();

    public void setLName(String inlname);

    public int getAccountId();

    public void setAccountId(int inaccountid);

    public String getUsername();

    public void setUsername(String inlogin);

    public String getPassword();

    public void setPassword(String inpassword);

}
