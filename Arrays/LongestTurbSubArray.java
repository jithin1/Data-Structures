Longest Turbulent Subarray

 A subarray A[i], A[i+1], ..., A[j] of A is said to be turbulent if and only if:

For i <= k < j, A[k] > A[k+1] when k is odd, and A[k] < A[k+1] when k is even;
OR, for i <= k < j, A[k] > A[k+1] when k is even, and A[k] < A[k+1] when k is odd.
That is, the subarray is turbulent if the comparison sign flips between each adjacent pair of elements in the subarray.

Return the length of a maximum size turbulent subarray of A.

 

Example 1:

Input: [9,4,2,10,7,8,8,1,9]
Output: 5
Explanation: (A[1] > A[2] < A[3] > A[4] < A[5])

class Solution {
    public int maxTurbulenceSize(int[] nums) {
         boolean up = true;
         boolean down = true;
         int max = 1;
         int count =1;
        for(int i=1;i<nums.length; i++){
            if(nums[i] < nums[i-1] && up)
            {   
                up = false;
                down = true;
                count++;
                if(count > max)
                    max = count;
            }
            
            else if(nums[i] > nums[i-1] && down){
                down = false;
                up = true;
                count++;
                if(count > max)
                    max = count;
            }
            
            else{
                count =2;
                if(nums[i] < nums[i-1]){
                    down = true;
                    up=false;
                }
                else if (nums[i] > nums[i-1]){
                    up = true;
                    down = false;
                }
                
                else{
                    count = 1;
                    up=true;
                    down = true;
                }
            }
        }
        
        return max;
    }
}
