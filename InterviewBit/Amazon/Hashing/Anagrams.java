/*
Given an array of strings, return all groups of strings that are anagrams. Represent a group by a list of integers representing the index in the original list. 
Look at the sample case for clarification.
Anagram : a word, phrase, or name formed by rearranging the letters of another, such as 'spar', formed from 'rasp' 
Note: All inputs will be in lower-case. 
Example :

Input : cat dog god tca
Output : [[1, 4], [2, 3]]
cat and tca are anagrams which correspond to index 1 and 4.
dog and god are another set of anagrams which correspond to index 2 and 3.
The indices are 1 based ( the first element has index 1 instead of index 0).

Ordering of the result : You should not change the relative ordering of the words / phrases within the group. Within a group containing A[i] and A[j], A[i] comes 
before A[j] if i < j.
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<ArrayList<Integer>> anagrams(final List<String> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int n = A.size();
        if(n == 0)
            return res;
        Map<String,ArrayList<Integer>> aux = new HashMap<>();
        
        for(int i=0;i<n;i++) {
            String s = A.get(i);
            int[] freq = new int[26];
            for(char ch : s.toCharArray())
                freq[ch-'a']++;
            StringBuilder tmp = new StringBuilder("");
            for(int j=0;j<26;j++) {
                if(freq[j] == 0)
                    continue;
                char c = (char)(j+'a');
                int f = freq[j];
                while(f-- > 0)
                    tmp.append(c);
            }
            
            ArrayList<Integer> l;
            if(aux.containsKey(tmp.toString()))
                l = aux.get(tmp.toString());
            else
                l = new ArrayList<>();
            l.add(i+1);
            aux.put(tmp.toString(), l);
        }
        
        for(Map.Entry<String,ArrayList<Integer>> entry : aux.entrySet())
            res.add(entry.getValue());
        return res;
    }
}
