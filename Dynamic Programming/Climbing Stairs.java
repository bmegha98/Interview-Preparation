//You are climbing a staircase. It takes n steps to reach the top.Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

//T(n) = O(n) , Space = O(1)
class Solution {
    public int climbStairs(int n) {
        if(n == 1)
            return 1;
        if(n == 2)
            return 2;
        int a = 1,b = 2;
        for(int i = 3;i<=n;i++) {
            int s = a+b;
            a = b;
            b = s;
        }
        return b;
    }
}
