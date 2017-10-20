package dao;

import foodmood.MoodRecord;
import java.time.LocalDate;
import java.time.Month;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author redjen
 */
public class MoodRecordDaoTest {

    private MoodRecordDao dao;
    private final static String TEST1_RECORD_ID = "test1";
    private final static String TEST1_ACCOUNT_ID = "account1";
    private final static String TEST1_DATE = LocalDate.of(2017, Month.APRIL, 1).toString();
    private final static String TEST1_MOOD_ID = "mood1";
    private final static String TEST1_MOOD_NAME = "name 1";
    private final static double TEST1_VALUE = 3.5;
    

    public MoodRecordDaoTest() {
    }

    @Before
    public void setUp() {
        dao = new MoodRecordDao();
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetMoodRecords_3args() throws Exception {
    }

    @Test
    public void testGetMoodRecords_Date_Date() {
    }

    @Test
    public void testSaveMoodRecord() {
    }

    @Test
    public void testSaveMoodRecords() {
    }

    @Test
    public void testParseRecord() throws DaoException {
        String testRecord = String.format("%s,%s,%s,%s,%f", 
                TEST1_RECORD_ID,
                TEST1_ACCOUNT_ID,
                TEST1_DATE,
                TEST1_MOOD_ID,
                TEST1_VALUE);
        
        MoodRecord record = dao.parseRecord(testRecord);
        assertEquals(TEST1_ACCOUNT_ID, record.getAccountId());
        assertEquals(TEST1_DATE, record.getDate().toString());
        assertEquals(TEST1_MOOD_ID, record.getMoodId());
        assertEquals(TEST1_VALUE, record.getValue(), 0);
        
    }

    @Test(expected = DaoException.class)
    public void testParseRecordEmpty() throws DaoException {
        dao.parseRecord("");
    }

    @Test(expected = DaoException.class)
    public void testParseRecordBad() throws DaoException {
        dao.parseRecord("test,test");
    }
}
