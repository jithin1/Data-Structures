import java.util.*;


class Solution {
      public void heapify(int[] nums, int n){
    	 
          for(int i=n/2-1; i>=0; i--){
        	  System.out.println(Arrays.toString(nums));
        	  heapify(nums,i,n);
          }
      }
      
      public void heapify(int[] nums,int i,int size){
          int left = 2*i+1;
          int max = i;
          if(left < size && nums[left] > nums[i])
          max = left;
          int right = 2*i+2;
          if(right < size && nums[right] > nums[max])
           max = right;
           if(max != i){
               int temp = nums[i];
               nums[i] = nums[max];
               nums[max] = temp;
               heapify(nums,max,size);
           }
      }

      public int extractMax(int [] nums,int n){   
    	  
    	   int max = nums[0];
    	  nums[0] = nums[n-1];
    	  n--;
    	  heapify(nums,n);
    	  return max;
      }

   public void decreaseKey()  // use above logic

  public void increaseKey()
  {
   // go to parent go up
  }

       
     public static void main (String[] args) {
        Solution mh = new Solution();
        int []nums = {3,11,2,9,2,3,8,0,12,1};
        mh.heapify(nums,10);
        System.out.println(Arrays.toString(nums));
        
    }

}