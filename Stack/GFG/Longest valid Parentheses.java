/*
Given a string S consisting of opening and closing parenthesis '(' and ')'. Find length of the longest valid parenthesis substring.

Example 1:

Input: S = ((()
Output: 2
Explaination: The longest valid 
parenthesis substring is "()".
Example 2:

Input: S = )()())
Output: 4
Explaination: The longest valid 
parenthesis substring is "()()".
*/

class Solution{
    static int maxLength(String S){
        // code here
        int n = S.length();
        if(n < 2)
            return 0;
        Stack<Integer> aux = new Stack<>();
        aux.push(-1);
        int len = 0;
        for(int i =0;i<n;i++) {
            char ch = S.charAt(i);
            if(ch == '(')
                aux.push(i);
            else {
                aux.pop();
                if(aux.isEmpty())
                    aux.push(i);
                else
                    len = Math.max(len, i-aux.peek());
            }
        }
        return len;
    }
}
