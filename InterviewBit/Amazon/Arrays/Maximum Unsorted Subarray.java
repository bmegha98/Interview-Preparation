/*
You are given an array (zero indexed) of N non-negative integers, A0, A1 ,…, AN-1.
Find the minimum sub array Al, Al+1 ,…, Ar so if we sort(in ascending order) that sub array, then the whole array should get sorted.
If A is already sorted, output -1.

Example :

Input 1:

A = [1, 3, 2, 4, 5]

Return: [1, 2]

Input 2:

A = [1, 2, 3, 4, 5]

Return: [-1]
In the above example(Input 1), if we sort the subarray A1, A2, then whole array A should get sorted.
*/

public class Solution {
    public int[] subUnsort(int[] A) {
        int n = A.length;
        int[] res = new int[n];
        if(n == 1) {
            res[0] = -1;
            return res;
        }
        
        int l = -1;
        for(int i=0;i<n-1;i++)
            if(A[i] > A[i+1]) {
                l = i;
                break;
            }
        if(l == -1) 
            return new int[]{-1};
        
        int r = -1;
        for(int i=n-1;i>0;i--)
            if(A[i] < A[i-1]) {
                r = i;
                break;
            }
        
        int p = l, q = r;
        int minEle = A[l], maxEle = A[l];
        l++;
        while(l<=r) {
            if(A[l] > maxEle)
                maxEle = A[l];
            else if(A[l] < minEle)
                minEle = A[l];
            l++;
        }
        
        int first = p;
        for(int i=0;i<p;i++)
            if(A[i] > minEle) {
                first = i;
                break;
            }
        int second = q;
        for(int i=n-1;i>q;i--)
            if(A[i] < maxEle) {
                second = i;
                break;
            }
        return new int[]{first,second};
    }
}
