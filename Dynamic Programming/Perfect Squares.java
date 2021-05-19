/*
Given an integer n, return the least number of perfect square numbers that sum to n.
A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are
perfect squares while 3 and 11 are not.
*/
//T(n) = O(n^1.5) ~ O(n^2) , Space = O(n^2)
class Solution {
    public int numSquares(int n) {
        if(n == 1)
            return 1;
        int size = (int)Math.sqrt(n);
        int[][] T = new int[size+1][n+1];
        
        for(int i=1;i<=n;i++)
            T[0][i] = Integer.MAX_VALUE-1;
        
        for(int i = 1;i<=size;i++) {
            for(int j=1;j<=n;j++) {
                if(i*i > j)
                    T[i][j] = T[i-1][j];
                else
                    T[i][j] = Math.min(T[i-1][j], 1 + T[i][j-i*i]);
            }
        }
        return T[size][n];
    }
}
