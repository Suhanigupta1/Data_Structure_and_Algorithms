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
    public int Maxdia;
    public int diameterOfBinaryTree(TreeNode root) {
        heightOfTree(root);
        return Maxdia; 
    }
    public int heightOfTree(TreeNode root){
        if(root==null){
            return -1;
        }
        int left =  heightOfTree(root.left);
        int right = heightOfTree(root.right);
        Maxdia = Math.max( Maxdia, left + right + 2);
        return Math.max(left , right) + 1;
    }

}