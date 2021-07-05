/*
Given an array of distinct integers. The task is to count all the triplets such that sum of two elements equals the third element.
 
Example 1:

Input:
N = 4
arr[] = {1, 5, 3, 2}
Output: 2
Explanation: There are 2 triplets: 
1 + 2 = 3 and 3 +2 = 5 
â€‹Example 2:

Input: 
N = 3
arr[] = {2, 3, 4}
Output: 0
Explanation: No such triplet exits
*/

class Solution {
    int countTriplet(int arr[], int n) {
        Arrays.sort(arr);
        int count = 0;
        for(int i=n-1;i>1;i--) {
            int l = 0,h = i-1;
            while(l<h) {
                int s = arr[l]+arr[h];
                if(s == arr[i]) {
                    count++;
                    l++;        //No duplicates
                    h--;
                }
                else if(s < arr[i])
                    l++;
                else
                    h--;
            }
        }
        return count;
    }
}
