/*
  Leetcode 1) Two Sum
  
 Given an array of integers, return indices of the two numbers such that they add up to a specific target.

 You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1]

*/
//  Binary seach to solve the problem 
// Time complexity = O(nlogn)

class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] temp = new int[nums.length];
        for(int i=0; i<nums.length; i++)
         temp[i] = nums[i];
         
         Arrays.sort(temp);  // sort the temporary array as to perform binary search later
        
        int end = nums.length-1;
         int r1 = 0; int r2 = 0;
        
        for(int i=0; i<end; i++){
            int mid = findSum(temp,i,i+1,end,target);
            if(mid == -1)  // position not found yet
                continue;
            else{
                r1 = i;    // store the indices
                r2 = mid;
                break;
               }
            }  
          int val1 = temp[r1];
          int val2 = temp[r2];
          
          
         int[] result = new int[2];
         int k=0;          // to iterate the result array
         
         for(int i=0; i<nums.length; i++)
          if(val1 == nums[i] || val2 == nums[i])
           {
               result[k++] = i;
           }
           
           return result;  
    }
    
    public int findSum(int[] a, int p1,int str, int end, int target){   // ninary Search takes O(logn) time
        if(str > end)
            return -1;
        
        int mid = (str+end)/2;
        
        if(a[p1]+a[mid] == target )
            return mid;
        
        else if(a[p1] + a[mid] < target)
            return findSum(a,p1,mid+1,end,target);  // search the right sub array
        
        else
            return findSum(a,p1,str,mid-1,target);   // search the left sub array
             
    }
    

}
