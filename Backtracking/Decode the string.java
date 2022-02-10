/*
An encoded string (s) is given, the task is to decode it. The pattern in which the strings were encoded were as follows
original string: abbbababbbababbbab 
encoded string : 3[a3[b]1[ab]]

Example 1:

Input: s = 1[b]
Output: b
Explaination: 'b' is present only one time.
Example 2:

Input: s = 3[b2[ca]]
Output: bcacabcacabcaca
Explaination: 2[ca] means 'ca' is repeated 
twice which is 'caca' which concatenated with 
'b' becomes 'bcaca'. This string repeated 
thrice becomes the output.
Your Task:
You do not need to read input or print annything. Your task is to complete the function decodedString() which takes s as input parameter and returns the decoded
string.

Expected Time Complexity: O(|s|)
Expected Auxiliary Space: O(|s|)

Constraints:
1 ≤ |s| ≤ 30 


*/

class Solution{
    static String decodedString(String s){
        // code here
        Stack<String> aux = new Stack<>();
        Stack<Integer> freq = new Stack<>();
        
        int i = 0, n = s.length();
        String curr = "";
        while(i<n) {
            char ch = s.charAt(i);
            if(ch == '[') {
                aux.push(curr);
                curr = "";
                i++;
            }
            else if(Character.isDigit(ch)) {
                String f = "";
                while(i<n && Character.isDigit(s.charAt(i))) {
                    f += s.charAt(i);
                    i++;
                }
                freq.push(Integer.parseInt(f));
            }
            else if(ch == ']') {
                int f = freq.pop();
                String tmp = curr;
                while(f-- > 1)
                    curr += tmp;
                curr = aux.pop()+curr;
                i++;
            }
            else {
                curr += ch;
                i++;
            }
        }
        return curr;
    }
}
