import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PalindromeTest {
    
    @Test
    public void testSimplePalindrome() {
        assertTrue(Palindrome.isPalindrome("radar"));
    }
    
    @Test
    public void testNotPalindrome() {
        assertFalse(Palindrome.isPalindrome("hello"));
    }
    
    @Test
    public void testCaseInsensitive() {
        assertTrue(Palindrome.isPalindrome("RaceCar"));
    }
    
    @Test
    public void testWithSpaces() {
        assertTrue(Palindrome.isPalindrome("A man a plan a canal Panama"));
    }
    
    @Test
    public void testWithPunctuation() {
        assertTrue(Palindrome.isPalindrome("Madam, I'm Adam"));
    }
    
    @Test
    public void testAlphanumeric() {
        assertTrue(Palindrome.isPalindrome("A1B2B1A"));
    }
    
    @Test
    public void testSingleCharacter() {
        assertTrue(Palindrome.isPalindrome("a"));
    }
    
    @Test
    public void testEmptyString() {
        assertTrue(Palindrome.isPalindrome(""));
    }
    
    
    @Test
    public void testNullInput() {
        assertFalse(Palindrome.isPalindrome(null));
    }
}