/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space,respectively.

Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:
Input: n = 1
Output: [["Q"]]
 

Constraints:

1 <= n <= 9
*/

class Solution {
    List<List<String>> res;
    char[][] board;
    Set<List<String>> aux;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        board = new char[n][n];
        aux = new HashSet<>();
        for(int i=0;i<n;i++)
            Arrays.fill(board[i], '.');
        
        helper(0,n);
        return res;
    }
    
    private void helper(int count, int n) {
        if(count == n) {
            List<String> sols = getConfig();
            if(!aux.contains(sols)) {
                aux.add(sols);
                res.add(sols);
            }
            return;
        }
        
        for(int i=0;i<n;i++) 
            if(safeToPlaceQueen(i,count,n)) {
                board[i][count] = 'Q';
                helper(count+1,n);
                board[i][count] = '.';
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
    
    private List<String> getConfig() {
        List<String> ans = new ArrayList<>();
        for(int i=0;i<board.length;i++) {
            String s = new String(board[i]);
            ans.add(s);
        }
        return ans;
    }
}
