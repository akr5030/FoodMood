package analytics.databuilders;

import java.time.LocalDate;
import javafx.collections.ObservableList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author redjen
 */
public class TimeSeriesAxisCategoriesBuilderTest {

    public TimeSeriesAxisCategoriesBuilderTest() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testBuildCategories() {
    }

    @Test
    public void testGetStartDate() {
    }

    @Test
    public void testSetStartDate() {
    }

    @Test
    public void testGetEndDate() {
    }

    @Test
    public void testSetEndDate() {
    }

    @Test
    public void testGetDateFormat() {
    }

    @Test
    public void testSetDateFormat() {
    }

    @Test
    public void testBuildChain() {

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
