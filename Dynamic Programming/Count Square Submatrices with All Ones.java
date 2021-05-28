/*
Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
Example 1:

Input: matrix =
[
  [0,1,1,1],
  [1,1,1,1],
  [0,1,1,1]
]
Output: 15
Explanation: 
There are 10 squares of side 1.
There are 4 squares of side 2.
There is  1 square of side 3.
Total number of squares = 10 + 4 + 1 = 15.
*/

class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length,n = matrix[0].length;
        
        if(m == 1 && n == 1)
            return matrix[0][0];
        int res = 0;
        for(int i = 0;i<m;i++) 
            for(int j = 0;j<n;j++) {
                if(matrix[i][j] == 0)
                    continue;
                if(i == 0 || j == 0) {
                    res += matrix[i][j];
                    continue;
                }
                matrix[i][j] = Math.min(matrix[i-1][j-1],Math.min(matrix[i-1][j],
                                                                 matrix[i][j-1]))+1;
                res += matrix[i][j];
            }
        
        return res;
    }
}
