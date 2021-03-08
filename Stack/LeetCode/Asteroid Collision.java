/*
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid
moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two 
asteroids moving in the same direction will never meet.
*/

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        
        int n = asteroids.length;
        Stack<Integer> aux = new Stack<>();
        for(int i =0;i<n;i++)
        {
            if(aux.isEmpty() || asteroids[i] > 0)
                aux.push(asteroids[i]);
            else
            {
                int topEle = aux.peek();
                while(!aux.isEmpty())
                {
                    topEle = aux.peek();
                    if(topEle < 0)
                    {
                        aux.push(asteroids[i]);
                        break;
                    }
                    if(topEle > Math.abs(asteroids[i]))
                        break;
                    if(topEle == Math.abs(asteroids[i]))
                    {
                        aux.pop();
                        break;
                    }
                    aux.pop();
                }
                if(aux.isEmpty() && topEle < Math.abs(asteroids[i]))
                    aux.push(asteroids[i]);
            }
        }
        int len = aux.size();
        int[] res = new int[len];
        int i = len-1;
        while(!aux.isEmpty())
            res[i--] = aux.pop();
        return res;
    }
}
