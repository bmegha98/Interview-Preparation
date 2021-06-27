/*
Given two unsorted arrays arr1[] and arr2[]. They may contain duplicates. For each element in arr1[] count elements less than or equal to it in array arr2[].
Example 1:

Input:
m = 6, n = 6
arr1[] = {1,2,3,4,7,9}
arr2[] = {0,1,2,1,1,4}
Output: 4 5 5 6 6 6
Explanation: Number of elements less than or equal to 1, 2, 3, 4, 7, and 9 in the second array are respectively 4,5,5,6,6,6
*/

class Solution
{
    public static ArrayList<Integer> countEleLessThanOrEqual(int arr1[], int arr2[],
    int m, int n)
    {
       ArrayList<Integer> res = new ArrayList<>();
       Arrays.sort(arr2);
       
       for(int ele : arr1) {
           int ind = binarySearch(arr2, ele);
           res.add(ind);
       }
       return res;
    }
    private static int binarySearch(int[] A, int x) {
        int l =0,h = A.length-1,ans = A.length;
        while(l <= h) {
            int m = l+(h-l)/2;
            if(A[m] <= x)
                l = m+1;
            else {
                ans = m;
                h = m-1;
            }
        }
        return ans;
    }
}
