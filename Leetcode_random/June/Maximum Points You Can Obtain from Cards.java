/*
There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.

In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.

Your score is the sum of the points of the cards you have taken.

Given the integer array cardPoints and the integer k, return the maximum score you can obtain.

 

Example 1:

Input: cardPoints = [1,2,3,4,5,6,1], k = 3
Output: 12
Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first will maximize your total score. The optimal 
strategy is to take the three cards on the right, giving a final score of 1 + 6 + 5 = 12.
Example 2:

Input: cardPoints = [2,2,2], k = 2
Output: 4
Explanation: Regardless of which two cards you take, your score will always be 4.
Example 3:

Input: cardPoints = [9,7,7,9,7,7,9], k = 7
Output: 55
Explanation: You have to take all the cards. Your score is the sum of points of all cards.
 

Constraints:

1 <= cardPoints.length <= 105
1 <= cardPoints[i] <= 104
1 <= k <= cardPoints.length
*/
//Find min sum (n-k) length subarray
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if(n == 1)
            return cardPoints[0];
        
        int size = n-k,totalSum = 0;
        for(int ele : cardPoints)
            totalSum += ele;
        
        int maxSum = 0, left = 0, right = 0, sum = 0;
        for(;right<size;right++)
            sum += cardPoints[right];
        
        while(right < n) {
            maxSum = Math.max(maxSum, totalSum-sum);
            // System.out.println(maxSum);
            sum += (cardPoints[right]-cardPoints[left]);
            left++;
            right++;
        }
        maxSum = Math.max(maxSum, totalSum-sum);
        return maxSum;
    }
}
