package analytics.databuilders;

import java.time.LocalDate;

/**
 * The interface Quantifiable represents
 * 
 * @author jsm158
 * @since M03-A04
 * 
 */
public interface Quantifiable {

    public LocalDate getDate();
    public double getMeasure();
    public String getName();
}
