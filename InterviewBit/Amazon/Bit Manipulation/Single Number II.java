/*
Given an array of integers, every element appears thrice except for one which occurs once.
Find that element which does not appear thrice.
Note: Your algorithm should have a linear runtime complexity.
Could you implement it without using extra memory?
Input Format:

    First and only argument of input contains an integer array A
Output Format:

    return a single integer.
Constraints:

2 <= N <= 5 000 000  
0 <= A[i] <= INT_MAX
For Examples :

Example Input 1:
    A = [1, 2, 4, 3, 3, 2, 2, 3, 1, 1]
Example Output 1:
    4
Explanation:
    4 occur exactly once
Example Input 2:
    A = [0, 0, 0, 1]
Example Output 2:
    1
*/

//Using Sorting
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int singleNumber(final int[] A) {
        int res = 0;
        Arrays.sort(A);
        int i = 0,j;
        while(i < A.length) {
            j = i+1;
            while(j < A.length && A[i] == A[j])
                j++;
            if(j-i == 1)
                return A[i];
            i = j;
        }
        return A[i];
    }
}

/*
Every number that occurs thrice will either contribute 3 ‘1’s or 3 ‘0’s to the position.
The number that occurs once X will contribute exactly one 0 or 1 to the position depending on whether it has 0 or 1 in that position.
So:
If X has 1 in that position, we will have (3x+1) number of 1s in that position.
If X has 0 in that position, we will have (3x+1) number of 0s in that position.
*/
//T(n) = O(n)
public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int singleNumber(final List<Integer> A) {
        int res = 0,mask = 1;
        for(int i = 0;i<32;i++) {
            int tmp = (mask << i);
            int count = 0;
            for(int ele : A) {
                if((ele & tmp) != 0)
                    count++;
            }
            if(count%3 == 1)
                res |= tmp;
        }
        return res;
    }
}
