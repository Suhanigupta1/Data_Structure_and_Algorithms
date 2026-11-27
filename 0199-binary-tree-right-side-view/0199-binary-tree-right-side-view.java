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
    public List<Integer> rightSideView(TreeNode root) {
        if (root==null){
            return new ArrayList<Integer>();
        }
        List<Integer> ls = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode t = q.remove(); 
                if(i == size-1){
                    ls.add(t.val);
                }
                if(t.left!=null){
                    q.add(t.left);
                }   
                if(t.right!=null){
                    q.add(t.right);
                }
            }
        }
        return ls;
    }
}