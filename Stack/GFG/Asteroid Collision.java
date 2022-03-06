/*
We are given an array asteroids of integers representing asteroids in a row.

For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid
moves at the same speed.

Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. 
Two asteroids moving in the same direction will never meet.

Example 1:

Input: asteroids = [5,10,-5]
Output: [5,10]
Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
Example 2:

Input: asteroids = [8,-8]
Output: []
Explanation: The 8 and -8 collide exploding each other.
Example 3:

Input: asteroids = [10,2,-5]
Output: [10]
Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 

Constraints:

2 <= asteroids.length <= 104
-1000 <= asteroids[i] <= 1000
asteroids[i] != 0
*/


class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        int n = asteroids.length;
        
        Stack<Integer> aux = new Stack<>();
        
        for(int ele : asteroids) {
            if(aux.isEmpty() || ele > 0)
                aux.push(ele);
            else {
                int last = -1;
                while(!aux.isEmpty()) {
                    last = aux.peek();
                    if(last < 0) {
                        aux.push(ele);
                        break;
                    }
                    else if(last < Math.abs(ele))
                        aux.pop();
                    else if(last == Math.abs(ele)) {
                        aux.pop();
                        break;
                    }
                    else
                        break;
                }
                if(aux.isEmpty() && last < Math.abs(ele))
                    aux.push(ele);
            }
        }
        
        int size = aux.size();
        int[] res = new int[size];
        int k = size-1;
        while(!aux.isEmpty())
            res[k--] = aux.pop();
        return res;
    }
}
