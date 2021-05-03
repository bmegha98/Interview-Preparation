//Given a rows x cols binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.

class Solution {
    private int largestAreaHistogram(int A[], int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return A[0];
        int maxArea = 0;
        Stack<Integer> aux = new Stack<>();
        int i;
        for(i =0;i<n;i++) {
            while(!aux.isEmpty() && A[i] < A[aux.peek()])
            {
                int h = A[aux.pop()];
                int area = h*(aux.isEmpty()?i:i-aux.peek()-1);
                if(area > maxArea)
                    maxArea = area;
            }
            aux.push(i);
        }
        
        while(!aux.isEmpty()) {
            int h = A[aux.pop()];
            int area = h*(aux.isEmpty()?i:i-aux.peek()-1);
            if(area > maxArea)
                maxArea = area;
        }
        return maxArea;
    }
    
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if(m == 0)
            return 0;
        int n = matrix[0].length;
        if(n == 0)
            return 0;
        
        int maxArea = 0;
        int[][] dp = new int[m][n];
       
        for(int i = 0;i<n;i++)
            dp[0][i] = matrix[0][i]-'0';
        
        for(int i = 1;i<m;i++) {
            for(int j = 0;j<n;j++) {
                if(matrix[i][j] == '1')
                    dp[i][j] = 1+dp[i-1][j];
                else
                    dp[i][j] = 0;
            }
            
        }
        
        
        for(int i = 0;i<m;i++) {
            int area = largestAreaHistogram(dp[i], n);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }
}
