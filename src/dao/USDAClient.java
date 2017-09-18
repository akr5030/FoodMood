package dao;

/**
 * Provides an interface to searching for a food in the USDA's food database
 *
 * Note that there is no guarantee that the database will be available. The
 * device may not be connected to the internet. The service may be down or
 * experiencing problems. In these cases the client will return null.
 *
 * The searching is actually performed by the USDA database service and no
 * filtering is provided by this class. Therefore, there is no guarantee of
 * accuracy in the result.
 *
 * @author jsm158
 *
 */
public class USDAClient {

    private static final String URL = "";

    /**
     * Constructs a new USDAClient
     */
    public USDAClient() {
    }

    /**
     * Conducts a search for food items with a name matching the specified term
     *
     * The searching is actually performed by the USDA database service and no
     * filtering is provided by this method. Therefore, there is no guarantee of
     * accuracy in the result. There is also no guarantee that the USDA's
     * service will be available. If there are no matching foods or the service
     * is unavailable null will be returned
     *
     * @param searchTerm the term to search for in the food name
     * @return a list of matching foods or null if there is no match or the
     * service is unavailable
     */
    public Object findFoodsByName(String searchTerm) {
        return null;
    }

}
