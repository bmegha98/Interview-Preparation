/*
Given a string s of '(' , ')' and lowercase English characters. 
Your task is to remove the minimum number of parentheses ( '(' or ')', in any positions ) so that the resulting parentheses string is valid and return any valid 
string.
Formally, a parentheses string is valid if and only if:

It is the empty string, contains only lowercase characters, or
It can be written as AB (A concatenated with B), where A and B are valid strings, or
It can be written as (A), where A is a valid string.
*/

class Solution {
    public String minRemoveToMakeValid(String s) 
    {
        int n = s.length();
        if(n == 0)
            return s;
        int[] indexSet = new int[n];
        Stack<Pair<Character,Integer>> aux = new Stack<>();
        for(int i =0;i<n;i++)
        {
            char ch = s.charAt(i);
            if(ch == '(')
                aux.push(new Pair<Character,Integer>(ch,i));
            else if(ch == ')')
            {
                if(aux.empty())
                    indexSet[i] = 1;
                else
                    aux.pop();
            }
            else
                continue;
        }
        while(!aux.isEmpty())
        {
            indexSet[aux.peek().getValue()]=1;
            aux.pop();
        }
        
        String res = "";
        for(int i =0;i<n;i++)
            if(indexSet[i] == 0)
                res += s.charAt(i);
        return res;
    }
}
