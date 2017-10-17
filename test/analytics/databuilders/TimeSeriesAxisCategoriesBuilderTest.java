package analytics.databuilders;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jsm158
 * @since M03-A04
 */
public class TimeSeriesAxisCategoriesBuilderTest {

    TimeSeriesAxisCategoriesBuilder tsbDefault;
    TimeSeriesAxisCategoriesBuilder tsbParams;

    private final static LocalDate EXPECTED_START_DATE = LocalDate.of(2017, Month.JANUARY, 2);
    private final static LocalDate EXPECTED_END_DATE = LocalDate.of(2017, Month.JANUARY, 7);
    private final static DateTimeFormatter EXPECTED_DATE_FORMAT = DateTimeFormatter.ofPattern("MMM d, u");

    public TimeSeriesAxisCategoriesBuilderTest() {
    }

    @Before
    public void setUp() {

        tsbDefault = new TimeSeriesAxisCategoriesBuilder();
        tsbParams = new TimeSeriesAxisCategoriesBuilder(EXPECTED_START_DATE,
                EXPECTED_END_DATE, EXPECTED_DATE_FORMAT);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testGetStartDateDefault() {
        assertEquals(LocalDate.now().minusDays(7), tsbDefault.getStartDate());
    }

    @Test
    public void testGetStartDateParams() {
        assertEquals(EXPECTED_START_DATE, tsbParams.getStartDate());
    }

    @Test
    public void testSetStartDate() {
        tsbParams.setStartDate(LocalDate.of(2016, Month.MARCH, 3));
        assertEquals(LocalDate.of(2016, Month.MARCH, 3), tsbDefault.getStartDate());
    }

    @Test
    public void testGetEndDateDefault() {
        assertEquals(LocalDate.now(), tsbDefault.getEndDate());
    }

    @Test
    public void testGetEndDateParams() {
        assertEquals(EXPECTED_END_DATE, tsbParams.getEndDate());
    }

    @Test
    public void testSetEndDate() {
        tsbParams.setEndDate(LocalDate.of(2017, Month.DECEMBER, 5));
        assertEquals(LocalDate.of(2017, Month.DECEMBER, 5), tsbParams.getEndDate());
    }

    @Test
    public void testGetDateFormatDefault() {
        assertEquals(DateTimeFormatter.ISO_DATE, tsbDefault.getDateFormat());
    }

    @Test
    public void testGetDateFormatParams() {
        assertEquals(EXPECTED_DATE_FORMAT, tsbParams.getDateFormat());
    }

    @Test
    public void testSetDateFormat() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MMM u");
        System.out.println(dtf);
        tsbParams.setDateFormat(dtf);
        assertEquals(dtf, tsbParams.getDateFormat());
    }

    @Test
    public void testBuildChain() throws DataBuilderException {
        String dateString = "Jan %d, 2017";
        ObservableList<String> series = tsbParams.buildCategories();
        assertEquals(6, series.size());
        series.forEach(c -> System.out.println(c));
        assertEquals(String.format(dateString, 2), series.get(0));
        assertEquals(String.format(dateString, 3), series.get(1));
        assertEquals(String.format(dateString, 4), series.get(2));
        assertEquals(String.format(dateString, 5), series.get(3));
        assertEquals(String.format(dateString, 6), series.get(4));
        assertEquals(String.format(dateString, 7), series.get(5));
    }

    /**
     * Tests that a DataBuilderException is thrown if the start date occurs
     * after the end date
     *
     * @throws DataBuilderException the exception
     */
    @Test(expected = DataBuilderException.class)
    public void testBuildChainBadDate() throws DataBuilderException {
        ObservableList<String> result = new TimeSeriesAxisCategoriesBuilder()
                .setEndDate(LocalDate.now())
                .setStartDate(LocalDate.MAX)
                .buildCategories();
    }

}
