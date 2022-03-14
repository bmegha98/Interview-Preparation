/*
There are N bags with diamonds in them. The i'th of these bags contains Ai diamonds. If you drop a bag with P diamonds, it changes to [P/2] diamonds, and you 
gain P diamonds, where [p] is the greatest integer less than p. Dropping a bag takes 1 minute. Find the maximum number of diamonds that you can take if you are
given K minutes.
Example 1:

Input:
N = 5, K = 3
A[] = {2, 1, 7, 4, 2}
Output:
14
Explanation:
The state of bags is:
2 1 7 4 2
You take all diamonds from Third bag (7).
The state of bags becomes: 2 1 3 4 2 
Take all diamonds from Fourth bag (4).
The state of bags becomes: 2 1 3 2 2
Take all diamonds from Third bag (3).
The state of bags becomes: 2 1 1 2 2 
Hence, number of Diamonds = 7+4+3 = 14.
Example 2:

Input:
N = 3, K = 2
A[] = {7, 1, 2}
Output:
10
Explanation:
You can take a maximum of 10 diamonds.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function maxDiamonds() which takes 2 Integers N, and K and an integer and an array
A[] of N integers as input and returns the maximum number of diamonds you can take in K minutes.
*/
//T(n) = O(nlogn), Space = O(n)
class Solution {
    static int maxDiamonds(int[] A, int N, int K) {
        // code here
        Queue<Integer> q = new PriorityQueue<>(1,(a,b)->b-a);
        for(int ele : A)
            q.add(ele);
        
        int sum = 0;
        while(!q.isEmpty() && K > 0) {
            int curr = q.poll();
            sum += curr;
            q.add(curr/2);
            K--;
        }
        
        return sum;
    }
}
