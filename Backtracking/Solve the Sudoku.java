/*
Given an incomplete Sudoku configuration in terms of a 9 x 9  2-D square matrix (grid[][]), the task to find a solved Sudoku. For simplicity, you may assume that 
there will be only one unique solution.
Example 1:

Input:
grid[][] = 
[[3 0 6 5 0 8 4 0 0],
[5 2 0 0 0 0 0 0 0],
[0 8 7 0 0 0 0 3 1 ],
[0 0 3 0 1 0 0 8 0],
[9 0 0 8 6 3 0 0 5],
[0 5 0 0 9 0 6 0 0],
[1 3 0 0 0 0 2 5 0],
[0 0 0 0 0 0 0 7 4],
[0 0 5 2 0 6 3 0 0]]
Output:
3 1 6 5 7 8 4 9 2
5 2 9 1 3 4 7 6 8
4 8 7 6 2 9 5 3 1
2 6 3 4 1 5 9 8 7
9 7 4 8 6 3 1 2 5
8 5 1 7 9 2 6 4 3
1 3 8 9 4 7 2 5 6
6 9 2 3 5 1 8 7 4
7 4 5 2 8 6 3 1 9

Your Task:
You need to complete the two functions:
SolveSudoku(): Takes a grid as its argument and returns true if a solution is possible and false if it is not.
printGrid(): Takes a grid as its argument and prints the 81 numbers of the solved Sudoku in a single line with space separation.
*/

class Solution
{
    //Function to find a solved Sudoku. 
    static boolean SolveSudoku(int grid[][])
    {
        // add your code here
        return helper(grid,0,0);
    }
    
    static boolean helper(int[][] grid, int i, int j) {
        if(i == 9)
            return true;
        if(j == 9)
            return helper(grid,i+1,0);
        if(grid[i][j] != 0)
            return helper(grid,i,j+1);
        for(int k=1;k<=9;k++)
            if(isSafe(grid,i,j,k)) {
                grid[i][j] = k;
                if(helper(grid,i,j+1))
                    return true;
                grid[i][j] = 0;
            }
        return false;
    }
    
    static boolean isSafe (int[][] grid, int i, int j, int num) {
        for(int x=0;x<9;x++)
            if(grid[i][x]==num || grid[x][j]==num)
                return false;

        int sx = (i/3)*3, sy = (j/3)*3;
        for(int x=sx;x<sx+3;x++) 
            for(int y=sy;y<sy+3;y++)
                if(grid[x][y]==num)
                    return false;
        
        return true;
    }
    
    //Function to print grids of the Sudoku.
    static void printGrid (int grid[][])
    {
        // add your code here
        for(int i=0;i<9;i++)
            for(int j=0;j<9;j++)
                System.out.print(grid[i][j]+" ");
    }
}
