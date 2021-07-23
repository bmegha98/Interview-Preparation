/*
Given an array of integers, sort the array into a wave like array and return it,
In other words, arrange the elements into a sequence such that a1 >= a2 <= a3 >= a4 <= a5.....

Example

Given [1, 2, 3, 4]

One possible answer : [2, 1, 4, 3]
Another possible answer : [4, 1, 3, 2]
 NOTE : If there are multiple answers possible, return the one thats lexicographically smallest.
So, in example case, you will return [2, 1, 4, 3] 

Input : [5,1,3,2,4]
Output : [2,1,4,3,5]
*/

public class Solution {
    public int[] wave(int[] A) {
        int n = A.length;
        Arrays.sort(A);   //lexicographically smallest
        for(int i=0;i<=n-2;i+=2)
            swap(A,i,i+1);
        return A;
    }
    private void swap(int[] A,int i,int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
