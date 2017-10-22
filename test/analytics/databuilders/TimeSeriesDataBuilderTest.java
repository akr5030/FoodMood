package analytics.databuilders;

import foodmood.Quantifiable;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jsm158
 */
public class TimeSeriesDataBuilderTest {

    private ArrayList<Quantifiable> list;
    private MockQuantifiable mq1;
    private MockQuantifiable mq2;
    private MockQuantifiable mq3;
    private MockQuantifiable mq4;

    private XYChart.Data<String, Number> mq1Data;
    private XYChart.Data<String, Number> mq2Data;
    private XYChart.Data<String, Number> mq3Data;
    private XYChart.Data<String, Number> mq4Data;

    public TimeSeriesDataBuilderTest() {
    }

    @Before
    public void setUp() {
        list = new ArrayList<>();
        mq1 = new MockQuantifiable(LocalDate.of(2017, Month.OCTOBER, 1), 1.0, "category1");
        mq2 = new MockQuantifiable(LocalDate.of(2017, Month.OCTOBER, 1), 3.0, "category1");
        mq3 = new MockQuantifiable(LocalDate.of(2017, Month.OCTOBER, 2), 2.0, "category1");
        mq4 = new MockQuantifiable(LocalDate.of(2016, 1, 1), 3.0, "category2");

        list.add(mq1);
        list.add(mq2);
        list.add(mq3);
        list.add(mq4);
    }

    @Test
    public void testBuildSeriesDefaults() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
        HashMap<String, XYChart.Series<String, Number>> result;
        TimeSeriesDataBuilder tsdb = new TimeSeriesDataBuilder();
        tsdb.addData(list);
        result = tsdb.buildSeries();

        assertEquals(2, result.size());
        assertEquals(2, result.get("category1").getData().size());
        assertEquals(1, result.get("category2").getData().size());

        // mq4
        assertEquals(mq4.getDate().format(dtf),
                result.get("category2").getData().get(0).getXValue());
        assertEquals(3.0,
                result.get("category2").getData().get(0).getYValue());

        boolean found1 = false;
        boolean found2 = false;

        for (XYChart.Data<String, Number> point : result.get("category1").getData()) {
            // mq1 and mq2
            if (point.getXValue().equals(mq1.getDate().format(dtf))
                    && point.getYValue().equals(4.0)) {
                found1 = true;
            }
            // mq3
            if (point.getXValue().equals(mq3.getDate().format(dtf))
                    && point.getYValue().equals(2.0)) {
                found2 = true;
            }
        }

