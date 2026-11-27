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
    class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 1));
        int left=0;
        int right=0;
        int max = 0;  
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().index;
            for(int i=0; i<size; i++){
                Pair p = q.remove();
                TreeNode t = p.node;
                if(i==0){
                    left = p.index;
                }
                if(i == size-1){
                    right = p.index;
                }
                
                int ind = p.index-min;
                if(t.left!=null){
                    q.add(new Pair(t.left, (2*ind)+ 1));
                };
                if(t.right!=null){
                    q.add(new Pair(t.right, (2*ind) +2));
                };
            }  
            int width = right- left +1;
            max = Math.max(width, max); 
        }  
        return max;
    }
}