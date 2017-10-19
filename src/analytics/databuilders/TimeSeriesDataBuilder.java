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
 * The TimeSeriesDataBuilder class represents
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
        this(AggregationMethod.SUM, AggregationPeriod.DAY, DateTimeFormatter.ISO_DATE.toString());
    }

    public TimeSeriesDataBuilder(AggregationMethod aggregationMethod, AggregationPeriod aggregationPeriod, String dateFormat) {
        dataPoints = new HashMap<>();
        this.aggregationMethod = aggregationMethod;
        this.aggregationPeriod = aggregationPeriod;
        this.dateFormat = DateTimeFormatter.ofPattern(dateFormat);
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
                dataPoints.put(id, new DataPoint(q.getName(), dataPointDate, q.getMeasure()));
            } else {
                dataPoints.get(id).add(q.getMeasure());
            }
        }

        return this;
    }

    public HashMap<String, XYChart.Series<String, Number>> buildSeries() {
        HashMap<String, XYChart.Series<String, Number>> seriesMap = new HashMap<>();

        dataPoints.forEach((k, v) -> {
            XYChart.Series series;
            XYChart.Data<String, Number> data;

            double measure;
            String category = v.getName();
            String date = v.getDate().format(dateFormat);

            if (!seriesMap.containsKey(category)) {
                ObservableList<XYChart.Data<String, Number>> ol = FXCollections.observableArrayList();
                series = new XYChart.Series(ol);
                series.setName(category);
            } else {
                series = seriesMap.get(category);
            }

            switch (aggregationMethod) {
                case AVERAGE:
                    measure = v.getAverage();
                    break;
                case SUM:
                default:
                    measure = v.getSum();
            }

            data = new XYChart.Data<>(date, measure);
            series.getData().add(data);
        });

        return seriesMap;
    }

    public DateTimeFormatter getDateFormat() {
        return dateFormat;
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
        }

        public void add(double value) {
            count++;
            sum += value;
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
