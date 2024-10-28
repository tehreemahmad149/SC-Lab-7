package twitter;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import java.io.File;
import java.io.IOException;
import static org.junit.Assert.*;

public class FileSearcherTest {
    
    private File rootDirectory;
    private File subDirectory1;
    private File subDirectory2;
    private File targetFile;
    private File nonTargetFile;

    @Before //before tests set up teh dir system so that the dummy files can be found etc
    public void setUp() throws IOException {
        // Setup a temporary directory structure for testing
        rootDirectory = new File("testDir");
        rootDirectory.mkdir();//shell com,and will also work
        
        subDirectory1 = new File(rootDirectory, "subDir1");
        subDirectory1.mkdir();
        
        subDirectory2 = new File(subDirectory1, "subDir2");
        subDirectory2.mkdir();
        
        targetFile = new File(subDirectory2, "targetFile.txt");
        targetFile.createNewFile();
        
        nonTargetFile = new File(rootDirectory, "otherFile.txt");
        nonTargetFile.createNewFile();
    }

    @Test
    public void testFileFoundInSubdirectory() {
        // target in sub direcotry
        assertTrue( "File should be found in subdirectory.", FileSearcher.searchFile(rootDirectory, "targetFile.txt"));
    }
    
    @Test
    public void testFileNotFound() {
        // target not in root
        assertFalse( "File should not be found.", FileSearcher.searchFile(rootDirectory, "nonExistentFile.txt"));//use dummy name
    }
    
    @Test
    public void testFileInRootDirectory() {
        // secondary in root
        assertTrue("File should be found in root directory.", FileSearcher.searchFile(rootDirectory, "otherFile.txt"));
    }
    
    @Test
    public void testFileInEmptyDirectory() {
        //no file in newly created empty dir
        File emptyDirectory = new File(rootDirectory, "emptyDir");
        emptyDirectory.mkdir();
        assertFalse("File should not be found in empty directory.", FileSearcher.searchFile(emptyDirectory, "someFile.txt"));
    }

    @Test
    public void testInvalidDirectory() {
        // invalid dir = dir that does not exist
        File invalidDirectory = new File("invalidDir");
        assertFalse("Should return false for a non-existent directory." ,FileSearcher.searchFile(invalidDirectory, "someFile.txt"));
    }

    // delete dirs after tests
    @After //using @after so that after tests ends this piece of code runs
    public void tearDown() {
        deleteDirectory(rootDirectory);
    }

    private void deleteDirectory(File directory) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectory(file);
                } else {
                    file.delete();
                }
            }
        }
        directory.delete();
    }
}
