/*
Given an array of n integers and a positive number k. We are allowed to take any k integers from the given array. The task is to find the minimum possible value of
the difference between maximum and minimum of k numbers.
Example 1:

Input:
N=7
K=3
arr[] = {10, 100, 300, 200, 1000, 20, 30}
Output:
20
Explanation:
20 is the minimum possible difference between any maximum and minimum of any k numbers.Given k = 3, we get the result 20 by selecting integers {10, 20, 30}.
max(10, 20, 30) - max(10, 20, 30) = 30 - 10 = 20.
Example 2:

Input:
N=2
K=2
arr[] = { 1,1 }
Output:
0
Explanation: max({1,1}) - min({1,1}) = 1 - 1 = 0

max and min should be closest to minimize difference.
*/

class Solution
{
    long minDiff(long a[] ,int N,int K)
    {
        Arrays.sort(a);
        int i = 0;
        long minDiff = Long.MAX_VALUE;
        while(i <= N-K) {
            int j = i+K-1;
            if(minDiff > a[j]-a[i])
                minDiff = a[j]-a[i];
            i++;
        }
        return minDiff;
    }
}
