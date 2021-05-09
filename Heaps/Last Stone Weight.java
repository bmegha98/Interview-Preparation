/*
We have a collection of stones, each stone has a positive integer weight.

Each turn, we choose the two heaviest stones and smash them together.  Suppose the stones have weights x and y with x <= y.  The result of this smash is:

If x == y, both stones are totally destroyed;
If x != y, the stone of weight x is totally destroyed, and the stone of weight y has new weight y-x.
At the end, there is at most 1 stone left.  Return the weight of this stone (or 0 if there are no stones left.)
*/

class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;
        if(n == 1)
            return stones[0];
        Queue<Integer> aux = new PriorityQueue<>(1, Collections.reverseOrder());
        
        for(int i = 0;i<n;i++)
            aux.add(stones[i]);
        while(aux.size() > 1) {
            int x = aux.poll();
            int y = aux.poll();
            if(x != y)
                aux.add(x-y);
        }
        return aux.isEmpty()?0:aux.poll();
    }
}
