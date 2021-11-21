/*
An image is represented by a 2-D array of integers, each integer representing the pixel value of the image.

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, 
plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the 
aforementioned pixels with the newColor.

Example 1:

Input: image = {{1,1,1},{1,1,0},{1,0,1}},
sr = 1, sc = 1, newColor = 2.
Output: {{2,2,2},{2,2,0},{2,0,1}}
Explanation: From the center of the image 
(with position (sr, sc) = (1, 1)), all 
pixels connected by a path of the same color
as the starting pixel are colored with the new 
color.Note the bottom corner is not colored 2, 
because it is not 4-directionally connected to 
the starting pixel.

*/

class Solution
{
    int[] ROW = {0,-1,0,1};
    int[] COL = {-1,0,1,0};
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int m = image.length, n = image[0].length;
        int color = image[sr][sc];
        if(color == newColor)
            return image;
        helper(image,sr,sc,m,n,color,newColor);
        return image;
    }
    private void helper(int[][] M, int r, int c, int m, int n, int origColor, 
        int newColor) {
            if(r < 0 || r >= m || c < 0 || c >= n || M[r][c] != origColor)
                return;
            M[r][c] = newColor;
            for(int i=0;i<4;i++)
                helper(M,r+ROW[i],c+COL[i],m,n,origColor,newColor);
        }
}