        assertTrue(found1);
        assertTrue(found2);
    }

    @Test
    public void testBuildSeriesDefaultsChain() {
        DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE;
        HashMap<String, XYChart.Series<String, Number>> result;
        result = new TimeSeriesDataBuilder()
                .addData(list)
                .buildSeries();

        assertEquals(2, result.size());
        assertEquals(2, result.get("category1").getData().size());
        assertEquals(1, result.get("category2").getData().size());

        // mq4
        assertEquals(mq4.getDate().format(dtf),
                result.get("category2").getData().get(0).getXValue());
        assertEquals(3.0,
                result.get("category2").getData().get(0).getYValue());

        boolean found1 = false;
        boolean found2 = false;

        for (XYChart.Data<String, Number> point : result.get("category1").getData()) {
            // mq1 and mq2
            if (point.getXValue().equals(mq1.getDate().format(dtf))
                    && point.getYValue().equals(4.0)) {
                found1 = true;
            }
            // mq3
            if (point.getXValue().equals(mq3.getDate().format(dtf))
                    && point.getYValue().equals(2.0)) {
                found2 = true;
            }
        }

        assertTrue(found1);
        assertTrue(found2);
    }

    @Test
    public void testBuildSeriesNonDefaults() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d");
        HashMap<String, XYChart.Series<String, Number>> result;
        TimeSeriesDataBuilder tsdb = new TimeSeriesDataBuilder(TimeSeriesDataBuilder.AggregationMethod.AVERAGE, TimeSeriesDataBuilder.AggregationPeriod.MONTH, dtf);
        tsdb.addData(list);
        result = tsdb.buildSeries();

        assertEquals(2, result.size());
        assertEquals(1, result.get("category1").getData().size());
        assertEquals(1, result.get("category2").getData().size());

        // mq4
        assertEquals(mq4.getDate().format(dtf),
                result.get("category2").getData().get(0).getXValue());
        assertEquals(3.0,
                result.get("category2").getData().get(0).getYValue());

        boolean found1 = false;

        for (XYChart.Data<String, Number> point : result.get("category1").getData()) {
            if (point.getXValue().equals(mq1.getDate().format(dtf))
                    && point.getYValue().equals(2.0)) {
                found1 = true;
            }
        }

        assertTrue(found1);
    }

    @Test
    public void testBuildSeriesNonDefaultsChain() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("M/d");
        HashMap<String, XYChart.Series<String, Number>> result;
        result = new TimeSeriesDataBuilder()
                .setAggregationMethod(TimeSeriesDataBuilder.AggregationMethod.AVERAGE)
                .setAggregationPeriod(TimeSeriesDataBuilder.AggregationPeriod.MONTH)
                .setDateFormat(dtf)
                .addData(list)
                .buildSeries();

        assertEquals(2, result.size());
        assertEquals(1, result.get("category1").getData().size());
        assertEquals(1, result.get("category2").getData().size());

        // mq4
        assertEquals(mq4.getDate().format(dtf),
                result.get("category2").getData().get(0).getXValue());
        assertEquals(3.0,
                result.get("category2").getData().get(0).getYValue());

        boolean found1 = false;

        for (XYChart.Data<String, Number> point : result.get("category1").getData()) {
            if (point.getXValue().equals(mq1.getDate().format(dtf))
                    && point.getYValue().equals(2.0)) {
                found1 = true;
            }
        }

        assertTrue(found1);
    }

    @Test
    public void testSetDateFormat() {
        TimeSeriesDataBuilder tsdb = new TimeSeriesDataBuilder();
        tsdb.setDateFormat(DateTimeFormatter.ISO_DATE);
        assertEquals(DateTimeFormatter.ISO_DATE, tsdb.getDateFormat());
    }

    @Test
    public void testSetAggregationMethod() {
        TimeSeriesDataBuilder tsdb = new TimeSeriesDataBuilder();
        tsdb.setAggregationMethod(TimeSeriesDataBuilder.AggregationMethod.AVERAGE);
        assertEquals(TimeSeriesDataBuilder.AggregationMethod.AVERAGE, tsdb.getAggregationMethod());
    }

    @Test
    public void testSetAggregationPeriod() {
        TimeSeriesDataBuilder tsdb = new TimeSeriesDataBuilder();
        tsdb.setAggregationPeriod(TimeSeriesDataBuilder.AggregationPeriod.MONTH);
        assertEquals(TimeSeriesDataBuilder.AggregationPeriod.MONTH, tsdb.getAggregationPeriod());
    }

    private class MockQuantifiable implements Quantifiable {

        private final LocalDate date;
        private final double value;
        private final String name;

        public MockQuantifiable(LocalDate date, double value, String name) {
            this.date = date;
            this.value = value;
            this.name = name;
        }

        @Override
        public LocalDate getDate() {
            return date;
        }

        @Override
        public double getValue() {
            return value;
        }

        @Override
        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (MockQuantifiable.class.isAssignableFrom(o.getClass())) {
                MockQuantifiable mq = (MockQuantifiable) o;

                return (this.date.equals(mq.date) && this.value == mq.value && this.name.equals(mq.name));
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 17 * hash + Objects.hashCode(this.date);
            hash = 17 * hash + Objects.hashCode(this.name);
            return hash;
        }

    }
}
