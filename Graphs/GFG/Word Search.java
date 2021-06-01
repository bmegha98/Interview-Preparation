/*
Given a 2D board of letters and a word. Check if the word exists in the board. The word can be constructed from letters of adjacent cells only. ie - horizontal or 
vertical neighbors. The same letter cell can not be used more than once.
Example 1:

Input: board = {{a,g,b,c},{q,e,e,l},{g,b,k,s}},
word = "geeks"
Output: 1
Explanation: The board is-
a g b c
q e e l
g b k s
The letters which are used to make the
"geeks" are colored.
*/

class Solution
{
    int[] ROW = {-1,0,0,1};
    int[] COL = {0,-1,1,0};
    int m,n;
    public boolean isWordExist(char[][] board, String word)
    {
        m = board.length;
        n = board[0].length;
    
        char[] W = word.toCharArray();
        boolean[][] used = new boolean[m][n];
        
        for(int i = 0;i<m;i++) {
            for(int j =0;j<n;j++) {
                if(board[i][j] == W[0]) {
                    if(Found(board,W,used,i,j,0))
                        return true;
                }
            }
        }
        return false;
    }
    
    private boolean Found(char[][] B,char[] w,boolean[][] V,int r, int c, int ind) {
        V[r][c] = true;
        ind++;
        if(ind == w.length)
            return true;
        for(int i=0;i<4;i++) {
            int newR = r+ROW[i], newC = c+COL[i];
            if(newR >= 0 && newR < m && newC >= 0 && newC < n && !V[newR][newC] 
                && B[newR][newC] == w[ind]) {
                    if(Found(B,w,V,newR,newC,ind))
                        return true;
                }
        }
        V[r][c] = false;
        return false;
    }
}
