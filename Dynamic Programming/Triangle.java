/*
Given a triangle array, return the minimum path sum from top to bottom.
For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or
index i + 1 on the next row.
Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).
*/

//Time : O(n^2) , space = O(1)
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if(n == 1)
            return triangle.get(0).get(0);
       
        int minPath = Integer.MAX_VALUE;
        
        for(int i = 1;i<n;i++) {
            for(int j = 0;j<=i;j++) {
                int val = 0;
                if(j == 0) {
                    val = triangle.get(i-1).get(j)+triangle.get(i).get(j);
                    triangle.get(i).set(j,val);
                }
                else if(j == i) {
                    val = triangle.get(i-1).get(j-1)+triangle.get(i).get(j);
                    triangle.get(i).set(j,val);
                }
                else {
                    val = Math.min(triangle.get(i-1).get(j),triangle.get(i-1).get(j-1)) + triangle.get(i).get(j);
                    triangle.get(i).set(j,val);
                }
                if(i == n-1)
                    minPath = Math.min(minPath,val);
            }
        }
        return minPath;
    }
}
