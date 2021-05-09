/*
There is a special kind of apple tree that grows apples every day for n days. On the ith day, the tree grows apples[i] apples that will rot after days[i] days, 
that is on day i + days[i] the apples will be rotten and cannot be eaten. On some days, the apple tree does not grow any apples, which are denoted by 
apples[i] == 0 and days[i] == 0.

You decided to eat at most one apple a day (to keep the doctors away). Note that you can keep eating after the first n days.

Given two integer arrays days and apples of length n, return the maximum number of apples you can eat.
Example 1:

Input: apples = [1,2,3,5,2], days = [3,2,1,4,2]
Output: 7
Explanation: You can eat 7 apples:
- On the first day, you eat an apple that grew on the first day.
- On the second day, you eat an apple that grew on the second day.
- On the third day, you eat an apple that grew on the second day. After this day, the apples that grew on the third day rot.
- On the fourth to the seventh days, you eat apples that grew on the fourth day.
*/

class Solution {
    static class Basket {
        int appleCount;
        int expiredDay;
        public Basket(int a, int d) {
            appleCount = a;
            expiredDay = d;
        }
    }
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        if(n == 1)
            return Math.min(apples[0], days[0]);
        
        //Exceute loop until are apples are consumed or rotten
        Queue<Basket> aux = new PriorityQueue<>(1,(a,b)->a.expiredDay-b.expiredDay);
        int i =0, res = 0;
        while(i < n || !aux.isEmpty()) {
            while(!aux.isEmpty() && (aux.peek().appleCount==0 || aux.peek().expiredDay <= i))
                aux.poll();
            if(i< n && apples[i] > 0 && days[i]> 0)
                aux.add(new Basket(apples[i],i+days[i]));
            if(!aux.isEmpty()) {
                aux.peek().appleCount--;
                res++;
            }
            i++;
        }
        return res;
    }
}
