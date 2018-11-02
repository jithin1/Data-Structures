/*
Leetcode - 611 Valid Triangle number.
Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that can make 
triangles if we take them as side lengths of a triangle.

Example 1:

Input: [2,2,3,4]
Output: 3
Explanation:
Valid combinations are: 
2,3,4 (using the first 2)
2,3,4 (using the second 2)
2,2,3

*/

// Sort the array
// If sum of smaller 2 sides is greater than the larger side, then the triangle is possible
// i - 1st pointer; j- 2nd pointer; k - 3rd pointer
 
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);  to sort the array
        int j=0; 2nd pointer
        int count = 0;   // to store the number of triangles
        
        for(int i=0; i< nums.length-2; i++){
             j= i+1;
            
            for(int k=j+1; k < nums.length;){
                
                if(nums[i]+nums[j] > nums[k]){
                   count++; 
                   k++;
                   
                   if(k == nums.length && j< nums.length-2){  // to increment 2nd pointer once the 3rd pointer reaches end of the array
                     j++;
                     k = j+1;
                   }
                    
                }
                
            else{
                j++;  // increment 2nd pointer
                k=j+1; // 3rd pointer starts from j+1
            }
        }
    }       
        
        return count;
    }
    
} 


// Time complexity O(n2)
