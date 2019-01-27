You are given two integer arrays nums1 and nums2 sorted in ascending order and an integer k.

 Define a pair (u,v) which consists of one element from the first array and one element from the second array.

 Find the k pairs (u1,v1),(u2,v2) ...(uk,vk) with the smallest sums.

Example 1:

Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]] 
Explanation: The first 3 pairs are returned from the sequence: 
             [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]


class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        List<int[]>result = new ArrayList();
         int length1 = nums1.length;
         int length2 = nums2.length;
        
        if(length1 == 0 || length2 == 0)
            return result;
        
        Comparator<int[]> comp= new Comparator<int[]>(){

             public int compare(int[] a, int[] b){
                 return (a[0]+a[1]) - (b[0]+b[1]);
             }

         }; 
        
        PriorityQueue<int[]> heap = new PriorityQueue(k,comp);
        
        for(int i=0; i<nums1.length && i<k; i++){
            int temp[] = {nums1[i],nums2[0],0};
            heap.offer(temp);
        }
        
        int size = k;
        
        while(size > 0 && !heap.isEmpty()){
            int[] temp = heap.poll(); 
            int[] ans = {temp[0],temp[1]};
            result.add(ans);
            size--;
            int next= temp[2];
            
            if(next == nums2.length-1)
                continue;
            
            next++;
            temp[1] = nums2[next];
            temp[2] = next;
            heap.offer(temp);
            
        }
        
        return result;
    }
}