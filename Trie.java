import java.util.*;

public class Trie{
 
 
 private TrieNode root;
 
 public Trie(ArrayList<String> list){
     root = new TrieNode();
     for(String word: list){
         root.addWord(word);
     }
 }
 
 public boolean contains(String prefix){
     
     return contains(prefix, false);
 }
 
 private boolean contains(String prefix, boolean exact){
     
     TrieNode lastNode = root;
     int i=0;
     for(i=0;i<prefix.length();i++){
         lastNode = lastNode.getChild(prefix.charAt(i));
         if(lastNode == null){
             return false;
         }
     }
     
     return !exact || lastNode.isTerminates();
 }
   class TrieNode{
   
   private char character;
   private HashMap<Character, TrieNode> children;
   private boolean terminates;
   
   public TrieNode(){
       children = new HashMap<Character, TrieNode>();
   }
   
   public TrieNode(char c){
       this();         //Initialise list of empty child nodes for this node
       this.character = c;
     
   }
   
   public char getCharacter(){
       return character;
   }
   
   public void setTerminates(boolean t){
       terminates = t;
   }
   
   public boolean isTerminates(){
       return terminates;
   }
   
   //Find child node that has the char argument as its data
   public TrieNode getChild(char c){
       return children.get(c);
   }
   
   public void addWord(String word){
       
       if(word == null || word.isEmpty() ) return;
       
       char firstChar = word.charAt(0);
       TrieNode child = getChild(firstChar);
       
       if(child == null){
           child = new TrieNode(firstChar);
           children.put(firstChar, child);
       }
       
       if(word.length() > 1){
           child.addWord(word.substring(1));
       }else{
           child.setTerminates(true);
       }
       
   }
   
   }
  
  
 
  
public static void main(String args[]){
    ArrayList<String> myList = new ArrayList<String>();
    myList.add("root");
    myList.add("rooted");
    myList.add("boot");
    myList.add("reboot");
    myList.add("boo");
   Trie t = new Trie( myList);
   boolean prefix = t.contains("reb");
    System.out.println("Valid prefix verdict..." + prefix);
    
    
}

}






    
