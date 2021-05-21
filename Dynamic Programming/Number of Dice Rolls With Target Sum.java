//You have d dice and each die has f faces numbered 1, 2, ..., f.
//Return the number of possible ways (out of fd total ways) modulo 109 + 7 to roll the dice so the sum of the face-up numbers equals target.

//OPT(d,target) = OPT(d-1,target-1) + OPT(d-1,target-2) + ................. + OPT(d-1,target-x) where x = min(target,f)
class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        int[][] T = new int[d+1][target+1];
        int MOD = 1000000007;
        T[0][0] = 1;
        for(int j = 1;j<=f&&j<=target;j++)
            T[1][j] = 1;
        
        for(int i = 2;i<=d;i++) {
            for(int j = i;j<=target;j++) {
                for(int k = 1;k<=j && k <= f ;k++)
                    T[i][j] = (T[i][j] +T[i-1][j-k])%MOD;
            }
        }
        return T[d][target];
    }
}
