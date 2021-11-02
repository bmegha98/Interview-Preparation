/*
Given two arrays X and Y of positive integers, find the number of pairs such that xy > yx (raised to power of) where x is an element from X and y is an element 
from Y.

Example 1:

Input: 
M = 3, X[] = [2 1 6] 
N = 2, Y[] = [1 5]
Output: 3
Explanation: 
The pairs which follow xy > yx are 
as such: 21 > 12,  25 > 52 and 61 > 16 .
Example 2:

Input: 
M = 4, X[] = [2 3 4 5]
N = 3, Y[] = [1 2 3]
Output: 5
Explanation: 
The pairs for the given input are 
21 > 12 , 31 > 13 , 32 > 23 , 41 > 14 , 
51 > 15 .

Your Task:
This is a function problem. You only need to complete the function countPairs() that takes X, Y, M, N as parameters and returns the total number of pairs.

Expected Time Complexity: O((N + M)log(N)).
Expected Auxiliary Space: O(1).

Constraints:
1 ≤ M, N ≤ 105
1 ≤ X[i], Y[i] ≤ 103
*/

//if X^y > Y^x => ylogX > xlogY => y > x
//For each x, determine index i of smallest element in y that is greater than x
//count = count + (N-i)

class Solution
{
    
    // x[], y[]: input array elements
    // M, N: size of arrays x[] and y[] respectively
    //Function to count number of pairs such that x^y is greater than y^x.
    static int binarySearch(int[] A, int ele) {
        int ans = -1;
        int l = 0, h = A.length-1;
        while(l<=h) {
            int m = l+(h-l)/2;
            if(A[m] <= ele)
                l = m+1;
            else {
                ans = m;
                h = m-1;
            }
        }
        return ans;
    }
    
    static long countPairs(int x[], int y[], int M, int N)
    {
        // your code here
        Arrays.sort(y);
        
        long res = 0;
        int[] countInY = new int[5];
        for(int i=0;i<N;i++) 
            if(y[i] < 5)
                countInY[y[i]]++;
        
        for(int i = 0;i<M;i++) {
            if(x[i] < 2)
                continue;
            
            res += countInY[1];
            int ind = binarySearch(y, x[i]);
            //System.out.println("ind : "+ind);
            if(ind != -1)
                res += (N-ind);
            
            if(x[i] == 2)
                res = res-countInY[3]-countInY[4];
            else if(x[i] == 3)
                res = res + countInY[2];
           // System.out.println(res);
        }    
        return res;
    }
}
