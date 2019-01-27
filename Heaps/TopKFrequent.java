Top K Frequent Elements

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

  class Solution {
    
    int[] Heap;
    int heapSize = 0;
      
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result= new ArrayList();
        HashMap<Integer,Integer> freq = new HashMap();
        
       for(int i=0; i<nums.length; i++){
           int val = freq.getOrDefault(nums[i],0)+1;
           freq.put(nums[i],val);
       }
          
        heapSize = freq.size();
        Heap = new int[heapSize];
        
         int itr = 0;
        for(int i : freq.keySet())
            Heap[itr++] = i;
            
           for(int i=heapSize/2-1; i>=0; i--)
        	  heapify(freq,i);
          
        
          int n = heapSize;
        
         for(int i=0; i<k; i++){
             result.add(Heap[0]);
             Heap[0] = Heap[heapSize-1];
             heapSize--;
             heapify(freq,0);
         }
        return result;
    }
    
     public void heapify(HashMap<Integer,Integer> freq,int i){ 
          int left = 2*i+1;
          int max = i;
          if(left < heapSize && freq.get(Heap[left]) > freq.get(Heap[i]) )
          max = left;
          int right = 2*i+2;
          if(right < heapSize && freq.get(Heap[right]) > freq.get(Heap[max]) )
           max = right;
           if(max != i){
               int temp = Heap[i];
               Heap[i] = Heap[max];
               Heap[max] = temp;
               heapify(freq,max);
     }
   }

}