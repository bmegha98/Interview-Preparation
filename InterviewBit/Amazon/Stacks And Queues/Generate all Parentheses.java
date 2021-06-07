/*
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
Return 0 / 1 ( 0 for false, 1 for true ) for this problem
*/

public class Solution {
    public int isValid(String A) {
        int n = A.length();
        if(n == 0)
            return 1;
        if(n == 1)
            return 0;
        Stack<Character> aux = new Stack<>();
        for(char ch : A.toCharArray()) {
            if(ch == '('||ch == '{'||ch == '[')
                aux.push(ch);
            else {
                if(aux.isEmpty() || !match(aux.peek(),ch))
                    return 0;
                aux.pop();
            }
        }
        return aux.isEmpty()?1:0;
    }
    private boolean match(char op,char cl) {
        if(op == '(' && cl == ')')
            return true;
        if(op == '{' && cl == '}')
            return true;
        if(op == '[' && cl == ']')
            return true;
        return false;
    }
}
