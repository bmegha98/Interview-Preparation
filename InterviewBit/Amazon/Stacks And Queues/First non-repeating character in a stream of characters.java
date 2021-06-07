/*
Problem Description
Given a string A denoting a stream of lowercase alphabets. You have to make new string B.
B is formed such that we have to find first non-repeating character each time a character is inserted to the stream and append it at the end to B. If no
non-repeating character is found then append '#' at the end of B.
Problem Constraints
1 <= length of the string <= 100000
Input Format
The only argument given is string A.
Output Format
Return a string B after processing the stream of lowercase alphabets A.
Example Input
Input 1:

 A = "abadbc"
Input 2:

 A = "abcabc"
Example Output
Output 1:

 "aabbdd"
Output 2:

 "aaabc#"
*/

public class Solution {
    public String solve(String A) {
        int n = A.length();
        if(n == 1)
            return A;
        
        int[] freq = new int[26];
        Queue<Character> aux = new LinkedList<>();
        StringBuilder res = new StringBuilder("");
        for(int i = 0;i<n;i++) {
            char ch = A.charAt(i);
            freq[ch-'a']++;
            aux.add(ch);
            
            while(!aux.isEmpty() && freq[aux.peek()-'a'] > 1) 
                aux.poll();
            if(aux.isEmpty())
                res.append('#');
            else
                res.append(aux.peek());
        }
        return res.toString();
    }
}
