/*
There are N children standing in a line. Each child is assigned a rating value.
You are giving candies to these children subjected to the following requirements:
1. Each child must have at least one candy.
2. Children with a higher rating get more candies than their neighbors.
What is the minimum candies you must give?

Input Format:
The first and the only argument contains N integers in an array A.
Output Format:

Return an integer, representing the minimum candies to be given.
Example:

Input 1:
    A = [1, 2]

Output 1:
    3

Explanation 1:
    The candidate with 1 rating gets 1 candy and candidate with rating cannot get 1 candy as 1 is its neighbor. 
    So rating 2 candidate gets 2 candies. In total, 2 + 1 = 3 candies need to be given out.

Input 2:
    A = [1, 5, 2, 1]

Output 2:
    7

Explanation 2:
    Candies given = [1, 3, 2, 1]
    
First count candies based on the left neighbour and then the right neighbour
A = [1, 3, 3, 3, 1]
count[] = [1, 1, 1, 1, 1]       //Every child must have atleast 1 candy
based on the left neighbour
count[] = [1, 2, 1, 1, 1]       //if(A[i] > A[i-1]) then count[i] = max(count[i],count[i-1]+1)
based on the right neighbour
count[] = [1, 2, 1, 2, 1]       //if(A[i] > A[i+1]) then count[i] = max(count[i],count[i+1]+1)

res = 7
*/

public class Solution {
    public int candy(int[] A) {
        int n = A.length;
        if(n == 1)
            return 1;
        
        int[] tmp = new int[n];
        //Each child will have atleast one candy
        tmp[0] = 1;
        //Acc to left neighbour
        for(int i=1;i<n;i++) {
            tmp[i] = 1;
            if(A[i] > A[i-1])
                tmp[i] = Math.max(tmp[i], tmp[i-1]+1);
        }
        //Acc to right neighbour
        int res = tmp[n-1];
        for(int i=n-2;i>=0;i--) {
            if(A[i] > A[i+1])
                tmp[i] = Math.max(tmp[i], tmp[i+1]+1);
            res += tmp[i];
        }
        return res;
    }
}
