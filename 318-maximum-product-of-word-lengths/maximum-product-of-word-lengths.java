class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] masks = new int[n];
        
        // Step 1: Create a bit mask for each word
        for (int i = 0; i < n; i++) {
            int mask = 0;
            for (char ch : words[i].toCharArray()) {
                // Set the bit corresponding to the character
                mask |= (1 << (ch - 'a'));
            }
            masks[i] = mask;
        }
        
        int maxProduct = 0;
        
        // Step 2: Compare every pair of words
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                // If bitwise AND is 0, they share no common characters
                if ((masks[i] & masks[j]) == 0) {
                    int product = words[i].length() * words[j].length();
                    maxProduct = Math.max(maxProduct, product);
                }
            }
        }
        
        return maxProduct;
    }
}
