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
    class Tuple{
        TreeNode node;
        int row;
        int col;
        Tuple(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;     
        }
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root, 0, 0));
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0; i<size; i++){
                Tuple t = q.remove();
                int x = t.row; 
                int y = t.col;
                if (!map.containsKey(x)){
                    map.put(x, new TreeMap<>());
                }
                if(!map.get(x).containsKey(y)){
                    map.get(x).put(y, new PriorityQueue<>());
                }
                map.get(x).get(y).add(t.node.val);

                if(t.node.left != null){
                    q.add(new Tuple(t.node.left, x-1, y+1));
                }
                if (t.node.right != null){
                    q.add(new Tuple(t.node.right,x+1,y+1));
                }
            }
        }
        List<List<Integer>> list = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> t : map.values()){
            list.add(new ArrayList<>());
            for(PriorityQueue<Integer> pq : t.values()){
                while(!pq.isEmpty()){
                    list.get(list.size()-1).add(pq.poll());
                }
            }
        }
        return list;
        
    }
}