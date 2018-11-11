/*
Given a list of positive integers, the adjacent integers will perform the float division. For example, [2,3,4] -> 2 / 3 / 4.

However, you can add any number of parenthesis at any position to change the priority of operations. You should find out how to add 
parenthesis to get the maximum result, and return the corresponding expression in string format. Your expression should NOT contain 
redundant parenthesis.

Example:

Input: [1000,100,10,2]
Output: "1000/(100/10/2)"
Explanation:
1000/(100/10/2) = 1000/((100/10)/2) = 200
However, the bold parenthesis in "1000/((100/10)/2)" are redundant, 
since they don't influence the operation priority. So you should return "1000/(100/10/2)". 

Other cases:
1000/(100/10)/2 = 50
1000/(100/(10/2)) = 50
1000/100/10/2 = 0.5
1000/100/(10/2) = 2
*/

 // Solution Max of a/b/c/d/e/f/g = a/(b/c/d/e/f/g)
 
class Solution {
      double[] temp;
    public String optimalDivision(int[] nums) {
        
           if(nums.length ==2)
               return ""+nums[0]+"/"+nums[1];
        
          if(nums.length == 1)
              return ""+nums[0];
        
                 String s = "";
        int k=0;
        
            s += nums[k++]+"/";  
              s += "(";
        
          while(k < nums.length)
              s += nums[k++]+"/";
        
           s= s.substring(0,s.length()-1);
              s+= ")";
        
        return s;
        
    }   
    
}
