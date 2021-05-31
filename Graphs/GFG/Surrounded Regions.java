/*
Given an m x n matrix board containing 'X' and 'O', capture all regions surrounded by 'X'.
A region is captured by flipping all 'O's into 'X's in that surrounded region.
Example :
Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]
Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]
Explanation: Surrounded regions should not be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the
border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or
vertically.
*/

//Applying DFS twice
class Solution {
    int[] ROW = {-1,0,0,1};
    int[] COL = {0,-1,1,0};
    boolean shouldFlip;
    public void solve(char[][] board) {
        int m = board.length,n = board[0].length;
        if(m == 1 || n == 1)
            return;
        
        boolean[][] visited = new boolean[m][n];
        for(int i= 1;i<m-1;i++) {
            for(int j= 1;j<n-1;j++) {
                if(board[i][j] == 'O' && !visited[i][j]) {
                    shouldFlip = true;
                    checkRegion(board,visited,i,j,m,n);
                   // System.out.println(shouldFlip);
                    if(shouldFlip)
                        flipRegion(board,i,j,m,n);
                }
            }
        }
    }
    
    private void checkRegion(char[][] B, boolean[][] V,int r, int c, int m, int n) {
        V[r][c] = true;
        if(r == 0 || r == m-1 || c == 0 || c == n-1) {
            shouldFlip = false;
            return;
        }
        for(int i=0;i<4;i++) {
            int newR = r+ROW[i], newC = c+COL[i];
            if(newR >= 0 && newR < m && newC >= 0 && newC < n && B[newR][newC] == 'O'
                && !V[newR][newC])
                checkRegion(B,V,newR,newC,m,n);
        }
    }
    
    private void flipRegion(char[][] B, int r, int c, int m, int n) {
        B[r][c] = 'X';
        for(int i=0;i<4;i++) {
            int newR = r+ROW[i], newC = c+COL[i];
            if(newR >= 0 && newR < m && newC >= 0 && newC < n && B[newR][newC] == 'O') 
                flipRegion(B,newR,newC,m,n);
        } 
    }
}

//DFS at corner Os
class Solution {
    int[] ROW = {-1,0,0,1};
    int[] COL = {0,-1,1,0};
    boolean shouldFlip;
    public void solve(char[][] board) {
        int m = board.length,n = board[0].length;
        if(m == 1 || n == 1)
            return;
        
        for(int i= 0;i<m;i++) { 
            if(board[i][0] == 'O')
                dfs(board,i,0,m,n);
            if(board[i][n-1] == 'O')
                dfs(board,i,n-1,m,n);
        }
        
        for(int j= 0;j<n;j++) {
            if(board[0][j] == 'O')
                dfs(board,0,j,m,n);
            if(board[m-1][j] == 'O')
                dfs(board,m-1,j,m,n);
        }
        
        for(int i=0;i<m;i++) 
            for(int j=0;j<n;j++) {
                if(board[i][j] == '1')
                    board[i][j] = 'O';
                else if(board[i][j] == 'O')
                    board[i][j] = 'X';
            }
    }
    
    private void dfs(char[][] B, int r, int c, int m, int n) {
        B[r][c] = '1';
        for(int i=0;i<4;i++) {
            int newR = r+ROW[i], newC = c+COL[i];
            if(newR >= 0 && newR < m && newC >= 0 && newC < n && B[newR][newC] == 'O')
                dfs(B,newR,newC,m,n);
        }
    }
}
