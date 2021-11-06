/*
Given an integer N denoting the Length of a line segment. You need to cut the line segment in such a way that the cut length of a line segment each time is either
x , y or z. Here x, y, and z are integers.
After performing all the cut operations, your total number of cut segments must be maximum.

Example 1:

Input:
N = 4
x = 2, y = 1, z = 1
Output: 4
Explanation:Total length is 4, and the cut
lengths are 2, 1 and 1.  We can make
maximum 4 segments each of length 1.
Example 2:

Input:
N = 5
x = 5, y = 3, z = 2
Output: 2
Explanation: Here total length is 5, and
the cut lengths are 5, 3 and 2. We can
make two segments of lengths 3 and 2.
*/

class Solution
{
    //Function to find the maximum number of cuts.
    public int maximizeCuts(int n, int x, int y, int z)
    {
        //Your code here
        int[] T = new int[n+1];
       
        for(int i=1;i<=n;i++) {
            int a = -1, b = -1, c = -1;
            if(i-x >= 0)
                a = T[i-x];
            if(i-y >= 0)
                b = T[i-y];
            if(i-z >= 0)
                c = T[i-z];
            if(a == -1 && b == -1 && c == -1)
                T[i] = -1;
            else
                T[i] = Math.max(a,Math.max(b,c)) + 1;
        }
        return T[n] == -1? 0: T[n];
    }
}
