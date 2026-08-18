import java.util.HashMap;
import java.util.Map;

class WordDictionary {

    // Definition of the Trie Node
    private class TrieNode {
        // Map to store children nodes. 
        // Alternatively, an array 'TrieNode[] children = new TrieNode[26]' can be used.
        Map<Character, TrieNode> children;
        boolean isEndOfWord;

        public TrieNode() {
            children = new HashMap<>();
            isEndOfWord = false;
        }
    }

    private TrieNode root;

    /** Initializes your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            // If the character node doesn't exist, create it
            current.children.putIfAbsent(ch, new TrieNode());
            // Move to the child node
            current = current.children.get(ch);
        }
        // Mark the end of the word
        current.isEndOfWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return searchInNode(word, 0, root);
    }

    // Helper method to perform DFS backtracking for wildcard search
    private boolean searchInNode(String word, int index, TrieNode current) {
        // If we reached the end of the string, check if it forms a valid word
        if (index == word.length()) {
            return current.isEndOfWord;
        }

        char ch = word.charAt(index);

        if (ch == '.') {
            // Wildcard matching: try all possible children branches at this level
            for (TrieNode child : current.children.values()) {
                if (searchInNode(word, index + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            // Exact matching: check if the character exists in the children map
            if (!current.children.containsKey(ch)) {
                return false;
            }
            // Move to the next character
            return searchInNode(word, index + 1, current.children.get(ch));
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
