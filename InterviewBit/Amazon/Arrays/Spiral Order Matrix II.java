/*
Given an integer A, generate a square matrix filled with elements from 1 to A2 in spiral order.
Input Format:

The first and the only argument contains an integer, A.
Output Format:

Return a 2-d matrix of size A x A satisfying the spiral order.
Constraints:

1 <= A <= 1000
Examples:

Input 1:
    A = 3

Output 1:
    [   [ 1, 2, 3 ],
        [ 8, 9, 4 ],
        [ 7, 6, 5 ]   ]

Input 2:
    4

Output 2:
    [   [1, 2, 3, 4],
        [12, 13, 14, 5],
        [11, 16, 15, 6],
        [10, 9, 8, 7]   ]
*/

public class Solution {
    public int[][] generateMatrix(int A) {
        int[][] M = new int[A][A];
        int ele = 1;
        
        int firstRow =0,lastRow=A-1,firstCol=0,lastCol=A-1;
        do{
            for(int j=firstCol;j<=lastCol;j++)
                M[firstRow][j] = ele++;
            firstRow++;
            if(firstRow > lastRow)
                break;
            for(int i=firstRow;i<=lastRow;i++)
                M[i][lastCol] = ele++;
            lastCol--;
            if(lastCol<firstCol)
                break;
            for(int j=lastCol;j>=firstCol;j--)
                M[lastRow][j] = ele++;
            lastRow--;
            if(lastRow<firstRow)
                break;
            for(int i=lastRow;i>=firstRow;i--)
                M[i][firstCol] = ele++;
            firstCol++;
        }
        while(firstRow<=lastRow && firstCol<=lastCol);
        return M;
    }
}
