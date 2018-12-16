/*
LeetCode : 
  5. Longest Palindromic Substring
  
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: "cbbd"
Output: "bb"

*/

class Solution {
    public String longestPalindrome(String s) {
        char ch[] = new char[2*s.length()+3];
            s.toCharArray();
        ch[0] = '$';
        ch[1] = '#';
        
        int k=2;
        
         for(int i=0; i<s.length(); i++){
             ch[k++] = s.charAt(i);
             ch[k++] = '#';
         }
        
        ch[k] = '@';
        
        int[] p = new int[ch.length];
        
        int cen =1;
        int right = 1;
        
        for(int i=1; i< ch.length-1; i++){
            
            int left = 2*cen - i;   // find the position of mirror
            
            if(right > i)
                p[i] = Math.min(right-i,p[left]);  // we can update the value of p[i] as we already found a palindrome
            
            while(ch[i+p[i]+1] == ch[i-(p[i]+1)]) // checking for a palindrome
                p[i]++;
            
            if(i+p[i] > right){  // we have found a new left and right boundary, so update the centres
                cen = i;  
                right = i+p[i]; // go till the other half
            }
        }
      
      // Steps below is used to print the longest palindrome
      
           int max = Integer.MIN_VALUE;
            int max_index = -1;
                
           for(int i=0; i<p.length; i++)
               if(p[i] > max){
                   max = p[i];
                   max_index = i;
               }
        
           String result="";
        int i=0,j=0;
        
          if(max% 2 == 0){   // even length palindrome
              i=max_index+1;
              j= max_index-1;
          }
        
          else{  // odd length palindrome
              result+= ch[max_index];
              i = max_index+2;
              j = max_index-2;
              max--;
          }
        
                while(max > 0){
                  result+=ch[i];
                  result = ch[j]+result;
                   i=i+2;
                  j=j-2;
                  max = max-2;
              }
        
        return result;
           
    }
}
