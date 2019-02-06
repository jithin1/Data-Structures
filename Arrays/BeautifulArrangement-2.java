 Beautiful Arrangement II
 
  Given two integers n and k, you need to construct a list which contains n different positive integers ranging from 1 to n and obeys the 
  following requirement: 
Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|, |a3 - a4|, ... , |an-1 - an|] has exactly k distinct 
integers.

If there are multiple answers, print any of them.

Example 1:
Input: n = 3, k = 1
Output: [1, 2, 3]
Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3, and the [1, 1] has exactly 1 distinct integer: 1.

class Solution {
     int low;
     int high;
    int[] result;
    public int[] constructArray(int n, int k) {
        high = k;
        int[] nums = new int[n];
        result = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = i+1;
        findArray(nums,k);
             int ind = k;
          if(low == high)   // odd number of instances
              result[k++] = nums[low];
         high = ind+1;
        while(high < n)  // add all numbers greater than high to get a difference of one
            result[high] = nums[high++];
        return result;
    }
    
    public void findArray(int[] nums,int k){
      
        int j=0;
        while(j < k){
            result[j++] = nums[low++];  // swap till we reach k
            result[j++] = nums[high--];
        }
    }
}
