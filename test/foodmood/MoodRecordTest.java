package foodmood;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for MoodRecord model class
 *
 * @author jsm158
 */
public class MoodRecordTest {

    private MoodRecord record;
    private final static String ID = "record1";
    private final static String ACCOUNT = "account1";
    private final static String MOODID = "mood1";
    private final static String MOODNAME = "moodname1";
    private final static double VALUE = 1.0;

    public MoodRecordTest() {
    }

    @Before
    public void setUp() {
        record = new MoodRecord(ID, ACCOUNT, LocalDate.now(), MOODID, MOODNAME, VALUE);
    }

    @Test
    public void testGetId() {
        assertEquals(ID, record.getId());
    }

    @Test
    public void testGetAccountId() {
        assertEquals(ACCOUNT, record.getAccountId());
    }

    @Test
    public void testGetDate() {
        assertEquals(LocalDate.now(), record.getDate());
    }

    @Test
    public void testGetName() {
        assertEquals(MOODNAME, record.getName());
    }

    @Test
    public void testGetValue() {
        assertEquals(VALUE, record.getValue(), 0);
    }

    @Test
    public void testGetMoodId() {
        assertEquals(MOODID, record.getMoodId());
    }

    @Test
    public void testEquals() {
        MoodRecord record2 = new MoodRecord(ID, "test", LocalDate.now(), "test", "test", 1.0);
        assertEquals(record, record2);
    }

    @Test
    public void testNotEquals() {
        MoodRecord record2 = new MoodRecord("test", "test", LocalDate.now(), "test", "test", 1.0);
        assertNotEquals(record, record2);
    }

    @Test
    public void testNotEqualsObject() {
        assertNotEquals(record, new Object());
    }

}
