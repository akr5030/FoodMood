package dao;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests for the ConnectionManager class
 *
 * @author jsm158
 */
public class ConnectionManagerTest {

    public ConnectionManagerTest() {
    }

    @Test
    public void testCreateDeleteDatabaseNotExists() throws Exception {
        ConnectionManager.createDatabaseIfNotExists();

        assertTrue("Failed to create data directory",
                Files.isDirectory(Paths.get(ConnectionManager.DATA_DIR)));
        assertTrue("Failed to create accounts director",
                Files.isDirectory(Paths.get(ConnectionManager.DATA_DIR, ConnectionManager.ACCOUNT_DATA_DIR)));

        ConnectionManager.deleteDatabase();

        assertFalse("failed to delete data directory", Files.exists(Paths.get(ConnectionManager.DATA_DIR)));
    }

    @Test
    public void testCreateDeleteDatabaseWithFiles() throws Exception {
        Path testfile1 = Paths.get(ConnectionManager.DATA_DIR, "testFile1");
        Path testfile2 = Paths.get(ConnectionManager.DATA_DIR, "testFile2");
        Path testfile3 = Paths.get(ConnectionManager.DATA_DIR, ConnectionManager.ACCOUNT_DATA_DIR, "testfile3");
        Path testfile4 = Paths.get(ConnectionManager.DATA_DIR, ConnectionManager.ACCOUNT_DATA_DIR, "testfile4");

        // create the data directory normally
        ConnectionManager.createDatabaseIfNotExists();

        // manually create some files in the data directory
        Files.createFile(testfile1);
        Files.createFile(testfile2);
        Files.createFile(testfile3);
        Files.createFile(testfile4);

        assertTrue("Failed to create data directory",
                Files.isDirectory(Paths.get(ConnectionManager.DATA_DIR)));
        assertTrue("Failed to create accounts director",
                Files.isDirectory(Paths.get(ConnectionManager.DATA_DIR, ConnectionManager.ACCOUNT_DATA_DIR)));
        assertFileExistsHelper(testfile1);
        assertFileExistsHelper(testfile2);
        assertFileExistsHelper(testfile3);
        assertFileExistsHelper(testfile4);

        ConnectionManager.deleteDatabase();
        assertFalse("failed to delete data directory", Files.exists(Paths.get(ConnectionManager.DATA_DIR)));
    }

    private void assertFileExistsHelper(Path path) {
        assertTrue(String.format("Failed to create file %s", path.toAbsolutePath().toString()),
                Files.exists(path));
    }

}
