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

//Time = O(logn)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        if(m == 1 && n == 1)
            return matrix[0][0] == target;
        
        for(int i=0;i<m;i++) {
            int[] A = matrix[i];
            if(target >= A[0] && target <= A[n-1])
                return binarySearch(A,n,target);
        }
        return false;
    }
    
    private boolean binarySearch(int[] A,int n,int ele) {
        int l = 0, h = n-1;
        while(l <= h) {
            int m = l+(h-l)/2;
            if(A[m] == ele)
                return true;
            if(A[m] < ele)
                l = m+1;
            else
                h = m-1;
        }
        return false;
    }
}
