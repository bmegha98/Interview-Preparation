/*
You are given two arrays, A and B, of equal size N. The task is to find the minimum value of A[0] * B[0] + A[1] * B[1] +…+ A[N-1] * B[N-1], where shuffling of
elements of arrays A and B is allowed.
*/

class Solution {

    public long minValue(long a[], long b[], long n) 
    {
        Arrays.sort(a);
        Arrays.sort(b);
        
        long res = 0;
        for(int i=0;i<n;i++)
            res += (a[i]*b[b.length-1-i]);
            
        return res;
    }
}
