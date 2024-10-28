package twitter;

import org.junit.Test;
import static org.junit.Assert.*;
import java.util.List;

public class permsTest {

    @Test
    public void testSingleCharacterString() {
        List<String> permutations = perms.generatePermutations("a");
        assertEquals(1, permutations.size());
        assertTrue(permutations.contains("a"));
    }

    @Test
    public void testTwoCharacterString() {
        List<String> permutations = perms.generatePermutations("ab");
        assertEquals(2, permutations.size());
        assertTrue(permutations.contains("ab"));
        assertTrue(permutations.contains("ba"));
    }

    @Test
    public void testThreeCharacterString() {
        List<String> permutations = perms.generatePermutations("abc");
        assertEquals(6, permutations.size());
        assertTrue(permutations.contains("abc"));
        assertTrue(permutations.contains("acb"));
        assertTrue(permutations.contains("bac"));
        assertTrue(permutations.contains("bca"));
        assertTrue(permutations.contains("cab"));
        assertTrue(permutations.contains("cba"));
    }

    @Test
    public void testEmptyString() {
        List<String> permutations = perms.generatePermutations("");
        assertEquals(0, permutations.size());
    }

    @Test
    public void testNullString() {
        List<String> permutations = perms.generatePermutations(null);
        assertEquals(0, permutations.size());
    }

    @Test
    public void testDuplicateCharacters() {
        List<String> permutations = perms.generatePermutations("aab");
        assertEquals(3, permutations.size());
        assertTrue(permutations.contains("aab"));
        assertTrue(permutations.contains("aba"));
        assertTrue(permutations.contains("baa"));
    }
}
