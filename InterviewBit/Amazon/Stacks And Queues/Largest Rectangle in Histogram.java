/*
Given an array of integers A of size N. A represents a histogram i.e A[i] denotes height of
the ith histogram’s bar. Width of each bar is 1.Find the area of largest rectangle in the histogram.
*/

public class Solution {
    public int largestRectangleArea(int[] A) {
        int n = A.length;
        if(n == 0) return 0;
        if(n == 1) return A[0];
        Stack<Integer> aux = new Stack<>();
        int i,maxArea = 0;
        for(i=0;i<n;i++) {
            while(!aux.isEmpty() && A[i] < A[aux.peek()]) {
                int h = A[aux.pop()];
                int w = aux.isEmpty()?i:i-aux.peek()-1;
                int area = h*w;
                if(maxArea < area)
                    maxArea = area;
            }
            aux.push(i);
        }
        while(!aux.isEmpty()) {
            int h = A[aux.pop()];
            int w = aux.isEmpty()?i:i-aux.peek()-1;
            int area = h*w;
            if(maxArea < area)
                maxArea = area;
        }
        return maxArea;
    }
}
