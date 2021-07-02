/*
Given an array Arr[] of size L and a number N, you need to write a program to find if there exists a pair of elements in the array whose difference is N.
Example 1:

Input:
L = 6, N = 78
arr[] = {5, 20, 3, 2, 5, 80}
Output: 1
Explanation: (2, 80) have difference of 78.
Example 2:

Input:
L = 5, N = 45
arr[] = {90, 70, 20, 80, 50}
Output: -1
Explanation: There is no pair with difference of 45.
*/

//using set
class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        Set<Integer> aux = new HashSet<>();
        for(int ele : arr) {
            if(aux.contains(ele+n) || aux.contains(ele-n))
                return true;
            aux.add(ele);
        }
        return false;
    }
}

//using sorting

class Solution
{
    public boolean findPair(int arr[], int size, int n)
    {
        Arrays.sort(arr);
        int i=0,j = 1;
        while(i<size && j<size) {
            int diff = arr[j]-arr[i];
            if(diff == n)
                return true;
            if(diff < n)    //diff is increased by maximizing arr[j] 
                j++;
            else
                i++;        //diff is reduced by maximizing arr[i]
        }
        return false;
    }
}