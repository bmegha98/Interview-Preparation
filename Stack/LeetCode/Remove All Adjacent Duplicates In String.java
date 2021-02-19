/*
Given a string S of lowercase letters, a duplicate removal consists of choosing two adjacent and equal letters, and removing them.
We repeatedly make duplicate removals on S until we no longer can.
Return the final string after all such duplicate removals have been made.  It is guaranteed the answer is unique.
*/

class Solution {
    public String removeDuplicates(String S) 
    {
        int n = S.length();
        if(n == 0 || n == 1)
            return S;
        /*
        Stack<Character> aux = new Stack<>();
        
        for(int i=0;i<n;i++)
        {
            char ch = S.charAt(i);
            if(aux.isEmpty() || aux.peek() != ch)
                aux.push(ch);
            else
                aux.pop();
        }
        String res = "";
        while(!aux.isEmpty())
        {
            res = aux.peek()+res;
            aux.pop();
        }
        return res;
        */
        
        StringBuffer res = new StringBuffer("");
        for(char ch : S.toCharArray())
        {
            if(res.length() == 0)
                res.append(ch);
            else 
            {
                int ind = res.length()-1;
                if(res.charAt(ind) == ch)
                    res.delete(ind,ind+1);
                else
                    res.append(ch);
             }
        }
        return res.toString();
    }
}
