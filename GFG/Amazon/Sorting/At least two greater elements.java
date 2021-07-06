/*
Given an array of N distinct elements, the task is to find all elements in array except two greatest elements in sorted order.
Example 1:

Input : 
a[] = {2, 8, 7, 1, 5}
Output :
1 2 5 
Explanation :
The output three elements have two or more greater elements.   
Example 2:

Input :
a[] = {7, -2, 3, 4, 9, -1}
Output :
-2 -1 3 4
*/

class Solution {
    public long[] findElements( long a[], long n)
    {
        Arrays.sort(a);
        long[] res = new long[(int)(n-2)];
        for(int i=0;i<n-2;i++)
            res[i] = a[i];
        return res;
    }
}
