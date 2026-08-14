class Trie {

    // Node of Trie
    class TrieNode {

        // 26 possible lowercase English letters
        TrieNode[] children = new TrieNode[26];

        // True if a complete word ends at this node
        boolean isEnd = false;
    }

    // Root node
    private TrieNode root;

    // Constructor
    public Trie() {
        root = new TrieNode();
    }

    // Insert a word into Trie
    public void insert(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            // If node doesn't exist, create it
            if (current.children[index] == null) {
                current.children[index] = new TrieNode();
            }

            // Move to next node
            current = current.children[index];
        }

        // Mark the end of the word
        current.isEnd = true;
    }

    // Search for a complete word
    public boolean search(String word) {

        TrieNode current = root;

        for (char ch : word.toCharArray()) {

            int index = ch - 'a';

            // Character not found
            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        // Word must end at this node
        return current.isEnd;
    }

    // Check whether any word starts with the given prefix
    public boolean startsWith(String prefix) {

        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {

            int index = ch - 'a';

            // Prefix doesn't exist
            if (current.children[index] == null) {
                return false;
            }

            current = current.children[index];
        }

        // Prefix exists
        return true;
    }
}