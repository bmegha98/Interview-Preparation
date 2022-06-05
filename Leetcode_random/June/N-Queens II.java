/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return the number of distinct solutions to the n-queens puzzle.

 

Example 1:


Input: n = 4
Output: 2
Explanation: There are two distinct solutions to the 4-queens puzzle as shown.
Example 2:

Input: n = 1
Output: 1
 

Constraints:

1 <= n <= 9
*/

class Solution {
    int count = 0;
    char[][] board;
    public int totalNQueens(int n) {
        board = new char[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(board[i], '.');
        
        helper(0,n);
        return count;
    }
    
    private void helper(int start, int n) {
        if(start == n) {
            count++;
            return;
        }
        
        for(int i=0;i<n;i++) 
            if(safeToPlaceQueen(i,start,n)) {
                board[i][start] = 'Q';
                helper(start+1,n);
                board[i][start] = '.';
            }
    }
    
    private boolean safeToPlaceQueen(int r, int c, int n) {
        //check in same row
        for(int i=0;i<c;i++) 
            if(board[r][i] == 'Q')
                return false;
        
        //check upper diagonal
        int i=r, j = c;
        while(i>=0 && j >= 0) {
            if(board[i][j] == 'Q')
                return false;
            i--;
            j--;
        }
        
        //check lower diagonal
        i = r;
        j = c;
        while(i<n && j>=0) {
            if(board[i][j] == 'Q')
                return false;
            i++;
            j--;
        }
        return true;
    }
}
