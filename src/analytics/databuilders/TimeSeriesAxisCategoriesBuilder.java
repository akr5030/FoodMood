package analytics.databuilders;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Builds a list a list of dates between specified start and end dates. The
 * dates are formatted using a DateTimeFormatter passed to the class.
 *
 * <p>
 * The default time period is the past week and the default format is
 * {@link DateTimeFormatter#ISO_LOCAL_DATE}</p>
 *
 * <p>
 * This class solves the problem of generating an complete, ordered list of
 * dates to display on the x-axis of a JavaFX line graph. JavaFX does not
 * provide a date-based axis. If we built the graph just by creating a series of
 * date strings, Java would only display the dates contained in the series,
 * skipping any days with missing data,, and would not order them correctly. If
 * you create a list of strings separately and set them as the categories for
 * the x-axis, however, JavaFX will add all of them to the axis in the specified
 * order then match up data points.</p>
 *
 * <p>
 * Usage:</p>
 *
 * <pre>
 * // Reference to a line graph in the fxml view
 * \@FXML
 * private LineChart lineChart;
 *
 * // Reference to the x-axis
 * \@FXML
 * private CategoryAxis axis;
 *
 * // List of strings to be used for the axis categories
 * ObservableList&gt;String&lt; categories;
 *
 * // Method 1: TimeSeriesAxisCategoriesBuilder tsb = new TimeSeriesAxisCategoriesBuilder(
 *         theStartDate, theEndDate, theDateFormat);
 * categories = tsb.buildCategories();
 * axis.setCategories(categories);
 *
 * // Method 2: // use any or none of the setters to configure the builder as
 * desired TimeSeriesAxisCategoriesBuilder tsb = new TimeSeriesAxisCategoriesBuilder();
 * categories = tsb.setStartDate(theStartDate)
 *     .setEndDate(theEndDate)
 *     .buildCategories();
 * axis.setCategories(categories);
 * </pre>
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
