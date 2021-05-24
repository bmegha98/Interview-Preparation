/*
The problem is to find shortest distances between every pair of vertices in a given edge weighted directed Graph. The Graph is represented as adjancency matrix, 
and the matrix denotes the weight of the edegs (if it exists) else -1. Do it in-place.
*/

//Include vertices one by one and update shortest path value
//OPT(i,j) = min{OPT(i,j),OPT(i,k)+OPT(k,j)}   including vertex k

class Solution
{
    public void shortest_distance(int[][] matrix)
    {
        int V = matrix.length;
        for(int i = 0;i<V;i++)
            for(int j =0;j<V;j++)
                if(matrix[i][j] == -1)
                    matrix[i][j] = Integer.MAX_VALUE;
        
        //Include vertices one by one
        
        for(int k = 0;k<V;k++) {
            for(int i = 0;i<V;i++) {
                for(int j = 0;j<V;j++) {
                    if(matrix[i][k] == Integer.MAX_VALUE || matrix[k][j] == Integer.
                        MAX_VALUE)
                        continue;
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k]+matrix[k][j]);
                }
            }
        }
        for(int i = 0;i<V;i++)
            for(int j =0;j<V;j++)
                if(matrix[i][j] == Integer.MAX_VALUE)
                    matrix[i][j] = -1;
    }
}
