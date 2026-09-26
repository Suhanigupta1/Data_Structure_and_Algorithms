import java.util.ArrayList;
class BinarySearchTree{
    static class Node {
        int data;
        Node left;
        Node right;
    
        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node insert(Node root, int val){
        if (root == null){
            root = new Node(val);
            return root;
        }
        if (val < root.data){
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val); 
        } 
        return root;
    }
    public static void inOrder(Node root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key){
        if (root == null){
            return false;
        }
        if (key == root.data){
            return true;
        }
        if (key < root.data){
            return search(root.left, key);
        }else{
            return search(root.right, key);
        }
    }
    
    public static Node delete(Node root, int key){
    //case 1 - node is a leaf node - delete the node and return its parent node 
    //case 2 -  node has one child - delete the node and connect its child to its parent node
    //case 3 - node had two child - replace the value with its inorder successor and delete the inorder successor
       
    if (root==null){
        return null;
    }
    if (key < root.data){
        root.left = delete(root.left, key);
    }
    else if (key > root.data){
        root.right = delete(root.right, key);
    }
    else{
        //case 1
        if (root.left == null && root.right == null){
            return null;
        }
        //case 2
        if (root.left == null){
            return root.right;
        }else if (root.right == null){
            return root.left;
        }
        //case 3
        Node IS = findInorderSuccessor(root.right);
        root.data = IS.data;
        root.right = delete(root.right, IS.data);
    }
    return root;
}
    public static Node findInorderSuccessor(Node root){
        while (root.left != null){
            root = root.left;
        }
        return root;
    }
    public static void printPath(ArrayList<Integer> path){
        for (int i=0; i<path.size(); i++){
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }
    
    public static void printrootToLeafPaths(Node root, ArrayList<Integer> path){
        if (root == null){
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null){
            printPath(path);
        }else{
            printrootToLeafPaths(root.left, path);
            printrootToLeafPaths(root.right, path);
        }
        path.remove(path.size()-1);
    }

    public static void printInRange(Node root, int x, int y){
        if (root == null){
            return;
        }
        if (root.data>=x && root.data <=y){
        printInRange(root.left, x, y);
        System.out.print(root.data + " ");
        printInRange(root.right, x, y);
        }else if (root.data < x){
        printInRange(root.right, x, y);
        }else{
        printInRange(root.left, x, y);
        }
    }
    public static void main(String[] args) {    
        int values[] = {8, 5 , 3, 1, 4, 6 , 10, 11, 14};
        Node root = null;

        for(int i=0; i<values.length; i++){
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();

        System.out.println(search(root, 3)); // Output: true
        System.out.println(search(root, 6)); // Output: false
        printrootToLeafPaths(root, new ArrayList<>());
        printInRange(root, 1, 6);

    }
}



