Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

 If possible, output any possible result.  If not possible, return the empty string.

 Example 1:

 Input: S = "aab"
 Output: "aba"

 Example 2:

 Input: S = "aaab"
 Output: ""

 class Solution {
    public String reorganizeString(String S) {
        int length = S.length();
        HashMap<Character,Integer> map = new HashMap();
        char[] result = new char[length];
        for(int i=0; i<length; i++)
            map.put(S.charAt(i),map.getOrDefault(S.charAt(i),0)+1);
        
        Comparator<Character> comp = new Comparator<Character>(){
           public int compare(Character a, Character b){
               return map.get(b) - map.get(a);
           }  
        };
        
        PriorityQueue<Character> heap = new PriorityQueue(length,comp);
        for(char c: map.keySet()){
            heap.offer(c);   // create max heap
        }
  
        int i=0;
          
         char ch = heap.peek();
         if(map.get(ch) > (length+1)/2)  to check if rorganizing is possible
                    return "";    
        
            while(!heap.isEmpty()){
                ch = heap.poll();

                int freq = map.get(ch);
                while(freq > 0){
                    result[i] = ch;
                    i+=2;
                    if(i>=length)  
                        i=1;
                    freq--;
                   
                }               
            }
        return new String(result);
    }
}