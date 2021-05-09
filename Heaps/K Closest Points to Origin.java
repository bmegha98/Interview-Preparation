/*
Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane and an integer k, return the k closest points to the origin (0, 0).

The distance between two points on the X-Y plane is the Euclidean distance (i.e., √(x1 - x2)2 + (y1 - y2)2).

You may return the answer in any order. The answer is guaranteed to be unique (except for the order that it is in).
*/

class Solution {
    private int distance(Pair<Integer,Integer> p) {
        int x = p.getKey(), y = p.getValue();
        return x*x + y*y;
    }
    
    public int[][] kClosest(int[][] points, int k) {
        int n = points.length;
        if(n == 1)
            return points;
        PriorityQueue<Pair<Integer,Integer>> aux = new PriorityQueue<>(1, 
                                                (a,b)->distance(b)-distance(a));
        for(int i =0;i<n;i++) {
            aux.add(new Pair<>(points[i][0],points[i][1]));
            if(aux.size() > k)
                aux.poll();
        }
        int[][] res = new int[k][2];
        
        for(int i =0;i<k;i++)
        {
            Pair<Integer,Integer> p = aux.poll();
            res[i][0] = p.getKey();
            res[i][1] = p.getValue();
        }
        return res;
    }
}
