/*
Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.  Elements that don't appear in arr2 should be placed at the end
of arr1 in ascending order.
Example 1:

Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
Output: [2,2,2,1,4,3,3,9,6,7,19]
*/

class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> aux = new TreeMap<>();
        int[] res = new int[arr1.length];
        int k = 0;
        for(int ele : arr1)
            aux.put(ele,aux.getOrDefault(ele,0)+1);
        
        for(int ele : arr2)
            if(aux.containsKey(ele)) {
                int freq = aux.get(ele);
                while(freq-- > 0) 
                    res[k++] = ele;
                aux.remove(ele);
            }
        
        for(Map.Entry<Integer,Integer> entry : aux.entrySet()) {
            int ele = entry.getKey(), freq = entry.getValue();
            while(freq-- > 0) 
                res[k++] = ele;
        }
        
        return res;
    }
}
