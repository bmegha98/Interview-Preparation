/*
Given an n x n matrix where each of the rows and columns are sorted in ascending order, return the kth smallest element in the matrix.

Note that it is the kth smallest element in the sorted order, not the kth distinct element.
*/

//Using max heap of size k, T(n) = O(n^2logk), Space = O(k)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if(n == 1)
            return matrix[0][0];
        Queue<Integer> aux = new PriorityQueue<>(1,Collections.reverseOrder());
        for(int i =0;i<n;i++)
        {
            for(int j =0;j<n;j++)
            {
                aux.add(matrix[i][j]);
                if(aux.size()>k)
                    aux.poll();
            }
        }
        return aux.poll();
    }
}

//Using min heap, T(n) = O(n+klogn) , space = O(n)

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if(n == 1)
            return matrix[0][0];
        Queue<Pair<Integer,Integer>> aux = new PriorityQueue<>(1,(a,b)->matrix[a.getKey()][a.getValue()]-matrix[b.getKey()][b.getValue()]);
        //build heap from array
        for(int i=0;i<n;i++)
            aux.add(new Pair<>(0,i));
        while(k-- > 1) {
            Pair<Integer,Integer> p = aux.poll();
            if(p.getKey()+1<n)
                aux.add(new Pair<>(p.getKey()+1,p.getValue()));
        }
        
        return matrix[aux.peek().getKey()][aux.peek().getValue()];
    }
}

//Using Binary Search , T(n) = O(n*log(MAX)), space = O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        if(n == 1)
            return matrix[0][0];
        int l = matrix[0][0], r = matrix[n-1][n-1];
        int ans = -1;
        while(l <= r) {
            int m = l+(r-l)/2;
            int count = getCount(matrix,m);
            if(count < k)
                l = m+1;
            else {
                ans = m;
                r = m-1;
            }
        }
        return ans;
    }
    
    int getCount(int[][] A, int m) {
        int n = A.length;
        int i = n-1, j = 0;
        int res = 0;
        while(i >= 0 && j < n) {
            if(A[i][j] > m)
                i--;
            else
            {
                res += (i+1);
                j++;
            }
        }
        return res;
    }
}
