/*
You are given two integer arrays nums1 and nums2 both of unique elements, where nums1 is a subset of nums2.
Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not exist, return -1 for this number.
*/

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) 
    {
        int m = nums1.length,n = nums2.length;
        
        HashMap<Integer,Integer> nextGreaterMap = new HashMap<>();
        Stack<Integer> aux = new Stack<>();
        
        for(int i = n-1;i>=0;i--)
        {
            while(!aux.isEmpty() && nums2[aux.peek()] <= nums2[i])
                aux.pop();
            if(aux.isEmpty())
                nextGreaterMap.put(nums2[i],-1);
            else
                nextGreaterMap.put(nums2[i],nums2[aux.peek()]);
            aux.push(i);
        }
        int res[] = new int[m];
        
        for(int i = 0;i<m;i++)
            res[i] = nextGreaterMap.get(nums1[i]);
        
        return res;
    }
}
