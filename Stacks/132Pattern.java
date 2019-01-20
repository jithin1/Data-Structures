  /* 
  
 132 pattern

Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k and ai < ak < aj. Design 
an algorithm that takes a list of n numbers as input and checks whether there is a 132 pattern in the list.

Note: n will be less than 15,000.

Example 1:
Input: [1, 2, 3, 4]

Output: False

Explanation: There is no 132 pattern in the sequence.

Example 2:
Input: [3, 1, 4, 2]

Output: True

Explanation: There is a 132 pattern in the sequence: [1, 4, 2].

*/

  class Solution {
    public boolean find132pattern(int[] nums) {
       int length = nums.length;
         if(length < 3)
             return false;
        
       int[] min = new int[length];
        min[0] = nums[0];
        
       for(int i=1; i<length; i++)
            min[i] = Math.min(nums[i],min[i-1]);
        
        Stack<Integer> st = new Stack();
       
        
        for(int i=length-1; i>=0; i--){
            if(nums[i] > min[i]){
                if(st.isEmpty())
                    st.push(nums[i]);
                else if(nums[i] <= st.peek())
                    st.push(nums[i]);
                else{
                    while(!st.isEmpty() && st.peek() <= min[i])
                        st.pop();
                    if(!st.isEmpty())
                        return true;
                }
                
            }
            
        }
        
        return false;
    }
}
