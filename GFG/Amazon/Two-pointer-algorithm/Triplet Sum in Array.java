/*
Given an array arr of size n and an integer X. Find if there's a triplet in the array which sums up to the given integer X.
Example 1:

Input:
n = 6, X = 13
arr[] = [1 4 45 6 10 8]
Output:
1
Explanation:
The triplet {1, 4, 8} in 
the array sums up to 13.
*/

class Solution
{
    //Function to find if there exists a triplet in the 
    //array A[] which sums up to X.
    public static boolean find3Numbers(int A[], int n, int X) { 
    
        Arrays.sort(A);
        for(int i=0;i<=n-3;i++) {
            int l =i+1,h = n-1;
            while(l<h) {
                int s = A[i]+A[l]+A[h];
                if(s == X)
                    return true;
                if(s < X)
                    l++;
                else
                    h--;
           }
       }
       return false;
    }
}
