/*
Given an array of integers A of size N and an integer B.array A is rotated at some pivot unknown to you beforehand.
(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
You are given a target value B to search. If found in the array, return its index, otherwise return -1.
You may assume no duplicate exists in the array.

NOTE:- Array A was sorted in non-decreasing order before rotation.

NOTE : Think about the case when there are duplicates. Does your current solution work? How does the time complexity change?*
Input Format

The first argument given is the integer array A.
The second argument given is the integer B.
Output Format

Return index of B in array A, otherwise return -1
Constraints

1 <= N <= 1000000
1 <= A[i] <= 10^9
all elements in A are disitinct.
For Example

Input 1:
    A = [4, 5, 6, 7, 0, 1, 2, 3]
    B = 4
Output 1:
    0
Explanation 1:
 Target 4 is found at index 0 in A.


Input 2:
    A = [5, 17, 100, 3]
    B = 6
Output 2:
    -1
*/

//No Duplicates

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int search(final List<Integer> A, int B) {
        int n = A.size();
        if(n == 1)
            return A.get(0)==B?0:-1;
        
        int l = 0,h = n-1;
        while(l <= h) {
            int m = l+(h-l)/2;
            if(A.get(m) == B)
                return m;
            if(A.get(l) <= A.get(m)) {
                if(A.get(l) <= B && B <= A.get(m))
                    h = m-1;
                else
                    l = m+1;
            }
            else {
                if(A.get(m) <= B && B <= A.get(h))
                    l = m+1;
                else
                    h = m-1;
            }
        }
        return -1;
    }
}

//With Duplicates

class Solution {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n == 1)
            return nums[0]==target?true:false;
        int l =0,h=n-1;
        while(l <= h) {
            int m = l+(h-l)/2;
            if(nums[m] == target)
                return true;
            if(nums[l] == nums[m]) {
                l++;
            }
            else if(nums[l] < nums[m]) {
                if(target >= nums[l] && target <= nums[m])
                    h = m-1;
                else
                    l = m+1;
            }
            else {
                if(target >= nums[m] && target <= nums[h])
                    l = m+1;
                else
                    h = m-1;
            }
        }
        return false;
    }
}
