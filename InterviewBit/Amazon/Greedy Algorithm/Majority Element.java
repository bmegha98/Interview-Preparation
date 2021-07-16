/*
Given an array of size n, find the majority element. The majority element is the element that appears more than floor(n/2) times.
You may assume that the array is non-empty and the majority element always exist in the array.

Example :

Input : [2, 1, 2]
Return  : 2 which occurs 2 times which is greater than 3/2. 
*/

//Using Sorting
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int majorityElement(final int[] A) {
        Arrays.sort(A);
        return A[A.length/2];
    }
}


//Moore's voting algorithm
public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int majorityElement(final int[] A) {
        int count = 1, res = A[0];
        for(int i=1;i<A.length;i++) {
            if(A[i] == res)
                count++;
            else
                count--;
            if(count == 0) {
                res = A[i];
                count = 1;
            }
        }
        return res;
    }
}
