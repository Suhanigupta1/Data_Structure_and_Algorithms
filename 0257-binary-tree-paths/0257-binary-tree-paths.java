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
    public List<String> ls;

    public List<String> binaryTreePaths(TreeNode root) {
        ls = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();

        allRootToLeafPaths(root, arr);

        return ls;
    }

    public void allRootToLeafPaths(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return;
        }

        arr.add(root.val);

        if (root.left == null && root.right == null) {
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < arr.size(); i++) {
                if (i > 0) {
                    sb.append("->");
                }
                sb.append(arr.get(i));
            }

            ls.add(sb.toString());
        } else {
            allRootToLeafPaths(root.left, arr);
            allRootToLeafPaths(root.right, arr);
        }

        // Backtracking
        arr.remove(arr.size() - 1);
    }
}