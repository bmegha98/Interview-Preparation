/*
Given a square grid of integers arr, a falling path with non-zero shifts is a choice of exactly one element from each row of arr, such that no two elements chosen
in adjacent rows are in the same column.Return the minimum sum of a falling path with non-zero shifts.
Example 1:

Input: arr = [[1,2,3],[4,5,6],[7,8,9]]
Output: 13
Explanation: 
The possible falling paths are:
[1,5,9], [1,5,7], [1,6,7], [1,6,8],
[2,4,8], [2,4,9], [2,6,7], [2,6,8],
[3,4,8], [3,4,9], [3,5,7], [3,5,9]
The falling path with the smallest sum is [1,5,7], so the answer is 13.

*/

//T(n) = O(n^3) , space = O(1)
class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        if(n == 1)
            return arr[0][0];
        int ans = Integer.MAX_VALUE;
        for(int i = 1;i<n;i++) {
            for(int j = 0;j<n;j++) {
                int currMin = getMin(arr[i-1],j);
                arr[i][j] += currMin;
                if(i == n-1)
                    ans = Math.min(ans,arr[i][j]);
            }
        }
        return ans;
    }
    private int getMin(int[] A,int ind) {
        int minEle = Integer.MAX_VALUE;
        for(int i=0;i<A.length;i++)
            if(i != ind && A[i] < minEle)
                minEle = A[i];
        return minEle;
    }
}

//T(n) = O(n^2) , Space = O(1)
class Solution {
    public int minFallingPathSum(int[][] arr) {
        int n = arr.length;
        if(n == 1)
            return arr[0][0];
        int min1 = Integer.MAX_VALUE,min2 = Integer.MAX_VALUE;
        
        for(int i=0;i<n;i++) {
            if(arr[0][i] < min1) {
                min2 = min1;
                min1 = arr[0][i];
            }
            else if(arr[0][i] < min2)
                min2 = arr[0][i];
        }
        
        for(int i =1;i<n;i++) {
            int tmp1 = Integer.MAX_VALUE,tmp2 = Integer.MAX_VALUE;
            for(int j=0;j<n;j++) {
                if(arr[i-1][j] == min1)
                    arr[i][j] += min2;
                else
                    arr[i][j] += min1;
                if(tmp1 > arr[i][j]) {
                    tmp2 = tmp1;
                    tmp1 = arr[i][j];
                }
                else if(tmp2 > arr[i][j])
                    tmp2 = arr[i][j];
            }
            min1 = tmp1;
            min2 = tmp2;
        }
        return min1;
    }
}
