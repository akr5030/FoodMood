package foodmood;

import java.time.LocalDate;

/**
 * The Quantifiable interface defines the data needed for an object to be
 * displayed on a line graph or chart.
 *
 * Every Quantifiable object needs a display name, date, and a numeric value.
 * The numeric value will be plotted as a measure.
 *
 * @author jsm158
 * @since M03-A04
 */
public interface Quantifiable {

    /**
     * Returns the date on which the item was recorded
     *
     * @return the record date
     */
    public LocalDate getDate();

    /**
     * Returns the name of the item recorded
     *
     * @return
     */
    public String getName();

    /**
     * Returns the ID of the item recorded
     *
     * i.e. the ID of the mood or food
     *
     * @return the ID of the mood or food
     */
    public int getTypeId();

    /**
     * Returns the numeric value of the item recorded
     *
     * @return
     */
    public double getValue();
}
