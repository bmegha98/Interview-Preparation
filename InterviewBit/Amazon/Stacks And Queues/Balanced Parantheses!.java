/*
Problem Description
Given a string A consisting only of '(' and ')'.
You need to find whether parantheses in A is balanced or not ,if it is balanced then return 1 else return 0.
Problem Constraints
1 <= |A| <= 105
Input Format
First argument is an string A.
Output Format
Return 1 if parantheses in string are balanced else return 0.
Example Input
Input 1:

 A = "(()())"
Input 2:

 A = "(()"
Example Output
Output 1:

 1
Output 2:

 0
*/

public class Solution {
    public int solve(String A) {
        int n = A.length();
        if(n == 1)
            return 0;
        Stack<Character> aux = new Stack<>();
        for(char ch : A.toCharArray()) {
            if(ch == '(')
                aux.push(ch);
            else {
                if(aux.isEmpty())
                    return 0;
                aux.pop();
            }
        }
        return aux.isEmpty()?1:0;
    }
}
