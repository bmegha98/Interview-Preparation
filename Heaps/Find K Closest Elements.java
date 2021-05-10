/*
Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
*/

class Solution {
    private int binarySearch(int A[],int l, int h, int ele) {
        if(A[l] > ele) 
            return l;
        if(A[h] <= ele) 
            return h;
        int ans =-1;
        while(l<=h){
            int m=l+(h-l)/2;
            if(A[m]<=ele)
                l=m+1;
            else{
                ans=m;
                h=m-1;
            }
        }
        return ans;
    } 
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        List<Integer> res = new ArrayList<>(k);
        if(n==1){
            res.add(arr[0]);
            return res;
           } 
        int pivot = binarySearch(arr,0,n-1,x);
        int l=pivot-1,r=pivot;
        
        for(int i=k-1;i>=0;i--){
            int diff1=Integer. MAX_VALUE,diff2=Integer.MAX_VALUE;
            if(l>=0)
                diff1=x-arr[l];
            if(r<n)
                diff2=arr[r]-x;
            if(l>=0&&r<n) {                     if(diff1<=diff2) 

                l--;
              else
                  r++;
                               
            }
            else if(l<0)
                r++;
            else
                l--;
           } 

         if(l<0)l=0;
        else l++;
        if(r>=n) r=n-1;
        else r--;
        while(l<=r)
            res.add(arr[l++]);

        
        return res;
    }
}
