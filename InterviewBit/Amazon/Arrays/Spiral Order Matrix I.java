/*
Given a matrix of m * n elements (m rows, n columns), return all elements of the matrix in spiral order.
Example:

Given the following matrix:

[
    [ 1, 2, 3 ],
    [ 4, 5, 6 ],
    [ 7, 8, 9 ]
]
You should return

[1, 2, 3, 6, 9, 8, 7, 4, 5]
*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] spiralOrder(final int[][] A) {
        int m = A.length, n = A[0].length;
        int[] res = new int[m*n];
        int k = 0;
        
        int firstRow = 0,lastRow = m-1, firstCol = 0, lastCol = n-1;
        do{
            for(int i=firstCol;i<=lastCol;i++)
                res[k++] = A[firstRow][i];
            
            firstRow++;
            if(firstRow > lastRow)
                break;
            for(int j=firstRow;j<=lastRow;j++)
                res[k++] = A[j][lastCol];
            lastCol--;
            if(lastCol < firstCol)
                break;
            for(int i=lastCol;i>=firstCol;i--)
                res[k++] = A[lastRow][i];
            lastRow--;
            if(lastRow<firstRow)
                break;
            for(int j=lastRow;j>=firstRow;j--)
                res[k++] = A[j][firstCol];
            firstCol++;
        }
        while(firstRow <= lastRow && firstCol <= lastCol);
        return res;
    }
}
