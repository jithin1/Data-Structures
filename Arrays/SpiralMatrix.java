
/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:

Input:
[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
Output: [1,2,3,6,9,8,7,4,5]
Example 2:

Input:
[
  [1, 2, 3, 4],
  [5, 6, 7, 8],
  [9,10,11,12]
]
Output: [1,2,3,4,8,12,11,10,9,5,6,7]
*/

// Intuition
  For matrixes of size 1 to min of (rows,cols)
  
1) Traverse first row from left to right
2) Traverse last column from top to bottom
3) Traverse last row from right to left 
4) traverse first column from bottom to top

Example: 

 [ 1, 2, 3 ],   
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]

For size == 1
     After first traversal we have 1,2,3
     After second traveral we have 1,2,3,6,9
     After third traversal we have 1,2,3,6,9,8,7
     After fourt traversal we have 1,2,3,6,9,8,7,4
 for size == 2
     After first traversal we have 1,2,3,6,9,8,7,4,6
     
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList();
        
        int rows = matrix.length;
        if(rows == 0)
            return result;
        int cols = matrix[0].length;
        
        for(int i=0; i<rows && i<cols;i++){   // matrx of different sizes
            int k = i;
          for(int j=i;j<cols-i && k < rows-i;j++)  // first row 
    // here k ensures that we are not printing the last row, that is there is atleat one
              // row below
            result.add(matrix[k][j]);
             k = cols-i-1;
            for(int j= i+1; j<rows-i && k >= i;j++)  // last column
 // here k ensures that we are always printing the first row of that particular size matrix
                result.add(matrix[j][k]);
             k = rows-i-1;
            for(int j=cols-i-2;j>=i && k > i;j--) // last row
                  // here k ensures that we are not printing the first row
                result.add(matrix[k][j]);
            k =i;
            for(int j=rows-i-2; j>i && k < cols-i-1;j--) // first column 
                        // here k ensures that we are not printing the fiest column
                result.add(matrix[j][k]);
            
        }
        
        return result;
    }
}

