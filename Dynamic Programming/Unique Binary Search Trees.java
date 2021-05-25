//Given an integer n, return the number of structurally unique BST's (binary search trees) which has exactly n nodes of unique values from 1 to n.

//Recursion T(n) = O(4^n)
class Solution {
    public int numTrees(int n) {
        if(n == 0||n == 1)
            return 1;
        int res = 0;
        for(int i = 1;i<=n;i++)
            res += numTrees(i-1)*numTrees(n-i);
        return res;
    }
}

//Recursion + Tabulation
class Solution {
    public int numTrees(int n) {
        if(n == 0||n == 1)
            return 1;
        int[] T = new int[n+1];
        T[0] = 1;
        T[1] = 1;
        
        for(int i = 2;i<=n;i++)
            for(int j=1;j<=i;j++)
                T[i] += T[j-1]*T[i-j];
        return T[n];
    }
}
