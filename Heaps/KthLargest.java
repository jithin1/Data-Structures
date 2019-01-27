Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Your KthLargest class will have a constructor which accepts an integer k and an integer array nums, which contains initial elements from the stream. For each call to the method KthLargest.add, return the
 element representing the kth largest element in the stream.

Example:

int k = 3;
int[] arr = [4,5,8,2];
KthLargest kthLargest = new KthLargest(3, arr);
kthLargest.add(3);   // returns 4
kthLargest.add(5);   // returns 5
kthLargest.add(10);  // returns 5
kthLargest.add(9);   // returns 8
kthLargest.add(4);   // returns 8


   2) class KthLargest {
      int[] minHeap;
    
    public KthLargest(int k, int[] nums) {
       minHeap = new int[k];
        
        for(int i=0; i<k; i++){
            if(i<nums.length){
                minHeap[i] = nums[i];
            }else{
                minHeap[i] = Integer.MIN_VALUE;
            }
        }
        
        for(int i=(int)Math.floor(k/2); i>=0; i--){   / / even k/2 -1 work
            minHeapify(minHeap, i);
        }
        
        for(int i=k; i<nums.length; i++){
            if(nums[i]>minHeap[0]){
                minHeap[0] = nums[i];
                minHeapify(minHeap, 0);
            }
        }
    }
    
    public int add(int val) {
        if(val > minHeap[0]){
            minHeap[0] = val;
            minHeapify(minHeap, 0);
        }
        
        return minHeap[0];
    }
    
    private void minHeapify(int[] heap, int i){
        int l = 2*i+1;
        int r = 2*i+2;
        
        int small = i;
        
        if(l<heap.length && heap[i]>heap[l]){
            small = l;
        }
        
        if(r<heap.length && heap[small]>heap[r]){
            small = r;
        }
        
        if(small != i){
            int temp = heap[i];
            heap[i] = heap[small];
            heap[small] = temp;
            
            minHeapify(minHeap, small);
        }
    }

}