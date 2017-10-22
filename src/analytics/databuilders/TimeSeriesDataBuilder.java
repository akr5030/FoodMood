package analytics.databuilders;

import foodmood.Quantifiable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

/**
 * TimeSeriesDataBuilder takes a list of Quantifiable (FoodRecord or MoodRecord)
 * objects and returns a HashMap of data series that can be plotted on a line
 * chart. The data can be aggregated by day or month as a sum or average. The x
 * value is a formatted date and the y value is the sum/average. If options are
 * not specified data will be aggregated by sum/day and the dates in the x axis
 * will use {@link DateTimeFormatter#ISO_LOCAL_DATE}.
 *
 * <p>
 * This should be used with the {@link TimeSeriesAxisCategoriesBuilder} class.
 * Both should use the same date formatter.</p>
 *
 * <p>
 * TimeSeriesDataBuilder solves the problem of needing to generate a series in
 * multiple controllers without needing to implement similar logic in each.</p>
 *
 * Usage:
 *
 * <pre>
 * &commat;FXML
 * private LineChart lineChart
 *
 * HashMap&gt;String, DataPoint&lt; dataSeriesMap = new TimeSeriesDataBuilder()
 *         .addData(listOfQuantifiableObjects)
 *         .setAgregationMethod(TimeSeriesDataBuilder.AggregationMethod.AVERAGE)
 *         .setAgregationPeriod(TimeSeriesDataBuilder.AggregationPeriod.DAY)
 *         .setDateFormat(DateTimeFormatter.ofPattern("MMM d")
 *         .buildSeries();
 * 
 * dataSeriesMap.forEach((name, series) -> lc.getData().add(series));
 * </pre>
 *
 * @author jsm158
 * @since M03-A04
 *
 */
public class TimeSeriesDataBuilder {

    private AggregationMethod aggregationMethod;
    private AggregationPeriod aggregationPeriod;
    private DateTimeFormatter dateFormat;
    private HashMap<String, DataPoint> dataPoints;

    public enum AggregationPeriod {
        DAY, MONTH
    }

    public enum AggregationMethod {
        AVERAGE, SUM
    }

    public TimeSeriesDataBuilder() {
        this(AggregationMethod.SUM, AggregationPeriod.DAY, DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public TimeSeriesDataBuilder(AggregationMethod aggregationMethod, AggregationPeriod aggregationPeriod, DateTimeFormatter dateFormat) {
        dataPoints = new HashMap<>();
        this.aggregationMethod = aggregationMethod;
        this.aggregationPeriod = aggregationPeriod;
        this.dateFormat = dateFormat;
    }

    public TimeSeriesDataBuilder addData(final Collection<Quantifiable> data) {
        String idFormat = "%s-%s";

        for (Quantifiable q : data) {
            LocalDate dataPointDate;

            switch (aggregationPeriod) {
                case MONTH:
                    dataPointDate = q.getDate().withDayOfMonth(1);
                    break;
                case DAY:
                default:
                    dataPointDate = q.getDate();
            }

            String id = String.format(idFormat, q.getName(), dataPointDate);

            if (!dataPoints.containsKey(id)) {
                dataPoints.put(id, new DataPoint(q.getName(), dataPointDate, q.getValue()));
            } else {
                dataPoints.get(id).add(q.getValue());
            }
        }

        return this;
    }

    public HashMap<String, XYChart.Series<String, Number>> buildSeries() {
        HashMap<String, XYChart.Series<String, Number>> seriesMap = new HashMap<>();

        dataPoints.forEach((key, dataPoint) -> {
            XYChart.Series series;
            XYChart.Data<String, Number> data;

            double measure;
            String category = dataPoint.getName();
            String date = dataPoint.getDate().format(dateFormat);

            if (!seriesMap.containsKey(category)) {
                ObservableList<XYChart.Data<String, Number>> ol = FXCollections.observableArrayList();
                series = new XYChart.Series(ol);
                series.setName(category);
                seriesMap.put(category, series);
            } else {
                series = seriesMap.get(category);
            }

            switch (aggregationMethod) {
                case AVERAGE:
                    measure = dataPoint.getAverage();
                    break;
                case SUM:
                default:
                    measure = dataPoint.getSum();
            }

            data = new XYChart.Data<>(date, measure);
            series.getData().add(data);
        });

        return seriesMap;
    }

    public DateTimeFormatter getDateFormat() {
        return dateFormat;
    }

    public TimeSeriesDataBuilder setDateFormat(DateTimeFormatter dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

    public AggregationMethod getAggregationMethod() {
        return aggregationMethod;
    }

    public TimeSeriesDataBuilder setAggregationMethod(AggregationMethod aggregationMethod) {
        this.aggregationMethod = aggregationMethod;
        return this;
    }

    public AggregationPeriod getAggregationPeriod() {
        return aggregationPeriod;
    }

    public TimeSeriesDataBuilder setAggregationPeriod(AggregationPeriod aggregationPeriod) {
        this.aggregationPeriod = aggregationPeriod;
        return this;
    }

    private class DataPoint {

        private final String name;
        private final LocalDate date;
        private double sum;
        private int count;

        public DataPoint(String name, LocalDate date, double sum) {
            this.name = name;
            this.date = date;
            this.sum = sum;
            this.count = 1;

            System.out.println(String.format("New data point: %s, %s, %f", name, date.toString(), sum));
        }

        public void add(double value) {
            count++;
            sum += value;
            System.out.println(String.format("Updated %s %s: %d %f", name, date, count, sum));
        }

        public String getName() {
            return name;
        }

        public LocalDate getDate() {
            return date;
        }

        public double getSum() {
            return sum;
        }

        public double getAverage() {
            return sum / count;
        }

    }

}
