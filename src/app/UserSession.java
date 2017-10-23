package app;

/**
 *
 * @author matt cano
 */
public class UserSession {
    
    private static User currentUser = null;
    
    private UserSession() {
    }
    
    public static UserSession getInstance() {
        return UserSessionHolder.INSTANCE;
    }
    
    private static class UserSessionHolder {

        private static final UserSession INSTANCE = new UserSession();
    }

    /**
    * Sets the account currently logged in
    *
    * @param currentUser
    */
   public void loginAccount(User currentUser) {
      UserSession.currentUser = currentUser;
      System.out.println("Logged in account %s%n", currentUser.getUsername());
   }
    
}
