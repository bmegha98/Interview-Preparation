/*
Given a dictionary of distinct words and an M x N board where every cell has one character. Find all possible words from the dictionary that can be formed by a 
sequence of adjacent characters on the board. We can move to any of 8 adjacent characters

Note: While forming a word we can move to any of the 8 adjacent cells. A cell can be used only once in one word.
Example 1:

Input: 
N = 1
dictionary = {"CAT"}
R = 3, C = 3
board = {{C,A,P},{A,N,D},{T,I,E}}
Output:
CAT
Explanation: 
C A P
A N D
T I E
Words we got is denoted using same color.
Example 2:

Input:
N = 4
dictionary = {"GEEKS","FOR","QUIZ","GO"}
R = 3, C = 3 
board = {{G,I,Z},{U,E,K},{Q,S,E}}
Output:
GEEKS QUIZ
Explanation: 
G I Z
U E K
Q S E 
Words we got is denoted using same color.

Your task:
You don’t need to read input or print anything. Your task is to complete the function wordBoggle() which takes the dictionary contaning N space-separated strings
and R*C board as input parameters and returns a list of words that exist on the board in lexicographical order.
*/

class Solution
{
    int[] ROW = {-1,-1,-1,0,0,1,1,1};
    int[] COL = {-1,0,1,-1,1,-1,0,1};
    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        // Write your code here
        int m = board.length, n = board[0].length;
        int l = dictionary.length;
        List<String> tmp = new ArrayList<>();
        int k=0;
        boolean[][] visited = new boolean[m][n];
        for(String word : dictionary) {
            if(isWordExist(board,visited,m,n,word)) 
                tmp.add(word);    
        }
        String[] res = new String[tmp.size()];
        for(String s : tmp)
            res[k++] = s;
        return res;
    }
    private boolean isWordExist(char[][] board, boolean[][] visited,
                            int m, int n, String word) {
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
        for(int k=0;k<8;k++) {
            int newR = i+ROW[k], newC = j+COL[k];
            if(newR >= 0 && newR < m && newC >= 0 && newC < n && 
                ind < word.length()-1 && B[newR][newC] == word.charAt(ind+1) 
                && !V[newR][newC]) {
                if(helper(B,V,newR,newC,m,n,word,ind+1)) {
                    V[i][j] = false;
                    return true;
                }
            }
        }
        V[i][j] = false;
        return false;
    }
}
