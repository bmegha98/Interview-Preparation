/*
Given an array of integers and a number k, write a function that returns true if given array can be divided into pairs such that sum of every pair is divisible
by k.
Example 1 :

Input : arr = [9, 5, 7, 3], k = 6
Output: True
Explanation: {(9, 3), (5, 7)} is a 
possible solution. 9 + 3 = 12 is divisible
by 6 and 7 + 5 = 12 is also divisible by 6.

Example 2:

Input : arr = [2, 4, 1, 3], k = 4
Output: False
Explanation: There is no possible solution.
 

Your Task:
You don't need to read or print anything. Your task is to complete the function canPair() which takes array and k as input parameter and returns true if array can
be divided into pairs such that sum of every pair is divisible by k otherwise returns false.
*/

class Solution {
    public boolean canPair(int[] nums, int k) {
        // Code here
        int[] aux = new int[k];
        for(int ele : nums)
            aux[ele%k]++;
        
        if(aux[0]%2 == 1)
            return false;
        int i=1,j = k-1;
        while(i<j) {
            if(aux[i] != aux[j])
                return false;
            i++;
            j--;
        }
        if(i == j && aux[i]%2 == 1)
            return false;
        return true;
    }
}
