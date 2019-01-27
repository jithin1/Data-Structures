Write a program to find the nth super ugly number.

  Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k.

  Example:

 Input: n = 12, primes = [2,7,13,19]
 Output: 32 

Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first 12 
             super ugly numbers given primes = [2,7,13,19] of size 4.

 Intuition: Use min heap to store the next smallest value

  class Solution {
    
    public int nthSuperUglyNumber(int n, int[] primes) {
        
        Comparator<int[]> comp= new Comparator<int[]>(){

             public int compare(int[] a, int[] b){
                 return a[0] - b[0];
             }

         }; 
        
        PriorityQueue<int[]> heap = new PriorityQueue(n,comp);     
        int[] dp = new int[n+1];
         dp[1] = 1;
         for(int i=0; i<primes.length; i++){
             int[] temp = {primes[i],primes[i],1};
           heap.offer(temp);
         }
                   
        for(int i=2; i<=n; i++){
             int[] min = heap.poll();
              
              dp[i] = min[0];
              
            while(!heap.isEmpty() && heap.peek()[0] == min[0]){   // To remove duplicates. 
            	int[] dup = heap.poll();
            	 dup[2]++;
                 dup[0]  = dp[dup[2]]*dup[1]; we might miss something. For ex 27 is from 9*3  21 = 3*7 or  7*3. If we loose 21 due to 7*3 we will not get 27. See below test case. 
                 heap.offer(dup);
                
            }    
        
            min[2]++;
            min[0]  = dp[min[2]]*min[1];
            
            heap.offer(min);
        
      }     
      return dp[n]; 
     
    }    
 }

15
[3,5,7,11,19,23,29,41,43,47]
