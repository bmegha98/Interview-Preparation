/*
You are given a rectangular cake of size h x w and two arrays of integers horizontalCuts and verticalCuts where:

horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly, and
verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided in the arrays horizontalCuts and verticalCuts.
Since the answer can be a large number, return this modulo 109 + 7.

 

Example 1:


Input: h = 5, w = 4, horizontalCuts = [1,2,4], verticalCuts = [1,3]
Output: 4 
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green piece of 
cake has the maximum area.
Example 2:


Input: h = 5, w = 4, horizontalCuts = [3,1], verticalCuts = [1]
Output: 6
Explanation: The figure above represents the given rectangular cake. Red lines are the horizontal and vertical cuts. After you cut the cake, the green and
yellow pieces of cake have the maximum area.
Example 3:

Input: h = 5, w = 4, horizontalCuts = [3], verticalCuts = [3]
Output: 9
 

Constraints:

2 <= h, w <= 109
1 <= horizontalCuts.length <= min(h - 1, 105)
1 <= verticalCuts.length <= min(w - 1, 105)
1 <= horizontalCuts[i] < h
1 <= verticalCuts[i] < w
All the elements in horizontalCuts are distinct.
All the elements in verticalCuts are distinct.
*/
//To get max area, maximize length and width. 
class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        int MOD = 1000000007;
        int m = horizontalCuts.length, n = verticalCuts.length;
        
        //Extreme corner gaps
        long maxDiff1 = Math.max((h-horizontalCuts[m-1])%MOD, horizontalCuts[0]);
        long maxDiff2 = Math.max((w-verticalCuts[n-1])%MOD, verticalCuts[0]);
        
        for(int i=0;i<m-1;i++)
            maxDiff1 = Math.max(maxDiff1, (horizontalCuts[i+1]-horizontalCuts[i])%MOD);
        
        for(int j=0;j<n-1;j++)
            maxDiff2 = Math.max(maxDiff2, (verticalCuts[j+1]-verticalCuts[j])%MOD);
        
        return (int)((maxDiff1*maxDiff2)%MOD);
    }
}
