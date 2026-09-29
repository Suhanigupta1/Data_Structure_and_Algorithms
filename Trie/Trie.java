class Trie {
    static class Node {
        Node[] children;
        boolean eow;
    
        public Node(){
            children = new Node[26];
                for(int i=0; i<26; i++){
                    children[i] = null;
                }
            eow = false;
        }
    }
    static Node root = new Node();

    public static Boolean Search(String key){
        Node currNode = root;
        for(int i=0; i<key.length(); i++){
            int idx = key.charAt(i)-'a';
            if (currNode.children[idx]==null){
                return false;
            }
            if(i==key.length()-1 && currNode.children[idx].eow==false){
               return false;
            }
            currNode = currNode.children[idx];
        }
        return true;
    }

    public static Node insert(String words){
        Node currNode = root;
        for(int i=0; i < words.length(); i++){
            int idx = words.charAt(i)-'a';
            if (currNode.children[idx]==null){
                currNode.children[idx] = new Node();
            }
            currNode = currNode.children[idx];
        }
        currNode.eow = true;
        return currNode;
    }


    public static void main(String[] args){
        String[] words = {"the", "a", "their", "any", "there"};
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }   
        System.out.println(Search("t"));
    }
}









