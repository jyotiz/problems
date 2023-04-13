// Online Java Compiler
// Use this editor to write, compile and run your Java code online
import java.util.*;
public class HelloWorld {
  /* Online Java Compiler and Editor */

 
    
    public boolean checkRemainIng(int[] arr,   HashSet<Integer> set, int sum, int index){
        int sum2 = 0;
        for(int j = 0; j < arr.length; j++){
            if( !set.contains(j) && j != index){
                sum2 += arr[j];
                set.add(j);
                 System.out.println("sum2 is .... " + sum2);
                if(sum2 == sum && set.size() == arr.length - 1){
                    return true;
                }
            }
            
        }
        return false;
    }
    
    public boolean checkEqual(int[] arr, int index){
        System.out.println("Skipping index.... " + index);
        int sum1 = 0;
        int sum = 0;
        for(int i  = 0; i < arr.length ; i++){
              if( i != index){
            sum += arr[i];
              }
        }
        if( sum % 2 != 0) return false;

        sum = sum / 2;

        HashSet<Integer> set= new HashSet<>();
        for(int i  = 0; i < arr.length; i++){
            if( i != index){
            sum1 += arr[i];
            set.add(i);
             System.out.println("sum1 is .... " + sum1);
            if( sum1 == sum ){
               boolean ans =  checkRemainIng(arr, set, sum, index);
                 System.out.println("ans is .... " + ans);
               if( ans ) return true;
            } 
          
            }
        }
        
        return false;
        
        
    }
    
    public boolean isPossible(int[] weights){
        boolean result = false;
        for(int i = 0; i < weights.length; i++){
            result =  checkEqual(weights, i);
            if( result){
                return result;
            }
        }
        return result;
        
    }
    

     public static void main(String []args){
         HelloWorld obj = new HelloWorld();
         int[] input = new int[]{1,1,6,7,2,1,5};
         boolean sol = obj.isPossible(input);
         System.out.println("Answer is " + sol);
     }

}