
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

Note: The algorithm should run in linear time and in O(1) space.

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList();
        int lim = nums.length/3;
       int candA = 0, candB = 0;
       int countA = 0,countB = 0;
        
        for(int i=0; i<nums.length; i++){
            if((countA == 0 && nums[i] != candB) || (nums[i] == candA)){
                if(countA == 0)
                    candA = nums[i];
                countA++;
            }
            else if(countB == 0 || nums[i] == candB){
                if(countB == 0)
                    candB = nums[i];
                countB++;
            }
            else{
                countA--;
                countB--;
            }
        }
        
         countA =0; countB = 0;
        
        for(int n: nums){
            if(n == candA)
                countA++;
            else if(n == candB)
                countB++;
        }
        
        if(countA > lim)
            result.add(candA);
        if(countB > lim)
            result.add(candB);
        
        return result;
    }
}
