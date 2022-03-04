/*
Given a binary matrix M of size n X m. Find the maximum area of a rectangle formed only of 1s in the given matrix.

Example 1:

Input:
n = 4, m = 4
M[][] = {{0 1 1 0},
         {1 1 1 1},
         {1 1 1 1},
         {1 1 0 0}}
Output: 8
Explanation: For the above test case the
matrix will look like
0 1 1 0
1 1 1 1
1 1 1 1
1 1 0 0
the max size rectangle is 
1 1 1 1
1 1 1 1
and area is 4 *2 = 8.
Your Task: 
Your task is to complete the function maxArea which returns the maximum size rectangle area in a binary-sub-matrix with all 1’s. The function takes 3 arguments 
the first argument is the Matrix M[ ] [ ] and the next two are two integers n and m which denotes the size of the matrix M. 
*/

class Solution {
    public int maxArea(int M[][], int n, int m) {
        // add code here.
        int maxArea = largestRectangleArea(M[0],m);
        
        for(int i=1;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(M[i][j] == 1)
                    M[i][j] += M[i-1][j];
            }
            int areaOfRow = largestRectangleArea(M[i],m); 
            maxArea = Math.max(maxArea, areaOfRow);
        }
        return maxArea;
    }
    
    private int largestRectangleArea(int[] heights, int n) {
        if(n == 0)
            return 0;
        int maxArea = 0,i=0;
        
        Stack<Integer> aux = new Stack<>();
        for(;i<n;i++) {
            while(!aux.isEmpty() && heights[i] < heights[aux.peek()]) {
                int h = heights[aux.pop()];
                int l = aux.isEmpty()?i:i-aux.peek()-1;
                maxArea = Math.max(maxArea,l*h);
            }
            aux.push(i);
        }
        
        while(!aux.isEmpty()) {
            int h = heights[aux.pop()];
            int l = aux.isEmpty()?i:i-aux.peek()-1;
            maxArea = Math.max(maxArea,l*h);
        }
        return maxArea;
    }
}
