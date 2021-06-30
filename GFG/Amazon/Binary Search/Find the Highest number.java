/*
Given an array in such a way that the elements stored in array are in increasing order initially and then after reaching to a peak element , elements stored are in
decreasing order. Find the highest element.
Note: A[i] != A[i+1]
Example 1:

Input:
11
1 2 3 4 5 6 5 4 3 2 1
Output: 6
Explanation: Highest element is 6.
Example 2:

Input:
5
1 2 3 4 5
Output: 5
Explanation: Highest element is 5.
*/

class Solution
{
    public int findPeakElement(List<Integer> a)
    {
        int n = a.size();
        if(n == 1)
            return a.get(0);
        int l = 0, h = n-1;
        
        while(l <= h) {
            int m = l+(h-l)/2;
            if((m==0||a.get(m)>a.get(m-1))&&(m==n-1||a.get(m)>a.get(m+1)))
                return a.get(m);
            if(m > 0 && a.get(m) < a.get(m-1))
                h = m-1;
            else
                l = m+1;
        }
        return -1;
    }
}
