import java.util.*;
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
    static  Node root = new Node();

    public static  boolean search(String key){
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
    public static boolean startsWith(String[] words,String prefix){
        Node curr = root;
        for(int i=0; i<prefix.length(); i++){
            int idx = prefix.charAt(i)-'a';
            if(curr.children[idx]==null){
                return false;
            }
            curr = curr.children[idx];    
        }
        return true;
    }   
    public static void insert(String words){
        Node currNode = root;
        for(int i=0; i < words.length(); i++){
            int idx = words.charAt(i)-'a';
            if (currNode.children[idx]==null){
                currNode.children[idx] = new Node();
            }
            currNode = currNode.children[idx];
        }
        currNode.eow = true;
    }
    public static  boolean WordBreak(String Key){
        if (Key.length()==0){
            return true;
        }
        for(int i=1; i<=Key.length(); i++){
            String firstWord =  Key.substring(0, i) ;
            String SecondWord = Key.substring(i);
            if (search(firstWord) && WordBreak(SecondWord)){
                return true;
            }
        }
        return false;
    }
  
    public static void main(String[] args){
        // String[] StringOfWords  = {"i", "like", "sam", "samsung", "mobile", "ice"};
        // String key = "ilikesam";
        // for(int i=0; i<StringOfWords.length; i++){
        //     insert(StringOfWords[i]);
        // }
        // System.out.println(WordBreak(key));
        String words[] = {"apple", "app","mango", "man", "woman"};
        String prefix="moon";
        for(int i=0; i<words.length; i++){
            insert(words[i]);
        }
        System.out.println(startsWith(words,prefix ));
    }
}









