/*Write an efficient algorithm that searches for a target value in an m x n integer matrix. The matrix has the following properties:

Integers in each row are sorted in ascending from left to right.
Integers in each column are sorted in ascending from top to bottom.
*/

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        
        int i = m-1,j = 0;
        while(i >= 0 && j < n) {
            if(matrix[i][j] == target)
                return true;
            if(matrix[i][j] > target)
                i--;
            else
                j++;
        }
        return false;
    }
}
