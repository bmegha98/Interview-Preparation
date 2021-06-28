/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).
The replacement must be in place and use only constant extra memory.
Example 1:

Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:

Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:

Input: nums = [1,1,5]
Output: [1,5,1]
Example 4:

Input: nums = [1]
Output: [1]
*/

class Solution {
    public void nextPermutation(int[] A) {
        int first = -1,second = -1,len = A.length;
        for(int i=len-1;i>0;i--) 
            if(A[i-1] < A[i]) {
                first = i-1;
                break;
            }
        
        if(first == -1) {
            reverse(A,0,len-1);
            return;
        }
        
        for(int j=len-1;j>first;j--)
            if(A[j] > A[first]) {
                second = j;
                break;
            }
        
        swap(A,first,second);
        reverse(A,first+1,len-1);
    }
    private void reverse(int[] A, int i,int j) {
        while(i < j) {
            swap(A,i,j);
            i++;
            j--;
        }
    }
    private void swap(int[] A,int i,int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
