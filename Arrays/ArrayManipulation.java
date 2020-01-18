https://www.hackerrank.com/challenges/crush/problem

rting with a 1-indexed array of zeros and a list of operations, for each operation add a value to each of the array element between two
given indices, inclusive. Once all operations have been performed, return the maximum value in your array.

For example, the length of your array of zeros . Your list of queries is as follows:

    a b k
    1 5 3
    4 8 7
    6 9 1
    
    Add the values of  between the indices  and  inclusive:

index->	 1 2 3  4  5 6 7 8 9 10
	[0,0,0, 0, 0,0,0,0,0, 0]
	[3,3,3, 3, 3,0,0,0,0, 0]
	[3,3,3,10,10,7,7,7,0, 0]
	[3,3,3,10,10,8,8,8,1, 0]
  
  Output : 10
  
  
  static long arrayManipulation(int n, int[][] q) {
        int[] val = new int[n+1];

        for(int i=0; i<q.length; i++){
           val[q[i][0]] += q[i][2];
            int ind = q[i][1]+1;
            if (ind < n+1) 
            val[ind]-= q[i][2];
        }
          
          long sum = 0;
          long ans = 0;
        for(int i=1; i<n+1; i++){
          sum+=val[i];
          ans = Math.max(ans,sum);
        }
        return ans;
    }
