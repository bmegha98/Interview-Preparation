/*
Given two sequences pushed and popped with distinct values, return true if and only if this could have been the result of a sequence of push and pop operations on 
an initially empty stack.
*/

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) 
    {
        int m = pushed.length,n = popped.length;
        if(n == 0)
            return true;
        if(m == 0)
            return n == 0?true:false;
        
        Stack<Integer> aux = new Stack<>();
        int i = 0,j = 0;
        while(i < m)
        {
            if(pushed[i] == popped[j])
            {
                i++;
                j++;
            }
            else if(!aux.isEmpty() && aux.peek() == popped[j])
            {
                aux.pop();
                j++;
            }
            else
            {
                aux.push(pushed[i]);
                i++;
            }
        }
        while(j < n && !aux.isEmpty())
        {
            if(aux.peek() != popped[j])
                return false;
            aux.pop();
            j++;
        }
        return true; 
    }
}
