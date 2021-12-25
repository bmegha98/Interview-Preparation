/*
Given an array of integers, your task is to find the smallest and second smallest element in the array. If smallest and second smallest do not exist, print -1.

Example 1:

Input :
5
2 4 3 5 6
Output :
2 3 
Explanation: 
2 and 3 are respectively the smallest and second smallest elements in the array.

Example 2:

Input :
6
1 2 1 3 6 7
Output :
1 2 
Explanation: 
1 and 2 are respectively the smallest and second smallest elements in the array.
*/

class Compute 
{
    public long[] minAnd2ndMin(long a[], long n)  
    {
        if(n == 1)
            return new long[]{-1};
        long first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            if(a[i] < first) {
                second = first;
                first = a[i];
            }
            else if(a[i] < second && a[i] != first)
                second = a[i];
        }
        
        if(first == Integer.MAX_VALUE || second == Integer.MAX_VALUE)
            return new long[]{-1};
        return new long[]{first, second};
    }
}
