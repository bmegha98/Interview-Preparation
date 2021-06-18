/*
Given an array A of N integers. You have to find whether a combination of four elements in the array whose sum is equal to a given value X exists or not.
*/

//Using sorting , T(n) = O(n^3)
class Compute
{
    boolean find4Numbers(int A[], int n, int X) 
    {
        if(n < 4)
            return false;
        Arrays.sort(A);
        for(int i=0;i<=n-4;i++) {
            for(int j=i+1;j<=n-3;j++) {
                int l = j+1,h = n-1;
                while(l<h) {
                    int s = A[i]+A[j]+A[l]+A[h];
                    if(s == X)
                        return true;
                    if(s < X)
                        l++;
                    else
                        h--;
                }
            }
        }
        return false;
    }
}
