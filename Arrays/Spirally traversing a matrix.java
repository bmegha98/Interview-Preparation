/*
Given a matrix of size r*c. Traverse the matrix in spiral form.

Example 1:

Input:
r = 4, c = 4
matrix[][] = {{1, 2, 3, 4},
           {5, 6, 7, 8},
           {9, 10, 11, 12},
           {13, 14, 15,16}}
Output: 
1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
*/

class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        ArrayList<Integer> res = new ArrayList<>();
        int firstRow = 0, firstCol = 0, lastRow = r-1, lastCol = c-1;
        do {
            for(int j=firstCol;j<=lastCol;j++)
                res.add(matrix[firstRow][j]);
            firstRow++;
            if(firstRow > lastRow)
                break;
            for(int i=firstRow;i<=lastRow;i++)
                res.add(matrix[i][lastCol]);
            lastCol--;
            if(firstCol > lastCol)
                break;
            for(int j=lastCol;j>=firstCol;j--)
                res.add(matrix[lastRow][j]);
            lastRow--;
            if(firstRow > lastRow)
                break;
            for(int i=lastRow;i>=firstRow;i--)
                res.add(matrix[i][firstCol]);
            firstCol++;
        }
        while(firstRow<=lastRow && firstCol<=lastCol);
        return res;
    }
}
