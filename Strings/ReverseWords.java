/*  LeetCode : 557. Reverse Words in a String III
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

*/

class Solution {
     String result = "";
    
    public String reverseWords(String s) {
        String tokens[] = s.split(" ");       
        
        for(int i=0; i<tokens.length; i++)
        {
            reverse(tokens[i]);
        }
        
        return result.trim();
    }
    
    public void reverse(String s){
        char rev[] = s.toCharArray();
        int low = 0;
        int high = rev.length-1;
        
          while(low < high){
              char temp = rev[low];
              rev[low] = rev[high];
              rev[high] = temp;
              low++;
              high --;
          }
        result += new String(rev)+" ";
    }
}
