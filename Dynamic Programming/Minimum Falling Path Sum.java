/*
Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically,
the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).
*/

class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        if(n == 1)
            return matrix[0][0];
        
        int minPathSum = Integer.MAX_VALUE;
        for(int i =1;i<n;i++) {
            for(int j =0;j<n;j++) {
                if(j == 0)
                    matrix[i][j] += Math.min(matrix[i-1][j],matrix[i-1][j+1]);
                else if(j == n-1)
                    matrix[i][j] += Math.min(matrix[i-1][j-1],matrix[i-1][j]);
                else
                    matrix[i][j] += Math.min(Math.min(matrix[i-1][j-1],matrix[i-1][j]),matrix[i-1][j+1]);
                if(i == n-1)
                    minPathSum = Math.min(minPathSum,matrix[i][j]);
            }
        }
        return minPathSum;
    }
}
