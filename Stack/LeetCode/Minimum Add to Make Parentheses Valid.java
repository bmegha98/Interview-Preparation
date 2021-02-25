/*
Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')', and in any positions ) so that the resulting parentheses string
is valid.

Formally, a parentheses string is valid if and only if:

It is the empty string, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
*/

class Solution {
    public int minAddToMakeValid(String S) 
    {
        int n = S.length();
        if(n < 2)
            return n;
        /*
        Stack<Character> aux = new Stack<>();
        int count = 0;
        for(char ch : S.toCharArray())
        {
            if(ch == '(')
                aux.push(ch);
            else
            {
                if(aux.isEmpty())
                    count++;
                else
                    aux.pop();
            }
        }
        count += aux.size();
        return count;
        */
        int count = 0,res = 0;
        for(int i =0;i<n;i++)
        {
            char ch = S.charAt(i);
            if(ch == '(')
                count++;
            else
                count--;
            if(count < 0)
            {
                res += 1;
                count = 0;
            }
        }
        res += count;
        return res;
    }
}
