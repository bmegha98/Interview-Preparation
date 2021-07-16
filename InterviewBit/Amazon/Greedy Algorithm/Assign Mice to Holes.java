/*
There are N Mice and N holes are placed in a straight line.
Each hole can accomodate only 1 mouse.
A mouse can stay at his position, move one step right from x to x + 1, or move one step left from x to x − 1. Any of these moves consumes 1 minute.
Assign mice to holes so that the time when the last mouse gets inside a hole is minimized.

Example:

positions of mice are:
4 -4 2
positions of holes are:
4 0 5

Assign mouse at position x=4 to hole at position x=4 : Time taken is 0 minutes 
Assign mouse at position x=-4 to hole at position x=0 : Time taken is 4 minutes 
Assign mouse at position x=2 to hole at position x=5 : Time taken is 3 minutes 
After 4 minutes all of the mice are in the holes.

Since, there is no combination possible where the last mouse's time is less than 4, 
answer = 4.
Input:

A :  list of positions of mice
B :  list of positions of holes
Output:

single integer value
 NOTE: The final answer will fit in a 32 bit signed integer. 
 
Greedy Approach : Assign each mouse to its closest hole.
Sort both arrays
Let i1 < i2 be the positions of two mice and let j1 < j2 be the positions of two holes.
max(|i1 - j1|, |i2 - j2|) <= max(|i1 - j2|, |i2 - j1|) , 
    where '|a - b|' represent absolute value of (a - b)
So, mouse at position i should be assigned to corresponding ith hole
*/

public class Solution {
    public int mice(int[] A, int[] B) {
        int n = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        
        int res = 0;
        for(int i=0;i<n;i++)
            res = Math.max(res, Math.abs(A[i]-B[i]));
        return res;
    }
}
