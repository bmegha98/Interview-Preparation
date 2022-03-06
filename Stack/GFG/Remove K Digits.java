/*
Given a non-negative integer S represented as a string, remove K digits from the number so that the new number is the smallest possible.
Note : The given num does not contain any leading zero.

Example 1:

Input:
S = "149811", K = 3
Output: 111
Explanation: Remove the three digits 
4, 9, and 8 to form the new number 111
which is smallest.
Example 2:

Input:
S = "1002991", K = 3
Output: 21
Explanation: Remove the three digits 1(leading
one), 9, and 9 to form the new number 21(Note
that the output must not contain leading
zeroes) which is the smallest.

Your Task:
You don't need to read input or print anything. Your task is to complete the function removeKdigits() which takes the string S and an integer K as input and
returns the new number which is the smallest possible.
*/

class Solution {
    public String removeKdigits(String S, int K) {
        // code here
        StringBuilder tmp = new StringBuilder("");
        Stack<Character> aux = new Stack<>();
        int n = S.length();
        //aux.push(S.charAt(0));
        for(int i=0;i<n;) {
            if (K > 0 && !aux.isEmpty() && aux.peek() > S.charAt(i)) {
                K--;
                aux.pop();
            }
            else if (!aux.isEmpty() || S.charAt(i) != '0'){
                aux.push(S.charAt(i));
                i++;
            }
            else
                i++;
        }
        
        while (!aux.isEmpty()&& K > 0) {
            aux.pop();
            K--;
        }
        
        while(!aux.isEmpty())
            tmp.append(aux.pop());
        
        tmp.reverse();
        return tmp.length() > 0 ?tmp.toString() : "0";
    }
}
