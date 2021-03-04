/*
Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and removing them causing the left and the right side of the
deleted substring to concatenate together.
We repeatedly make k duplicate removals on s until we no longer can.
Return the final string after all such duplicate removals have been made.
It is guaranteed that the answer is unique.
*/

class Solution {
    public String removeDuplicates(String s, int k) 
    {
        int n = s.length();
        if(n == 0 ||k == 0)
            return s;
        
        Stack<Pair<Character,Integer>> aux = new Stack<>();
        for(char ch : s.toCharArray())
        {
            if(aux.isEmpty() || aux.peek().getKey() != ch)
                aux.push(new Pair<>(ch,1));
            else
            {
                int freq = aux.pop().getValue();
                aux.push(new Pair<>(ch,freq+1));
            }
            if(aux.peek().getValue() == k)
                aux.pop();
        }
        
        String res = "";
        while(!aux.isEmpty())
        {
            Pair<Character,Integer> p = aux.pop();
            int freq = p.getValue();
            String rep = Character.toString(p.getKey());
                res = IntStream.range(0,freq).mapToObj(i-> rep) .collect (Collectors. joining(""))+res;
        }
        return res;
    }
}
