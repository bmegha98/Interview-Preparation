/*
Given a sorted array containing only 0s and 1s, find the transition point. 
Example 1:

Input:
N = 5
arr[] = {0,0,0,1,1}
Output: 3
Explanation: index 3 is the transition 
point where 1 begins.
*/

class GfG {
    int transitionPoint(int arr[], int n) {
        int l = 0,h = n-1,ans = -1;
        while(l <= h) {
            int m = l+(h-l)/2;
            if(arr[m] == 0)
                l = m+1;
            else {
                ans = m;
                h = m-1;
            }
        }
        return ans;
    }

}
