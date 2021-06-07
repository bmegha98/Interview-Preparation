/*
Given a string A denoting an expression. It contains the following operators ’+’, ‘-‘, ‘*’, ‘/’.A set of parentheses is redundant if the same sub-expression is 
surrounded by unnecessary or multiple brackets. Print "Yes" if redundant else "No".
Chech whether A has redundant braces or not.Return 1 if A has redundant braces, else return 0.
Note: A will be always a valid expression.
Input 1:
    A = "((a + b))"
Output 1:
    1
    Explanation 1:
        ((a + b)) has redundant braces so answer will be 1.

Input 2:
    A = "(a + (a + b))"
Output 2:
    0
    Explanation 2:
        (a + (a + b)) doesn't have have any redundant braces so answer will be 0.
*/

//If no operators are present between () then there is redundancy
public class Solution {
    public int braces(String A) {
        int n = A.length();
        if(n < 2)
            return 0;
        Stack<Character> aux = new Stack<>();
        for(char ch : A.toCharArray()) {
            if(Character.isLetter(ch))
                continue;
            if(ch == ')') {
                boolean flag = true;
                while(!aux.isEmpty() && aux.peek() != '(') {
                    char top = aux.pop();
                    if(top == '+' || top == '-' || top == '*' || top == '/')
                        flag = false;
                }
                if(flag)
                    return 1;
                aux.pop();
            }
            else
                aux.push(ch);
        }
        return 0;
    }
}

//If number of brackets > number of operators => redundancy
public class Solution {
    public int braces(String A) {
        int n = A.length();
        if(n < 2)
            return 0;
        int x = 0, y = 0;
        for(int i=0;i<n;i++) {
            char ch = A.charAt(i);
            if(ch == '(' && A.charAt(i+2) == ')')
                return 1;
            if(ch == '(')
                x++;
            else if(ch == '+'||ch == '-'||ch == '*'||ch == '/')
                y++;
        }
        return x > y?1:0;
    }
}
