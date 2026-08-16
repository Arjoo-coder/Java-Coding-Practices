import java.util.Stack;

class Solution {
    public String removeDuplicateLetters(String s) {
        // Track the last occurrence index of each character
        int[] lastIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }

        // Track whether a character is already present in our current result path
        boolean[] seen = new boolean[26];
        
        // Stack to maintain the characters in the smallest lexicographical order
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            // If the character is already in our stack, skip it to avoid duplicates
            if (seen[curr - 'a']) {
                continue;
            }

            // Greedy Choice: Pop characters from the stack if:
            // 1. The top of the stack is lexicographically greater than the current character
            // 2. The top character appears again later in the string (index < lastIndex)
            while (!stack.isEmpty() && stack.peek() > curr && lastIndex[stack.peek() - 'a'] > i) {
                seen[stack.pop() - 'a'] = false;
            }

            // Push current character and mark it as seen
            stack.push(curr);
            seen[curr - 'a'] = true;
        }

        // Build the final string from the stack
        StringBuilder sb = new StringBuilder();
        for (char c : stack) {
            sb.append(c);
        }

        return sb.toString();
    }
}
