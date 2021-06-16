/*
Given an array of integers. Check whether it contains a triplet that sums up to zero. 
Example 1:

Input: n = 5, arr[] = {0, -1, 2, -3, 1}
Output: 1
Explanation: 0, -1 and 1 forms a triplet
with sum equal to 0.
*/

//T(n) = O(n^2) , Space = O(1)

class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
        Arrays.sort(arr);
        for(int i=0;i<=n-3;i++) {
            int l = i+1,h = n-1;
            while(l<h) {
                int s = arr[i]+arr[l]+arr[h];
                if(s == 0)
                    return true;
                if(s < 0)
                    l++;
                else
                    h--;
            }
        }
        return false;
    }
}

//Using hashset
class Solution
{
    // arr[]: input array
    // n: size of the array
    //Function to find triplets with zero sum.
	public boolean findTriplets(int arr[] , int n)
    {
        for(int i=0;i<n-1;i++) {
            Set<Integer> aux = new HashSet<>();
            for(int j = i+1;j<n;j++) {
                int s = -1*(arr[i]+arr[j]);
                if(aux.contains(s))
                    return true;
                aux.add(arr[j]);
            }
        }
        return false;
    }
}
