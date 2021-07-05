/*
Given an array of n integers(duplicates allowed). Print “Yes” if it is a set of contiguous integers else print “No”.
Example 1:

Input : arr[ ] = {5, 2, 3, 6, 4, 4, 6, 6}
Output : Yes
Explanation:
The elements  of array form a contiguous set of integers which is {2, 3, 4, 5, 6} so the output is "Yes".

Example 2:
Input : arr[ ] = {10, 14, 10, 12, 12, 13, 15} 
Output : No
*/

//T(n) = O(nlogn), Space = O(n)
class Solution{
    // Function for finding maximum and value pair
    public static boolean areElementsContiguous (int arr[], int n) {
        Set<Integer> aux = new TreeSet<>();
        
        for(int ele : arr)
            aux.add(ele);
        
        int prev = -1;
        for(Integer i : aux) {
            if(prev != -1 && i-prev > 1)
                return false;
            prev = i;
        }
        return true;
    }
}

//T(n) = O(n) , Space = O(n)
class Solution{
    // Function for finding maximum and value pair
    public static boolean areElementsContiguous (int arr[], int n) {
        if(n == 1)
            return true;
            
        Set<Integer> aux = new HashSet<>();
        int min = Math.min(arr[0],arr[1]);
        int max = Math.max(arr[0],arr[1]);
        aux.add(min);
        aux.add(max);
        
        for(int i=2;i<n;i++) {
            if(max < arr[i])
                max = arr[i];
            else if(min > arr[i])
                min = arr[i];
            aux.add(arr[i]);
        }
        
        while(min <= max) {
            if(!aux.contains(min))
                return false;
            min++;
        }
        return true;
    }
}
