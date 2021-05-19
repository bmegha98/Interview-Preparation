//Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.

class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        if(m == 1 && n == 1)
            return matrix[0][0] == '0'?0:1;
        
        int[][] T = new int[301][301];
        int maxSize = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(i == 0 || j == 0)
                    T[i][j] = matrix[i][j] == '0'?0:1;
                else if(matrix[i][j] == '0')
                    T[i][j] = 0;
                else
                    T[i][j] = 1+Math.min(T[i][j-1], Math.min(T[i-1][j], T[i-1][j-1]));
                maxSize = Math.max(maxSize, T[i][j]);
            }
        }
        
        return maxSize*maxSize;
    }
}
