/*
Given an array of integers and another number. Find all the unique quadruple from the given array that sums up to the given number.
Example 1:

Input:
N = 5, K = 3
A[] = {0,0,2,1,1}
Output: 0 0 1 2 $
Explanation: Sum of 0, 0, 1, 2 is equal to K.
Example 2:

Input:
N = 7, K = 23
A[] = {10,2,3,4,5,7,8}
Output: 2 3 8 10 $2 4 7 10 $3 5 7 8 $
Explanation: Sum of 2, 3, 8, 10 = 23,sum of 2, 4, 7, 10 = 23 and sum of 3, 5, 7, 8 = 23.
Your Task:
You don't need to read input or print anything. Your task is to complete the function fourSum() which takes the array arr[] and the integer k as its input and 
returns an array containing all the quadruples in a lexicographical manner. Also note that all the quadruples should be internally sorted, ie for any quadruple 
[q1, q2, q3, q4] the following should follow: q1 <= q2 <= q3 <= q4.  (In the output each quadruple is separate by $. The printing is done by the driver's code)
*/

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = arr.length;
        if(n < 4)
            return res;
        Arrays.sort(arr);
        for(int i=0;i<n-3;i++) {
            if(i>0 && arr[i] == arr[i-1])
                continue;
            int a = arr[i];
            for(int j= i+1;j<n-2;j++) {
                if(j >i+1 && arr[j]==arr[j-1])
                    continue;
                int b = arr[j];
                int l = j+1,r = n-1;
                while(l < r) {
                    int c = arr[l],d = arr[r];
                    int s = a+b+c+d;
                    if(s < k)
                        l++;
                    else if(s > k)
                        r--;
                    else {
                        ArrayList<Integer> tmp = new ArrayList<Integer>(){{
                            add(a);
                            add(b);
                            add(c);
                            add(d);
                        }};
                        res.add(tmp);
                        while(l<r && arr[l] == c)
                            l++;
                        while(l<r && arr[r] == d)
                            r--;
                    }
                }
            }
        }
        return res;
    }
}
