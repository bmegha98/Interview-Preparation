/*
Given an array of integers and another number. Find all the unique quadruple from the given array that sums up to the given number.

Example 1:

Input:
N = 5, K = 3
A[] = {0,0,2,1,1}
Output: 0 0 1 2 $
Explanation: Sum of 0, 0, 1, 2 is equal
to K.
Example 2:

Input:
N = 7, K = 23
A[] = {10,2,3,4,5,7,8}
Output: 2 3 8 10 $2 4 7 10 $3 5 7 8 $
Explanation: Sum of 2, 3, 8, 10 = 23,
sum of 2, 4, 7, 10 = 23 and sum of 3,
5, 7, 8 = 23.
*/

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = arr.length;
        if(n < 4)
            return res;
        Arrays.sort(arr);
        
        for(int i=0;i<=n-4;i++) {
            if(i>0 && arr[i] == arr[i-1])
                continue;
            for(int j=i+1;j<=n-3;j++) {
                if(j > i+1 && arr[j] == arr[j-1])
                    continue;
                int l = j+1, h = n-1;
                while(l<h) {
                    int s = arr[i]+arr[j]+arr[l]+arr[h];
                    if(s == k) {
                        ArrayList<Integer> tmp = new ArrayList<>();
                        tmp.add(arr[i]);
                        tmp.add(arr[j]);
                        tmp.add(arr[l]);
                        tmp.add(arr[h]);
                        
                        res.add(tmp);
                        l++;
                        h--;
                        
                        while(l < h && arr[l] == arr[l-1])
                            l++;
                        while(l < h && arr[h] == arr[h+1])
                            h--;
                    }
                    else if(s < k)
                        l++;
                    else
                        h--;
                }
            }
        }
        return res;
    }
}
