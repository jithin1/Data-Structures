You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Note:

You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and
do the rotation.

Example 1:

Given input matrix = 
[
  [1,2,3],
  [4,5,6],
  [7,8,9]
],

rotate the input matrix in-place such that it becomes:
[
  [7,4,1],
  [8,5,2],
  [9,6,3]
]

 class Solution {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        if(length == 0)
            return;
        for(int i=0;i<length-1;i++){
            int j = i;
            int k= length-i-1;
            while(j < length-i-1){
                int temp = matrix[j][k];
                matrix[j][k] = matrix[i][j];
                matrix[i][j] = temp;
                temp = matrix[k][length-j-1];
                matrix[k][length-j-1] = matrix[i][j];
                matrix[i][j] = temp;
                temp = matrix[length-j-1][i];
                matrix[length-j-1][i] = matrix[i][j];
                matrix[i][j] = temp;                    
              j++;
            }
        }
    }
}
