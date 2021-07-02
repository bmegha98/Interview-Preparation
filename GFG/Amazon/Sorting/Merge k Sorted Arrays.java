/*
Given K sorted arrays arranged in the form of a matrix of size K*K. The task is to merge them into one sorted array.
Example 1:

Input:
K = 3
arr[][] = {{1,2,3},{4,5,6},{7,8,9}}
Output: 1 2 3 4 5 6 7 8 9
Explanation:Above test case has 3 sorted arrays of size 3, 3, 3
arr[][] = [[1, 2, 3],[4, 5, 6], [7, 8, 9]]
The merged list will be [1, 2, 3, 4, 5, 6, 7, 8, 9].
Example 2:

Input:
K = 4
arr[][]={{1,2,3,4}{2,2,3,4},
         {5,5,6,6},{7,8,9,9}}
Output:
1 2 2 2 3 3 4 4 5 5 6 6 7 8 9 9 
Explanation: Above test case has 4 sorted arrays of size 4, 4, 4, 4
arr[][] = [[1, 2, 2, 2], [3, 3, 4, 4], [5, 5, 6, 6],  [7, 8, 9, 9 ]]
The merged list will be [1, 2, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 8, 9, 9 ].
*/

class Node {
    int row,col;
    public Node(int i, int j) {
        row = i;
        col = j;
    }
    public int getRowIndex() {
        return row;
    }
    public int getColIndex() {
        return col;
    }
}
class Solution
{
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int K) 
    {
        ArrayList<Integer> res = new ArrayList<>();
        if(K == 1) {
            res.add(arr[0][0]);
            return res;
        }
        Queue<Node> aux = new PriorityQueue<>(1, (a,b)->(
            arr[a.getRowIndex()][a.getColIndex()]-arr[b.getRowIndex()][b.getColIndex()]
            ));
        for(int i=0;i<K;i++) 
            aux.add(new Node(i,0));
        
        while(!aux.isEmpty()) {
            Node curr = aux.poll();
            
            int r = curr.getRowIndex(), c = curr.getColIndex();
            res.add(arr[r][c]);
            if(c == K-1)
                continue;
            aux.add(new Node(r,c+1));
        }
        return res;
    }
}
