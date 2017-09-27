package TestHarness;

/**
 *
 * @author redjen
 */
public class Tests {
    
    private Tests() {
    }
    
    public boolean testFoodLogViewControllerGetRecords() {
        return true;
    }
    
    public boolean testFoodLogViewControllerDeleteRecord() {
        return true;
    }
    
    
    public static Tests getInstance() {
        return TestsHolder.INSTANCE;
    }
    
    private static class TestsHolder {

        private static final Tests INSTANCE = new Tests();
    }
}
