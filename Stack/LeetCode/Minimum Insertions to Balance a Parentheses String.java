/*
Given a parentheses string s containing only the characters '(' and ')'. A parentheses string is balanced if:

Any left parenthesis '(' must have a corresponding two consecutive right parenthesis '))'.
Left parenthesis '(' must go before the corresponding two consecutive right parenthesis '))'.
In other words, we treat '(' as openning parenthesis and '))' as closing parenthesis.

For example, "())", "())(())))" and "(())())))" are balanced, ")()", "()))" and "(()))" are not balanced.

You can insert the characters '(' and ')' at any position of the string to balance it if needed.

Return the minimum number of insertions needed to make s balanced.
*/

class Solution {
    public int minInsertions(String s) {
        
        int n = s.length();
        if(n == 0)
            return 0;
        if(n == 1)
            return 2;
        int ans = 0;
        Stack<Character> aux = new Stack<>();
        int i = 0;
        while(i < n)
        {
            char ch = s.charAt(i);
            if(ch == '(')
                aux.push(ch);
            else
            {
                if(i == n-1 ||(i < n-1 && s.charAt(i+1) != ')'))
                {
                    if(aux.empty())
                        ans += 2;
                    else
                    {
                        ans += 1;
                        aux.pop();
                    }
                    
                }
                else
                {
                    if(aux.empty())
                        ans += 1;
                    else
                        aux.pop();
                    i++;
                }    
            }
            i++;
        }
        ans += 2*aux.size();
        return ans;
    }
}
