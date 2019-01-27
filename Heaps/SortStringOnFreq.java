 Given a string, sort it in decreasing order based on the frequency of characters.

Example 1:

Input:
"tree"

Output:
"eert"

Explanation:
'e' appears twice while 'r' and 't' both appear once.
So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
Example 2:

Input:
"cccaaa"

Output:
"cccaaa"

class Solution {
    
    ArrayList<Character> Heap = new ArrayList();
    int heapSize = 0;
    
    public String frequencySort(String s) {
        int[] freq = new int[126];
        
       for(int i=0; i<s.length(); i++){
           int ch = s.charAt(i) - 0;
           if(freq[ch] == 0)
               Heap.add(s.charAt(i));
           freq[ch]++;
       }

        heapSize = Heap.size();
        
           for(int i=heapSize/2-1; i>=0; i--){
        	  heapify(freq,i);
          }
        
         StringBuilder sb = new StringBuilder();
          int n = heapSize;
        
         for(int i=0; i<n; i++){
             char c = Heap.get(0);
             int count = freq[c];
             while(count > 0){
                 sb.append(c);
                 count--;
                 }
             Heap.set(0,Heap.get(heapSize-1));
             heapSize--;
             heapify(freq,0);
         }
        return new String(sb);
    }
    
     public void heapify(int[] freq,int i){ 
          int left = 2*i+1;
          int max = i;
          if(left < heapSize && freq[Heap.get(left)] > freq[Heap.get(i)])
          max = left;
          int right = 2*i+2;
          if(right < heapSize && freq[Heap.get(right)] > freq[Heap.get(max)])
           max = right;
           if(max != i){
               char temp = Heap.get(i);
               Heap.set(i,Heap.get(max));
               Heap.set(max,temp);

               heapify(freq,max);
     }
   }
}