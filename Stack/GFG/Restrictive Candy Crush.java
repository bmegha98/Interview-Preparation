/*
Given a string s and an integer k, the task is to reduce the string by applying the following operation:
Choose a group of k consecutive identical characters and remove them.

The operation can be performed any number of times until it is no longer possible.

Example 1:

Input:
k = 2
s = "geeksforgeeks"
Output:
gksforgks
Explanation:
Modified String after each step: 
"geeksforgeeks" -> "gksforgks"
Example 2:

Input:
k = 2
s = "geegsforgeeeks" 
Output:
sforgeks
Explanation:
Modified String after each step:
"geegsforgeeeks" -> "ggsforgeks" -> "sforgeks"
Your Task:  
You don't need to read input or print anything. Complete the function Reduced_String() which takes integer k and string s as input parameters and returns the
reduced string.
*/

class Pair {
    char ch;
    int freq;
    public Pair(char c, int f) {
        ch = c;
        freq = f;
    }
}
class Solution
{
    public static String reduced_String(int k, String s) {
        // Your code goes here
        if(k == 1)
            return "";
        Stack<Pair> aux = new Stack<>();
        
        for(char ch : s.toCharArray()) {
            if(aux.isEmpty() || aux.peek().ch != ch)
                aux.push(new Pair(ch,1));
            else {
                aux.peek().freq++;
                if(aux.peek().freq == k)
                    aux.pop();
            }
        }
        
        StringBuilder res = new StringBuilder("");
        while(!aux.isEmpty()) {
            Pair p = aux.pop();
            int f = p.freq;
            while(f-- > 0)
                res.append(p.ch);
        }
        
        res.reverse();
        return res.toString();
    }
}
