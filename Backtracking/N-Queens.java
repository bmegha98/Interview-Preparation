/*
The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.
Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.
Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.
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
//For each queen, there are n choices
class Solution {
    List<List<String>> res;
    int[][] grid;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        grid = new int[n][n];
        helper(0,n,new ArrayList<>());
        return res;
    }
    private void helper(int curr, int n, ArrayList<Integer> tmp) {
        if(curr == n) {
            convertGridToString(n,tmp);
            return;
        }
        
        for(int i=0;i<n;i++)
            if(isSafe(curr,i,n)) {
                grid[curr][i] = 1;
                tmp.add(i+1);
                helper(curr+1,n,tmp);
                grid[curr][i] = 0;
                tmp.remove(tmp.size()-1);
            }
    }
    
    private boolean isSafe(int r, int c, int n) {
        for(int i=0;i<r;i++)
            if(grid[i][c] == 1)
                return false;
        //check for left upper diagonal
        int i=r, j = c;
        while(i>=0 && j>=0) {
            if(grid[i][j] == 1)
                return false;
            i--;
            j--;
        }
        
        //check for right upper diagonal
        i = r; j = c;
        while(i >= 0 && j < n) {
            if(grid[i][j] == 1)
                return false;
            i--;
            j++;
        }
        
        return true;
    }
    
    private void convertGridToString(int n, List<Integer> A) {
        char[] row = new char[n];
        Arrays.fill(row,'.');
        List<String> l = new ArrayList<>();
        for(int ele : A) {
            row[ele-1] = 'Q';
            l.add(new String(row));
            row[ele-1] = '.';
        }
        res.add(l);
    }
}
