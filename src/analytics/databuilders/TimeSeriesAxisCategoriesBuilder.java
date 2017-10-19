package analytics.databuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Builds a list of dates
 *
 * @author jsm158
 * @since M03-A04
 *
 */
public class TimeSeriesAxisCategoriesBuilder {

    private LocalDate startDate;
    private LocalDate endDate;
    private DateTimeFormatter dateFormat;

    public TimeSeriesAxisCategoriesBuilder() {
        this(LocalDate.now().minusWeeks(1), LocalDate.now(), DateTimeFormatter.ISO_LOCAL_DATE);
    }

    public TimeSeriesAxisCategoriesBuilder(LocalDate startDate, LocalDate endDate, DateTimeFormatter dateFormat) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.dateFormat = dateFormat;
    }

    public ObservableList<String> buildCategories() throws DataBuilderException {

        ObservableList<String> categories = FXCollections.observableArrayList();
        LocalDate date = startDate;

        if (startDate.isAfter(endDate)) {
            throw new DataBuilderException("Start date must be before end date");
        }

        while (date.isBefore(endDate.plusDays(1))) {
            categories.add(date.format(dateFormat));
            date = date.plusDays(1);
        }

        return categories;
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

    public DateTimeFormatter getDateFormat() {
        return dateFormat;
    }

    public TimeSeriesAxisCategoriesBuilder setDateFormat(DateTimeFormatter dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

}
