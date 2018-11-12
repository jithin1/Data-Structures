/*
LeetCode : 667 Palindromic Substrings

 Given a string, your task is to count how many palindromic substrings in this string.

The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.

Example 1:

Input: "abc"
Output: 3
Explanation: Three palindromic strings: "a", "b", "c".

Example 2:

Input: "aaa"
Output: 6
Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
*/

class Solution {
    public int countSubstrings(String s) {
        char a[] = s.toCharArray();
        int count =0;
        for(int i=1; i<a.length; i++){
            int low = i-1;
            int high =i;
            
            while(low>=0 && high < s.length()){
                if(a[low] == a[high]){
                    count ++;
                    low--;
                    high++;
                }
                else
                    break;
            }
           low = i-1;
           high = i+1;
            
            while(low >=0 && high < s.length()){
                if(a[low] == a[high]){
                    count ++;
                    low--;
                    high++;
                }
                
                else
                    break;
            }
            
        }
        
        count += s.length();
        
        return count;
    }
}

  Time complexity is O(n*n)
