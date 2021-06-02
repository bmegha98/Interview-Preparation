/*
Given a dictionary of distinct words and an M x N board where every cell has one character. Find all possible words from the dictionary that can be formed by a 
sequence of adjacent characters on the board. We can move to any of 8 adjacent characters, but a word should not have multiple instances of the same cell.
Example 1:

Input: 
N = 1
dictionary = {"CAT"}
R = 3, C = 3
board = {{C,A,P},{A,N,D},{T,I,E}}
Output:
CAT
*/

class Solution
{
    int[] ROW = {-1,-1,-1,0,0,1,1,1};
    int[] COL = {-1,0,1,-1,1,-1,0,1};
    int m,n;
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        ArrayList<String> res = new ArrayList<>();
        
        for(String s : dictionary) {
            char[] w = s.toCharArray();
            boolean found = false;
            for(int i=0;i<m;i++) {
                for(int j=0;j<n;j++) {
                    if(board[i][j] == w[0] && Found(board,visited,w,i,j,0)) {
                        found = true;
                        break;
                    }
                }
                if(found)
                    break;
            }
            if(found)
                res.add(s);
        }
        String[] words = new String[res.size()];
        int k = 0;
        for(String w : res)
            words[k++] = w;
        return words;
    }
    private boolean Found(char[][] B,boolean[][] V,char[] w,int r, int c,int ind) {
        V[r][c] = true;
        ind++;
        if(ind == w.length) {
            V[r][c] = false;
            return true;
        }
        for(int i=0;i<8;i++) {
            int newR = r+ROW[i], newC = c+COL[i];
            if(newR >= 0 && newR < m && newC >= 0 && newC < n && !V[newR][newC] &&
                B[newR][newC] == w[ind]) {
                    if(Found(B,V,w,newR,newC,ind)) {
                        V[r][c] = false;
                        return true;
                    }
                }
        }
        V[r][c] = false;
        return false;
    }
}
