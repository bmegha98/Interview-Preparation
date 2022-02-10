/*
Given a 2D board of letters and a word. Check if the word exists in the board. The word can be constructed from letters of adjacent cells only. ie - horizontal
or vertical neighbors. The same letter cell can not be used more than once.
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
Example 2:

Input: board = {{a,b,c,e},{s,f,c,s},{a,d,e,e}},
word = "sabfs"
Output: 0
Explanation: The board is-
a b c e
s f c s
a d e e
Same letter can not be used twice hence ans is 0
 

Your Task:
You don't need to read or print anything. Your task is to complete the function isWordExist() which takes board and word as input parameter and returns boolean 
value true if word can be found otherwise returns false.
 

Expected Time Complexity: O(N * M * 4L) where N = No. of rows in board, M = No. of columns in board, L = Length of word
Expected Space Compelxity: O(L), L is length of word.
 

Constraints:
1 ≤ N, M ≤ 100
1 ≤ L ≤ N*M


*/

class Solution
{
    int[] ROW = {-1,0,0,1};
    int[] COL = {0,-1,1,0};
    public boolean isWordExist(char[][] board, String word)
    {
        // Code here
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0;i<m;i++)
            for(int j=0;j<n;j++) {
                if(board[i][j] == word.charAt(0)) {
                    if(helper(board,visited,i,j,m,n,word,0))
                        return true;
                }
            }
        return false;
    }
    
    private boolean helper(char[][] B, boolean[][] V, int i, int j, int m,
                            int n, String word,int ind) {
        if(ind == word.length()-1)
            return true;
        V[i][j] = true;
        for(int k=0;k<4;k++) {
            int newR = i+ROW[k], newC = j+COL[k];
            if(newR >= 0 && newR < m && newC >= 0 && newC < n && 
                ind < word.length()-1 && B[newR][newC] == word.charAt(ind+1) 
                && !V[newR][newC]) {
                if(helper(B,V,newR,newC,m,n,word,ind+1))
                    return true;
            }
        }
        V[i][j] = false;
        return false;
    }
}
