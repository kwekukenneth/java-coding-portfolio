public class Palindrome {
    
    public static boolean isPalindrome(String input) {
        if (input == null) {
            return false;
        }
        
        // Remove non-alphanumeric characters and convert to lowercase
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        // Empty string is considered a palindrome
        if (cleaned.isEmpty()) {
            return true;
        }
        
        // Check if the string reads the same forwards and backwards
        int left = 0;
        int right = cleaned.length() - 1;
        
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        // Example usage
        String[] testCases = {
            "radar",
            "A man, a plan, a canal: Panama",
            "race a car",
            "Was it a car or a cat I saw?",
            "Madam",
            "12321",
            "hello",
            "123abc321",
            "Test123321tseT"
        };
        
        System.out.println("Palindrome Checker");
        System.out.println("==================");
        
        for (String test : testCases) {
            boolean result = isPalindrome(test);
            System.out.printf("\"%s\" -> %s%n", test, result ? "Palindrome" : "Not a palindrome");
        }
    }
}