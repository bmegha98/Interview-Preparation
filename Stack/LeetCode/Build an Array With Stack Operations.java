/*
Given an array target and an integer n. In each iteration, you will read a number from  list = {1,2,3..., n}.

Build the target array using the following operations:

Push: Read a new element from the beginning list, and push it in the array.
Pop: delete the last element of the array.
If the target array is already built, stop reading more elements.
Return the operations to build the target array. You are guaranteed that the answer is unique.
*/

class Solution {
    public List<String> buildArray(int[] target, int n) 
    {
        List<String> res = new ArrayList<>();
        
        int pos = 0;
        for(int i = 1;i<=n&&pos<target.length;i++)
        {
            res.add("Push");
            if(target[pos] == i)
                pos++;
            else
                res.add("Pop");
        }
        return res;
    }
}
