/*
Given an array arr[] of integers of size N that might contain duplicates, the task is to find all possible unique subsets.

Note: Each subset should be sorted.

Example 1:

Input: N = 3, arr[] = {2,1,2}
Output:(),(1),(1 2),(1 2 2),(2),(2 2)
Explanation: 
All possible subsets = (),(2),(1),(1,2),(2),(2,2),(2,1),(2,1,2)
After Sorting each subset = (),(2),(1),(1,2),(2),(2,2),(1,2),(1,2,2) 
Unique Susbsets in Lexicographical order = (),(1),(1,2),(1,2,2),(2),(2,2)
Example 2:

Input: N = 4, arr[] = {1,2,3,3}
Output: (),(1),(1 2),(1 2 3)
(1 2 3 3),(1 3),(1 3 3),(2),(2 3)
(2 3 3),(3),(3 3)
Your Task:
Your task is to complete the function AllSubsets() which takes the array arr[] and N as input parameters and returns list of all possible unique subsets in
lexicographical order. 

Expected Time Complexity: O(2N).
Expected Auxiliary Space: O(2N * X), X = Length of each subset.
*/

class solve
{
    static ArrayList <ArrayList <Integer>> res;
    //Function to find all possible unique subsets.
    public static ArrayList <ArrayList <Integer>> AllSubsets(int arr[], int n)
    {
        // your code here
        Arrays.sort(arr);
        res = new ArrayList<>();
        helper(arr,0,n,new ArrayList<>());
        res.remove(0);
        return res;
    }
    private static void helper(int[] A, int ind, int n, List<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for(int i=ind;i<n;i++) {
            if(i>ind && A[i] == A[i-1])
                continue;
            tmp.add(A[i]);
            helper(A,i+1,n,tmp);
            tmp.remove(tmp.size()-1);
        }
    }
}
