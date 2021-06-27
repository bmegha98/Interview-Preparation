/*
Given an array H representing heights of buildings. You have to count the buildings which will see the sunrise (Assume : Sun rise on the side of array starting 
point).
Input: 
N = 5
H[] = {7, 4, 8, 2, 9}
Output: 3
Explanation: As 7 is the first element, it can see the sunrise. 4 can't see the sunrise as 7 is hiding it.  8 can see. 2 can't see the sunrise. 9 also can see
the sunrise.

It can be easily observed that only the maximum element found so far will see the sunlight
i.e. curr_max will see the sunlight and then only the element greater than curr_max will see the sunlight.
*/

class Solution {
    int countBuildings(int h[], int n) {
        int max = h[0],count = 1;
        for(int i=1;i<n;i++) 
            if(h[i] > max) {
                max = h[i];
                count++;
            }
        return count;
    }
}
