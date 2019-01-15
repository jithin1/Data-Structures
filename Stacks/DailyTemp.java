/*
Daily Temperatures : 

Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait
until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

*/

class Solution {
    public int[] dailyTemperatures(int[] T) {
    int length = T.length;
      int[] result = new int[length];
        int max = 29;
      Stack<Integer> st = new Stack();
        
     for(int i=length-1; i>=0; i--){
        int val = T[i];
         
         if(T[i] < max)
         while(!st.isEmpty()){
             if(T[st.peek()] > val){
                 result[i] = st.peek()-i;
                 st.push(i);
                 break;
             }
             else
                 st.pop();
         }
         
          else{
              st.clear();
              st.push(i);
              max = T[i];
              result[i] = 0;
          }
         
     }
        
        return result;
        
    }
}
