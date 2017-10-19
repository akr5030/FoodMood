package analytics.databuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Builds a list a list of dates between specified start and end dates. The
 * dates are formatted using a DateTimeFormatter passed to the class.
 *
 * The default time period is the past week and the default format is
 * {@link DateTimeFormatter#ISO_LOCAL_DATE}
 *
 * @author jsm158
 * @since M03-A04
 *
 */
public class TimeSeriesAxisCategoriesBuilder {

    private LocalDate startDate;
    private LocalDate endDate;
    private DateTimeFormatter dateFormat;

    /**
     * Constructs a new TimeSeriesAxisCategoriesBuilder using default options
     *
     * Default time period: previous week Default date format:
     * {@link DateTimeFormatter#ISO_LOCAL_DATE}
     */
    public TimeSeriesAxisCategoriesBuilder() {
        this(LocalDate.now().minusWeeks(1), LocalDate.now(), DateTimeFormatter.ISO_LOCAL_DATE);
    }

    /**
     * Constructs a new TimeSeriesAxisCategoriesBuilder with the specified
     * options
     *
     * @param startDate the first date
     * @param endDate the last date
     * @param dateFormat the date format
     */
    public TimeSeriesAxisCategoriesBuilder(LocalDate startDate, LocalDate endDate, DateTimeFormatter dateFormat) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.dateFormat = dateFormat;
    }

    /**
     * Builds an ordered list of date strings between the specified start and
     * end dates (inclusive)
     *
     * @return list of date strings
     * @throws DataBuilderException thrown if the start date is after the end
     * date
     */
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

    /**
     * Returns the start date
     *
     * @return the start date
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Sets the start date and returns the TimeSeriesAxisCategoriesBuilder
     * instance
     *
     * @param startDate the start date
     * @return the TimeSeriesAxisCategoriesBuilder isntance
     */
    public TimeSeriesAxisCategoriesBuilder setStartDate(LocalDate startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     * Returns the end date
     *
     * @return the end date
     */
    public LocalDate getEndDate() {
        return endDate;
    }

    /**
     * Sets the end date and returns the TimeSeriesAxisCategoriesBuilder
     * instance
     *
     * @param endDate the end date
     * @return the TimeSeriesAxisCategoriesBuilder isntance
     */
    public TimeSeriesAxisCategoriesBuilder setEndDate(LocalDate endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     * Returns the date format
     *
     * @return the date format
     */
    public DateTimeFormatter getDateFormat() {
        return dateFormat;
    }

    /**
     * Sets the date format and returns the TimeSeriesAxisCategoriesBuilder
     * instance
     *
     * @param dateFormat the date format
     * @return the TimeSeriesAxisCategoriesBuilder instance
     */
    public TimeSeriesAxisCategoriesBuilder setDateFormat(DateTimeFormatter dateFormat) {
        this.dateFormat = dateFormat;
        return this;
    }

}
