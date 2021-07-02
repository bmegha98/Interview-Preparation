/*
Given an array of size N containing only 0s, 1s, and 2s; sort the array in ascending order.
Example 1:

Input: 
N = 5
arr[]= {0 2 1 2 0}
Output:
0 0 1 2 2
Explanation:
0s 1s and 2s are segregated into ascending order.
*/

class Solution
{
    public static void sort012(int a[], int n)
    {
        int l = 0,m=0,h=n-1;
        while(m <= h) {
            if(a[m] == 0) {
                swap(a, l, m);
                l++;
                m++;
            }
            else if(a[m] == 1)
                m++;
            else {
                swap(a,m,h);
                h--;
            }
        } 
    }
    private static void swap(int[] A,int i,int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
