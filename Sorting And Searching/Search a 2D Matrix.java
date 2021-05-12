/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 1 && n == 1)
            return matrix[0][0] == target;
        
        int i = 0,j = n-1;
        while(i < m && j >= 0) {
            if(matrix[i][j] == target)
                return true;
            if(matrix[i][j] > target)
                j--;
            else
                i++;
        }
        return false;
    }
}
