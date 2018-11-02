/*
LeetCode : 771. Jewels and Stones

You're given strings J representing the types of stones that are jewels, and S representing the stones you have.  Each character in S is a type of stone you have.  You want to know how many of the stones you have are also jewels.

The letters in J are guaranteed distinct, and all characters in J and S are letters. Letters are case sensitive, so "a" is considered a different type of stone from "A".

Example 1:

Input: J = "aA", S = "aAAbbbb"
Output: 3
*/

class Solution {
    public int numJewelsInStones(String J, String S) {
        
        char[] j = J.toCharArray();
        HashSet<Character> hs = new HashSet<Character>();
        
        for(int i=0; i < j.length; i++)
            hs.add(j[i]);
        
        
        int count = 0;
        
        char s[] = S.toCharArray();
        
        for(int i=0; i < s.length; i++)
            if(hs.contains(s[i]))
            count++;
        
         return count;
    }
}
