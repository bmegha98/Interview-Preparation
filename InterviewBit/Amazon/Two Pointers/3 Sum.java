/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target.
Return the sum of the three integers.

Assume that there will only be one solution

Example:
given array S = {-1 2 1 -4},
and target = 1.

The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
*/

public class Solution {
    public int threeSumClosest(ArrayList<Integer> A, int B) {
        int n = A.size();
        if(n < 3)
            return Integer.MAX_VALUE;
        
        Collections.sort(A);
        int diff = Integer.MAX_VALUE,ans = -1;
        for(int i=0;i<=n-3;i++) {
            int l = i+1,h = n-1;
            while(l < h) {
                int s = A.get(i)+A.get(l)+A.get(h);
                if(s == B)
                    return s;
                if(Math.abs(B-s) < diff) {
                    diff = Math.abs(B-s);
                    ans = s;
                }
                if(s < B)
                    l++;
                else
                    h--;
            }
        }
        return ans;
    }
}
