package dao;

import accounts.User;
import java.io.IOException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author aswecker
 */
public class AccountDaoTest {
    
    private AccountDao dao;
    private final static int TEST1_ACCOUNT_ID = 002;
    private final static String TEST1_FNAME = "Test";
    private final static String TEST1_LNAME = "User";
    private final static String TEST1_USERNAME = "TUser";
    private final static String TEST1_PASSWORD = "ABC";
    
    public AccountDaoTest() {
        
        
    }
    
    @BeforeClass
    public static void setUpClass() throws IOException {
        
    }
    
    @AfterClass
    public static void tearDownClass() throws IOException {
    }
    
    @Before
    public void setUp() throws IOException {
        dao = new AccountDao();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllAccounts method, of class AccountDao.
     */
    @Test
    public void testGetAllAccounts() throws Exception {
        System.out.println("getAllAccounts");
        User u = null;
        AccountDao instance = new AccountDao();
        boolean expResult = false;
        boolean result = instance.getAllAccounts(u);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getAccount method, of class AccountDao.
     */
    @Test
    public void testGetAccount() throws Exception {
        System.out.println("getAccount");
        int accountId = 002;
        AccountDao instance = new AccountDao();
        boolean expResult = false;
        boolean result = instance.getAccount(accountId);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of checklogin method, of class AccountDao.
     */
    @Test
    public void testChecklogin() {
        System.out.println("checklogin");
        String username = "TUser";
        String password = "ABC";
        AccountDao instance = new AccountDao();
        boolean expResult = false;
        boolean result = instance.checklogin(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
