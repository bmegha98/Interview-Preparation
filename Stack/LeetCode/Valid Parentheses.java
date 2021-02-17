/*
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
*/

class Solution {
    public boolean isValid(String s) 
    {
        int n = s.length();
        if(n == 0)
            return true;
        if(n == 1)
            return false;
        
        Stack<Character> aux = new Stack<>();
        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            if(ch == '('||ch == '[' || ch == '{')
                aux.push(ch);
            else
            {
                if(aux.isEmpty() || !match(aux.peek(),ch))
                    return false;
                aux.pop();
            }
        }
        return aux.isEmpty()?true:false;
    }
    boolean match(char open,char close)
    {
        if(open == '(' && close == ')')
            return true;
        if(open == '[' && close == ']')
            return true;
        if(open == '{' && close == '}')
            return true;
        return false;
    }
}
