class Solution {
    public char findTheDifference(String s, String t) {
        char c = 0;
        
        // XOR all characters in s
        for (char ch : s.toCharArray()) {
            c ^= ch;
        }
        
        // XOR all characters in t
        for (char ch : t.toCharArray()) {
            c ^= ch;
        }
        
        // All matching characters cancel out to 0, leaving the added character
        return c;
    }
}