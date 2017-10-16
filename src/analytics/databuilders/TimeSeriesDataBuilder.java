package analytics.databuilders;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

/**
 * The TimeSeriesDataBuilder class represents
 *
 * Note: Only builds daily (longer note here)
 *
 * @author jsm158
 * @since M03-A04
 *
 */
public class TimeSeriesDataBuilder {
    
    private AggregationMethod aggregationMethod;
    private AggregationPeriod aggregationPeriod;
    private HashMap<String, DataPoint> dataPoints;
    
    public enum AggregationPeriod {
        DAY, MONTH
    }
    
    public enum AggregationMethod {
        AVERAGE, SUM
    }
    
    public TimeSeriesDataBuilder() {
        this(AggregationMethod.SUM, AggregationPeriod.DAY);
    }
    
    public TimeSeriesDataBuilder(AggregationMethod aggregationMethod, AggregationPeriod aggregationPeriod) {
        dataPoints = new HashMap<>();
        this.aggregationMethod = aggregationMethod;
        this.aggregationPeriod = aggregationPeriod;
    }
    
    public TimeSeriesDataBuilder addData(final Collection<Quantifiable> data) {
        String idFormat = "%s-%s";
        
        for (Quantifiable q : data) {
            String id = String.format(idFormat, q.getName(), q.getDate());
            if (!dataPoints.containsKey(id)) {
                dataPoints.put(id, new DataPoint(q.getName(), q.getDate(), q.getMeasure()));
            } else {
                dataPoints.get(id).add(q.getMeasure());
            }
        }
        
        return this;
    }
    
    public HashMap<String, XYChart.Series> buildSeries() {
        // TODO finish this
        HashMap<String, XYChart.Series> seriesMap = new HashMap<>();
        
        dataPoints.forEach((k, v) -> {
            XYChart.Data<String, Number> data;
            
            if (!seriesMap.containsKey(k)) {
                ObservableList<XYChart.Data<String, Number>> ol = FXCollections.observableArrayList();
                XYChart.Series series = new XYChart.Series(ol);
                series.setName(k);
            }
            

            
        });
        
        return seriesMap;
    }
    
    public TimeSeriesDataBuilder setAggregationMethod(AggregationMethod aggregationMethod) {
        this.aggregationMethod = aggregationMethod;
        return this;
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
