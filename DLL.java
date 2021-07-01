import java.util.*;

public class DLL{
    
    static class Node{
        
        private int data;
        private Node next;
        private Node prev;
        
        Node(int val){
            this.data = val;
            this.next = null;
            this.prev = null;
        }
    }
    
    Node head;
    
    public static DLL insert(DLL list,int val){
        Node newNode = new Node(val);
       
        
        if(list.head == null){
            list.head = newNode;
        }
        
       else{
            Node curr = list.head;
           while(curr.next != null){
           curr = curr.next;
        }
       
        
        curr.next = newNode;
        newNode.prev = curr;
        newNode.next = null;
        
        
       }
       return list;
        
    }
    
    
    public static void printList(DLL list){
        Node tail = null;
        if(list.head == null){
            System.out.println("List is empty...");
        }
        else{
            Node curr = list.head;
            while(curr.next != null){
                tail = curr;
                System.out.println(curr.data + " ");
                curr = curr.next;
            }
            
              System.out.println("In reverse" + "\n");
            while(tail.prev != null){
              
                System.out.println(tail.data + " ");
                tail = tail.prev;
            }
             System.out.println(tail.data );
        }
    }
    
    public static DLL deleteVal(DLL list, int key){
      // Store head node
        Node currNode = list.head;
 
        //
        // CASE 1:
        // If head node itself holds the key to be deleted
 
        if (currNode != null && currNode.data == key) {
            list.head = currNode.next; // Changed head
            list.head.prev = null;
 
            // Display the message
            System.out.println(key + " found and deleted");
 
            // Return the updated List
            return list;
        }
 
        //
        // CASE 2:
        // If the key is somewhere other than at head
        //
 
        // Search for the key to be deleted,
        // keep track of the previous node
        // as it is needed to change currNode.next
        while (currNode != null && currNode.data != key) {
            // If currNode does not hold key
            // continue to next node
         
            currNode = currNode.next;
        }
 
        // If the key was present, it should be at currNode
        // Therefore the currNode shall not be null
        if (currNode != null) {
            // Since the key is at currNode
            // Unlink currNode from linked list
        
            Node prev = currNode.prev;
            
            prev.next = currNode.next;
            currNode.next.prev = prev;
            
            
            // Display the message
            System.out.println(key + " found and deleted");
        }
 
        //
        // CASE 3: The key is not present
        //
 
        // If key was not present in linked list
        // currNode should be null
        if (currNode == null) {
            // Display the message
            System.out.println(key + " not found");
        }
 
        // return the List
        return list;
 
    }

  
 
  
public static void main(String args[]){
    /* Start with the empty list. */
        DLL list = new DLL();
 
        //
        // ******INSERTION******
        //
 
        // Insert the values
        list = insert(list, 1);
        list = insert(list, 2);
        list = insert(list, 3);
        list = insert(list, 4);
        list = insert(list, 5);
        list = insert(list, 6);
        list = insert(list, 7);
        list = insert(list, 8);
 
        // Print the LinkedList
        printList(list);
        
        list = deleteVal(list,5);

        
        printList(list);
        
 
    
    
}

}






    
