/*
Given a sorted array having N elements, find the indices of the first and last occurrences of an element X in the given array.
Note: If the number X is not found in the array, return '-1' as an array.

Example 1:

Input:
N = 2 , X = 3
arr[] = { 1, 3, 3, 4 }
Output:
1 2
Explanation: For the above array, first occurence of X = 3 is at index = 1 and last occurence is at index = 2.
Example 2:

Input:
N = 4, X = 5
arr[] = { 1, 2, 3, 4 }
Output:
-1
Explanation: As 5 is not present in the array,so the answer is -1.
*/

class Solution{
    public ArrayList<Integer> firstAndLast(int arr[], int n, int x){
        ArrayList<Integer> res = new ArrayList<>();
        int f = firstOccurrence(arr,0,n-1,x);
        res.add(f);
        if(f == -1)
            return res;
        res.add(lastOccurrence(arr,0,n-1,x));
        return res;
    }
    private int firstOccurrence(int[] A,int l,int h,int ele) {
        int ans = -1;
        while(l<=h) {
            int m = l+(h-l)/2;
            if(A[m] == ele) {
                ans = m;
                h = m-1;
            }
            else if(A[m] < ele)
                l = m+1;
            else
                h = m-1;
        }
        return ans;
    }
    private int lastOccurrence(int[] A,int l,int h,int ele) {
        int ans = -1;
        while(l<=h) {
            int m = l+(h-l)/2;
            if(A[m] == ele) {
                ans = m;
                l = m+1;
            }
            else if(A[m] < ele)
                l = m+1;
            else
                h = m-1;
        }
        return ans;
    }
}
