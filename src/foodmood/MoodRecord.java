package foodmood;

import java.time.LocalDate;

/**
 * MoodRecord represents a mood value recorded by a user on a date.
 *
 * M02:
 *
 * @author aswecker
 *
 * M03-A04:
 * @author jsm158
 */
public class MoodRecord implements Quantifiable {

    private final String id;
    private final String accountId;
    private final LocalDate date;
    private final String moodId;
    private final String name;
    private final double value;

    /**
     * This is the default constructor for the Mood Record Class.
     *
     * @param id the id number of the mood
     * @param accountId the account number of the user
     * @param date the date the mood was logged
     * @param moodId the associated mood's ID
     * @param moodName the associated mood's name
     * @param value the value entered by the user
     */
    public MoodRecord(String id, String accountId, LocalDate date, String moodId, String moodName, double value) {
        this.id = id;
        this.accountId = accountId;
        this.date = date;
        this.moodId = moodId;
        this.name = moodName;
        this.value = value;
    }

    /**
     * Returns the mood ID
     *
     * @return the mood ID
     */
    public String getId() {
        return id;
    }

    /**
     * Returns ID of the user account that logged the mood
     *
     * @return the account ID
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * Returns the date the mood was recorded
     *
     * @return the date a user logged a mood
     */
    @Override
    public LocalDate getDate() {
        return date;
    }

    /**

    /**
     * Returns the associated mood name
     *
     * @return A string of the mood name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * Returns the value logged for the mood
     *
     * @return the value
     */
    @Override
    public double getValue() {
        return value;
    }

    /**
     * Returns the ID of the associated mood
     *
     * @return the mood ID
     */
    public String getMoodId() {
        return moodId;
    }
}
