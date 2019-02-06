Array Nesting

A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], 
A[A[i]], A[A[A[i]]], ... } subjected to the rule below.

Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then 
A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.

 

Example 1:

Input: A = [5,4,0,3,1,6,2]
Output: 4
Explanation: 
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}

class Solution {
    public int arrayNesting(int[] nums) {
        int max = 0;
       for(int i=0; i<nums.length; i++){
           if(nums[i] < 0)  // already visited
               continue;
           else {
               int count = 1;
                   int j = nums[i];
               nums[i] = -1; // visited
               while( nums[j] >= 0){
                   count++;
                   int ind =nums[j];
                   nums[j] = -1;
                   j = ind;
               }
               
               if(nums[j] != -1)  //have an existing link
                   nums[i] = count+Math.abs(nums[j]);
               else
               nums[i] = count;
               
               if(nums[i] > max)
                   max = nums[i]; 
               nums[i] = -nums[i]; // already visited with updated path
           }
       }
        
        return max;
    }
}
