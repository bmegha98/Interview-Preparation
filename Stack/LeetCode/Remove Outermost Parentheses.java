/*
A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  
For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses 
strings.
Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
*/

class Solution {
    public String removeOuterParentheses(String S) 
    {
        if(S.isEmpty())
            return S;
        String res = "";
        /*
        int level = -1;
        
        for(int i =0;i<S.length();i++)
        {
            char ch = S.charAt(i);
            if(ch == '(')
            {
                level++;
                if(level != 0)
                    res += ch;
            }
            else
            {
                level--;
                if(level != -1)
                    res += ch;
            }
        }
        return res;
        */
        Stack<Character> aux = new Stack<>();
        for(int i =0;i<S.length();i++)
        {
            char ch = S.charAt(i);
            if(ch == '(')
            {
                if(!aux.isEmpty())
                    res += ch;
                aux.push(ch);
            }
            else
            {
                if(aux.size() > 1)
                    res += ch;
                aux.pop();
                    
            }
        }
        return res;
    }
}
