/*
Given an array of integers, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 < index2. Please note that your returned answers
(both index1 and index2 ) are not zero-based. Put both these numbers in order in an array and return the array from your function ( Looking at the function 
signature will make things clearer ). Note that, if no pair exists, return empty list.

If multiple solutions exist, output the one where index2 is minimum. If there are multiple solutions with the minimum index2, choose the one with minimum index1 
out of them.  Input: [2, 7, 11, 15], target=9 Output: index1 = 1, index2 = 2 
*/

public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] twoSum(final int[] A, int B) {
        int n = A.length;
        Map<Integer,Integer> aux = new HashMap<>();
        for(int i=0;i<n;i++) {
            int s = B-A[i];
            if(aux.containsKey(s))
                return new int[]{aux.get(s)+1,i+1};
            if(!aux.containsKey(A[i]))    //if already exists then current index will definitely be greater than existing one
                aux.put(A[i],i);
        }
        return new int[0];
    }
}
