/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        if (root != null) {
            dfs(root, "", paths);
        }
        return paths;
    }

    private void dfs(TreeNode node, String path, List<String> paths) {
        // Append current node's value to the path
        path += node.val;

        // If it's a leaf node, add the complete path to the results
        if (node.left == null && node.right == null) {
            paths.add(path);
            return;
        }

        // Recursively visit left and right children with "->" separator
        if (node.left != null) {
            dfs(node.left, path + "->", paths);
        }
        if (node.right != null) {
            dfs(node.right, path + "->", paths);
        }
    }
}