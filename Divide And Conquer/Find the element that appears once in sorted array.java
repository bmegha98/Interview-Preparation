//Given a sorted array arr[] of size N. Find the element that appears only once in the array. All other elements appear exactly twice. 

class Solution 
{
    int findOnce(int arr[], int n)
    {
        if(n == 1)
            return arr[0];
        int l = 0,r = n-1;
        while(l <= r) {
            int m = l+(r-l)/2;
            if((m==0||arr[m]!=arr[m-1])&&(m==n-1||arr[m]!=arr[m+1]))
                return arr[m];
            if(m%2 == 0 && m < n-1) {
                if(arr[m] == arr[m+1])
                    l = m+1;
                else
                    r = m-1;
            }
            else {
                if(arr[m] == arr[m-1]) 
                    l = m+1;
                else
                    r = m-1;
            }
        }
        return -1;
    }
}
