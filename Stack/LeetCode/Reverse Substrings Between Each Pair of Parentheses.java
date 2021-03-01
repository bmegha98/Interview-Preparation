/*
You are given a string s that consists of lower case English letters and brackets. 

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.
*/

class Solution {
    public String reverseParentheses(String s) 
    {
        if(s.length() == 0)
            return s;
        /*
        Stack<Character> aux = new Stack<>();
        String res = "";
        for(char ch : s.toCharArray())
        {
            if(ch == '(' || Character.isAlphabetic(ch))
                aux.push(ch);
            else
            {
                String tmp = "";
                while(!aux.isEmpty() && aux.peek() != '(')
                    tmp += (aux.pop());
                aux.pop();
                for(char x : tmp.toCharArray())
                    aux.push(x);
            }
        }
        while(!aux.isEmpty())
            res = aux.pop()+res;
        return res;
        */
        
        Stack<StringBuffer> aux = new Stack<>();
        aux.push(new StringBuffer(""));
        for(char ch : s.toCharArray())
        {
            if(ch == '(')
                aux.push(new StringBuffer(""));
            else if(ch == ')')
            {
                StringBuffer tmp = aux.pop();
                tmp.reverse();
                StringBuffer prev = aux.pop();
                prev.append(tmp);
                aux.push(prev);
            }
            else
                aux.peek().append(ch);
        }
        return aux.peek().toString();
    }
}
