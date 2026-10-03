class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        // Frequency array for 26 lowercase English letters
        int[] counts = new int[26];

        // Count available characters in magazine
        for (char c : magazine.toCharArray()) {
            counts[c - 'a']++;
        }

        // Subtract characters needed for ransomNote
        for (char c : ransomNote.toCharArray()) {
            if (counts[c - 'a'] == 0) {
                return false; // Character not available in required frequency
            }
            counts[c - 'a']--;
        }

        return true;
    }
}