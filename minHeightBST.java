import java.util.*;

public class TreeNode{
  
  private int n;
  private TreeNode left;
  private TreeNode right;
  
  public TreeNode(int n){
      this.n = n;
      left = null;
      right = null;
  }
  
  public TreeNode createMinBST(int[] array){
      return createMinBST(array, 0, array.length-1);
  }
  
  private TreeNode createMinBST(int[] array, int start, int end){
      
      if(end < start){
          return null;
      }
      int mid = (start + end) / 2;
      TreeNode n = new TreeNode(array[mid]);
      n.left = createMinBST(array, start, mid-1);
      n.right  = createMinBST(array, mid +1, end);
      return n;
      
  }
  
  
public static void main(String args[]){
    TreeNode t = new TreeNode(6);
    int[] arr = new int[]{2,3,6,8,55,66,88,888};
    t.createMinBST(arr);
    System.out.println(t.createMinBST(arr).n);
    
}

}






    
