/*
Given an array arr[] of N weights. Find the least weight capacity of a boat to ship all weights within D days.
Note: You have to load weights on the ship in the given order.
Example 1:

Input:
N = 3
arr[] = {1, 2, 1}
D = 2
Output:
3
Explanation:
We can ship the weights in 2 days in the following way:-
Day 1- 1,2
Day 2- 1

Example 2:
Input:
N = 3
arr[] = {9, 8, 10}
D = 3
Output:
10
Explanation:
We can ship the weights in 3 days in the following way:-
Day 1- 9
Day 2- 8
Day 3- 10
*/

class Solution {
    static int leastWeightCapacity(int[] arr, int N, int D) {
        int minWeight = getMax(arr);
        int maxWeight = getSum(arr);
        
        int ans = -1;
        while(minWeight <= maxWeight) {
            int mid = minWeight+(maxWeight-minWeight)/2;        //boatCapacity
            int daysReq = getDays(arr, mid);
            
            if(daysReq > D)
                minWeight = mid+1;
            else {
                ans = mid;
                maxWeight = mid-1;
            }
        }
        return ans;
    }
    
    static int getMax(int[] A) {
        int max = 0;
        for(int ele : A)
            if(ele > max)
                max = ele;
        return max;
    }
    
    static int getSum(int[] A) {
        int s = 0;
        for(int ele : A)
            s += ele;
        return s;
    }
    
    static int getDays(int[] A, int weight) {
        int days = 1;
        int totalWeight = 0;
        for(int ele : A) {
            totalWeight += ele;
            if(totalWeight > weight) {
                days++;
                totalWeight = ele;
            }
        }
        return days;
    }
}
