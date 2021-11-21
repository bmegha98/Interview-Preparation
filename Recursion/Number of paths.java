/*
The problem is to count all the possible paths from top left to bottom right of a MxN matrix with the constraints that from each cell you can either move to right 
or down.

Example 1:

Input:
M = 3 and N = 3
Output: 6
Explanation:
Let the given input 3*3 matrix is filled 
as such:
A B C
D E F
G H I
The possible paths which exists to reach 
'I' from 'A' following above conditions 
are as follows:ABCFI, ABEHI, ADGHI, ADEFI, 
ADEHI, ABEFI
 

Example 2:

Input:
M = 2 and N = 8
Output: 8
*/

class Solution{
    
    long numberOfPaths(int m, int n) {
        // Code Here
        long[][] res = new long[m][n];
        for(int i=0;i<m;i++)
            res[i][0] = 1;
        for(int j=0;j<n;j++)
            res[0][j] = 1;
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                res[i][j] = res[i][j-1]+res[i-1][j];
        return res[m-1][n-1];
    }
    
}
