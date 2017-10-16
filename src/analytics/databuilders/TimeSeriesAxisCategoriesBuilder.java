package analytics.databuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * The TimeSeriesAxisCategoriesBuilder class represents
 * 
 * @author jsm158
 * @since M03-A04
 *
 */
public class TimeSeriesAxisCategoriesBuilder {

    private LocalDate startDate;
    private LocalDate endDate;
    private String dateFormatString;
    
    public ObservableList<String> buildCategories() {
        ObservableList<String> categories = FXCollections.observableArrayList();
        
        LocalDate date = startDate;
        while (date.isBefore(endDate.plusDays(1))) {
            categories.add(date.format(DateTimeFormatter.ofPattern(dateFormatString)));
            date = date.plusDays(1);
        }
        
        return categories;
    }

    public TimeSeriesAxisCategoriesBuilder() {
        this.startDate = LocalDate.now().minusWeeks(1);
        this.endDate = LocalDate.now();
        this.dateFormatString = DateTimeFormatter.ISO_LOCAL_DATE.toString();
    }

    public TimeSeriesAxisCategoriesBuilder(LocalDate startDate, LocalDate endDate, String dateFormat) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.dateFormatString = dateFormat;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public TimeSeriesAxisCategoriesBuilder setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public TimeSeriesAxisCategoriesBuilder setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }
    
    public String getDateFormatString() {
        return dateFormatString;
    }

    public TimeSeriesAxisCategoriesBuilder setDateFormat(String dateFormat) {
        this.dateFormatString = dateFormat;
        return this;
    }

}
