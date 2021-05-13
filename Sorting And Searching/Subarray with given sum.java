/*
Given an unsorted array A of size N that contains only non-negative integers, find a continuous sub-array which adds to a given number S.
Example 1:

Input:
N = 5, S = 12
A[] = {1,2,3,7,5}
Output: 2 4
Explanation: The sum of elements 
from 2nd position to 4th position 
is 12.
*/

class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int S) 
    {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(n == 1) {
            if(S == arr[0]){
                res.add(1);
                res.add(1);
            }
            else
                res.add(-1);
            return res;
        }
        
        int l = 0, r = 0, sum = 0;
        boolean found = false;
        while(r < n) {
            sum += arr[r++];
            if(sum < S)
                continue;
            else if(sum > S){
                while(l < r-1 && sum > S) 
                    sum -= arr[l++];
                if(sum == S)
                {
                    found = true;
                    break;
                }
            }
            else
            {
                found = true;
                break;
            }
        }
        
        if(found) {
            res.add(l+1);
            res.add(r);
        }
        else
            res.add(-1);
        return res;
    }
}
