/*
Given a circular array (the next element of the last element is the first element of the array), print the Next Greater Number for every element. The Next Greater
Number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find its next greater number.
If it doesn't exist, output -1 for this number.
*/

//Scan the stack twice
class Solution {
    public int[] nextGreaterElements(int[] nums) 
    {
        int n = nums.length;
        int[] res = new int[n];
        if(n == 0)
            return res;
        Stack<Integer> aux = new Stack<>();
        for(int i = 2*n-1;i>=0;i--)
        {
            int j = i%n;
            while(!aux.isEmpty() && nums[aux.peek()] <= nums[j])
                aux.pop();
            res[j] = aux.isEmpty()?-1:nums[aux.peek()];
            aux.push(j);
        }
        return res;
    }
}
