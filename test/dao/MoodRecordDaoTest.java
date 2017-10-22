package dao;

import foodmood.MoodRecord;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.BeforeClass;

/**
 *
 * Tests for MoodRecordDao
 *
 * @author jsm158
 */
public class MoodRecordDaoTest {

    private MoodRecordDao dao;
    private final static String TEST1_RECORD_ID = "testId";
    private final static int TEST1_ACCOUNT_ID = 1;
    private final static String TEST1_DATE = LocalDate.of(2017, Month.APRIL, 1).toString();
    private final static int TEST1_MOOD_ID = 1;
    private final static String TEST1_MOOD_NAME = "name 1";
    private final static double TEST1_VALUE = 3.5;

    private final static Path TEST_DATA_FILE = Paths.get("test", "dao", "MoodRecordDaoTestData.txt");
    private final static Path DATA_DIR = Paths.get("data", "accountData");

    public MoodRecordDaoTest() {
    }

    @Before
    public void setUp() throws IOException {
        dao = new MoodRecordDao();
    }

    @BeforeClass
    public static void setUpClass() throws IOException {
        Files.createDirectories(DATA_DIR);
        Files.copy(TEST_DATA_FILE, DATA_DIR.resolve("1_moods.txt"));
    }

    @AfterClass
    public static void tearDownClass() throws IOException {
        Files.deleteIfExists(DATA_DIR.resolve("1_moods.txt"));
        Files.deleteIfExists(DATA_DIR.resolve("2_moods.txt"));
    }

    @Test
    public void testGetMoodRecordsBetweenDates() throws Exception {

        ArrayList<MoodRecord> records = dao.getMoodRecords(LocalDate.of(2017, Month.MAY, 1),
                LocalDate.of(2017, Month.JUNE, 1), 1);

        assertEquals(2, records.size());
        assertEquals("test2", records.get(0).getId());
        assertEquals("test3", records.get(1).getId());
    }

    @Test
    public void testGetMoodRecordsBetweenDatesNone() throws Exception {
        ArrayList<MoodRecord> records = dao.getMoodRecords(LocalDate.of(2018, Month.MAY, 1),
                LocalDate.of(2020, Month.JUNE, 1), 1);

        assertEquals(0, records.size());
    }

    @Test
    public void testGetAllMoodRecords() throws Exception {
        ArrayList<MoodRecord> records = dao.getMoodRecords(LocalDate.of(2017, Month.JANUARY, 1),
                LocalDate.of(2017, Month.DECEMBER, 31), 1);

        assertEquals(4, records.size());
        assertEquals("test1", records.get(0).getId());
        assertEquals("test2", records.get(1).getId());
        assertEquals("test3", records.get(2).getId());
        assertEquals("test4", records.get(3).getId());
    }

    @Test
    public void testSaveMoodRecord() throws DaoException {
        ArrayList<MoodRecord> records;

        dao.saveMoodRecord(2, LocalDate.now(), TEST1_MOOD_ID, 1.1);
        records = dao.getMoodRecords(LocalDate.of(2017, Month.JANUARY, 1),
                LocalDate.of(2017, Month.DECEMBER, 31), 2);
        assertEquals(1, records.size());

        dao.saveMoodRecord(2, LocalDate.now(), TEST1_MOOD_ID, 1.2);
        records = dao.getMoodRecords(LocalDate.of(2017, Month.JANUARY, 1),
                LocalDate.of(2017, Month.DECEMBER, 31), 2);
        assertEquals(2, records.size());
        assertEquals(1.1, records.get(0).getValue(), 0);
        assertEquals(1.2, records.get(1).getValue(), 0);

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

    @Test
    public void testWriteRecord() {
        MoodRecord record = new MoodRecord(TEST1_RECORD_ID, TEST1_ACCOUNT_ID, LocalDate.parse(TEST1_DATE), TEST1_MOOD_ID, TEST1_MOOD_NAME, TEST1_VALUE);
        String expected = String.format("%s,%s,%s,%s,%.1f",
                TEST1_RECORD_ID, TEST1_ACCOUNT_ID, TEST1_DATE, TEST1_MOOD_ID, TEST1_VALUE);
        assertEquals(expected, dao.writeRecord(record));
    }
}
