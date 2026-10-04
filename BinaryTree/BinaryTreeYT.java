import java.util.LinkedList;
import java.util.Queue;

class BinaryTreeYTPractice{
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val){
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree{
        static int idx = -1;
        public static TreeNode buildTree(int[] nodes){
            idx++;
            if (nodes[idx] == -1){
                return null;
            }
            TreeNode newNode = new TreeNode(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;

    }
    static void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }
    static void inOrder(TreeNode root){
        if(root==null){
            return;
        }
        inOrder(root.left);     
        System.out.print(root.val + " ");
       
        inOrder(root.right);
    }
    static void postOrder(TreeNode root){
        if (root==null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
    static int CountOfNodes(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftCount = CountOfNodes(root.left);
        int rightCount = CountOfNodes(root.right);

        return leftCount + rightCount + 1;
    }
    static int SumOfNodes(TreeNode root){
        if (root == null) {
            return 0;
        }
        int leftSum = SumOfNodes(root.left);
        int rightSum = SumOfNodes(root.right);
        return leftSum + rightSum + root.val;
    }

    static int HeightOfTree(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftHeight = HeightOfTree(root.left);
        int rightHeight = HeightOfTree(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    //O(n2)
    static int DiameterOfTree(TreeNode root){
        if (root == null){
            return 0;
        }
        int leftDiameter = DiameterOfTree(root.left);
        int rightDiameter = DiameterOfTree(root.right);
        int leftHeight = HeightOfTree(root.left);
        int rightHeight = HeightOfTree(root.right);

        int selfDiameter = leftHeight + rightHeight + 1;

        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
    }


    static class TreeInfo{
        int height ;
        int diameter;
        TreeInfo(int height, int diameter){
            this.height = height;
            this.diameter = diameter;   
        }
    }
    //O(n)
    static TreeInfo diameterofTreeInfo(TreeNode root){
        if (root==null){
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameterofTreeInfo(root.left);
        TreeInfo right = diameterofTreeInfo(root.right);

        int myHeight = Math.max(left.height, right.height) + 1;
        int diam1 = left.diameter;
        int diam2 = right.diameter;
        int diam3 = left.height + right.height + 1;
        int myDiameter = Math.max(diam3, Math.max(diam1, diam2));
        return new TreeInfo(myHeight, myDiameter);
    }



   

    static void levelOrder(TreeNode root){
        if(root==null){
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        while(!q.isEmpty()){
            TreeNode currNode = q.remove();
            if (currNode==null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.val + " ");
                if(currNode.left!=null){
                    q.add(currNode.left);
                }
                if(currNode.right!=null){
                    q.add(currNode.right);
                }
            }
        }
    }
}

    public static void main(String[] args){
        int[] nodes = {1, 2, 4, -1, -1, 5, -1,-1, 3, -1, 6, -1, -1};
        TreeNode root = BinaryTree.buildTree(nodes);
        System.out.println(root.val);
        BinaryTree.preOrder(root);
        System.out.println();
        BinaryTree.inOrder(root);
        System.out.println();
        BinaryTree.postOrder(root);
        System.out.println();
        BinaryTree.levelOrder(root);
        System.out.println("Diameter of the tree is: " + BinaryTree.DiameterOfTree(root));
        System.out.println("Diameter of the tree is: " + BinaryTree.diameterofTreeInfo(root).diameter);
        System.out.println("Height of the tree is: " + BinaryTree.HeightOfTree(root));
        System.out.println("Count of nodes in the tree is: " + BinaryTree.CountOfNodes(root));
        System.out.println("Sum of nodes in the tree is: " + BinaryTree.SumOfNodes(root));
    }
}