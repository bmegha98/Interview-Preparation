//Given an array of integers. Check whether it contains a triplet that sums up to zero. 

class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
        //add code here.
        if(n < 3)
            return false;
        Arrays.sort(arr);
        for(int i = 0;i<n-2;i++) {
            int l = i+1,r = n-1;
            while(l < r) {
                int s = arr[i]+arr[l]+arr[r];
                if(s == 0)
                    return true;
                if(s < 0)
                    l++;
                else
                    r--;
            }
        }
        return false;
    }
}
