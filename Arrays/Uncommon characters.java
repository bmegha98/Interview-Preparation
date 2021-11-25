/*
Given two strings A and B. Find the characters that are not common in the two strings. 

Example 1:

Input:
A = geeksforgeeks
B = geeksquiz
Output: fioqruz
Explanation: 
The characters 'f', 'i', 'o', 'q', 'r', 'u','z' 
are either present in A or B, but not in both.
Example 2:

Input:
A = characters
B = alphabets
Output: bclpr
Explanation: The characters 'b','c','l','p','r' 
are either present in A or B, but not in both.
*/

class Solution
{
    String UncommonChars(String A, String B)
    {
        // code here
        int[] auxA = new int[26];
        int[] auxB = new int[26];
        
        int[] uncommon = new int[26];
        for(char ch : A.toCharArray())
            auxA[ch-'a'] = 1;
        
        for(char ch : B.toCharArray()) 
            auxB[ch-'a'] = 1;
                
        StringBuilder res = new StringBuilder("");
        for(int i=0;i<26;i++) {
            if(Math.abs(auxA[i] - auxB[i]) == 0)
                continue;
            char ch = (char)('a'+i);
            res.append(ch);
        }
        return res.length() == 0 ? "-1":res.toString();   
    }
}
