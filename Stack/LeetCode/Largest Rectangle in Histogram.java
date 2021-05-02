/*
Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the 
histogram.
*/
//T(n) = O(n), space = O(n)
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        if(n == 1)
            return heights[0];
        int maxArea = 0;
        Stack<Integer> aux = new Stack<>();
        int i;
        for(i =0;i<n;i++) {
            while(!aux.isEmpty() && heights[i] < heights[aux.peek()])
            {
                int h = heights[aux.pop()];
                int area = h*(aux.isEmpty()?i:i-aux.peek()-1);
                maxArea = Math.max(maxArea, area);
            }
            aux.push(i);
        }
        while(!aux.isEmpty()) {
            int h = heights[aux.pop()];
            int area = h*(aux.isEmpty()?i:i-aux.peek()-1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
