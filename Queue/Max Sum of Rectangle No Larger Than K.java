/*
Given an m x n matrix matrix and an integer k, return the max sum of a rectangle in the matrix such that its sum is no larger than k.

It is guaranteed that there will be a rectangle with a sum no larger than k.
*/

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int m = matrix.length;
        if(m == 0)
            return 0;
        int n = matrix[0].length;
        int maxRes = Integer.MIN_VALUE;
        for(int l = 0;l<n;l++) {
            int[] sum = new int[m];
            for(int r = l;r<n;r++) {
                for(int i = 0;i<m;i++)
                    sum[i] += matrix[i][r];
                maxRes = Math.max(maxRes, subarraySum(sum, m, k));
            }
        }
        return maxRes;
    }
    
    private int subarraySum(int A[], int n, int k) {
        int res = Integer.MIN_VALUE,currSum = 0;
        TreeSet<Integer> aux = new TreeSet<>();
        aux.add(0);
        
        for(int i = 0;i<n;i++) {
            currSum += A[i];
            Integer prevSum = aux.ceiling(currSum - k);
            if(prevSum != null) 
                res = Math.max(res, currSum-prevSum);
            aux.add(currSum);
        }
        return res;
    }
}
