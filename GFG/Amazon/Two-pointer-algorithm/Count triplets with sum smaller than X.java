/*
Given an array arr[] of distinct integers of size N and a sum value X, the task is to find count of triplets with the sum smaller than the given sum value X.
Example 1:

Input: N = 6, X = 2
arr[] = {-2, 0, 1, 3}
Output:  2
Explanation: Below are triplets with sum less than 2 (-2, 0, 1) and (-2, 0, 3). 

Example 2:
Input: N = 5, X = 12
arr[] = {5, 1, 3, 4, 7}
Output: 4
Explanation: Below are triplets with 
sum less than 12 (1, 3, 4), (1, 3, 5), 
(1, 3, 7) and (1, 4, 5).

After sorting , arr[] = {1,3,4,5,7}
for i = 0 , l = 1, h = 4
since 1+3+7 < 12 so 1+3+{4,5,7} < 11 so count += (h-l)
*/

class Solution
{
    long countTriplets(long arr[], int n,int sum)
    {
        long count = 0;
        Arrays.sort(arr);
        
        for(int i=0;i<=n-3;i++) {
            int l = i+1,h = n-1;
            while(l<h) {
                long s = arr[i]+arr[l]+arr[h];
                if(s >= sum)
                    h--;
                else {
                    count += (h-l);
                    l++;
                }
            }
        }
        return count;
    }
}
