/*
Given an input stream of A of n characters consisting only of lower case alphabets. The task is to find the first non repeating character, each time a character is
inserted to the stream. If there is no such character then append '#' to the answer.
*/

class Solution
{
    public String FirstNonRepeating(String A)
    {
        //code here
        int[] charCount = new int[26];
        String res = "";
        Queue<Character> q = new LinkedList<>();
        
        for(int i = 0;i<A.length();i++)
        {
            char ch = A.charAt(i);
            q.offer(ch);
            charCount[ch-'a']++;
            while (!q.isEmpty()) 
            { 
                if (charCount[q.peek() - 'a'] > 1) 
                    q.remove(); 
                else 
                { 
                    res += q.peek(); 
                    break; 
                } 
            } 
            if (q.isEmpty()) 
                res += "#";
        }
        return res;
    }
}
