/*
Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes 
first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
*/

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        String[] res = new String[k];
        Map<String,Integer> aux = new HashMap<>();
        for(String w : words)
            aux.put(w,aux.getOrDefault(w,0)+1);
        
        Queue<String> q = new PriorityQueue<>(1, (a,b)->{
            if(aux.get(a) == aux.get(b))
                return b.compareTo(a);
            return aux.get(a)-aux.get(b);
        });
        
        for(Map.Entry<String,Integer> entry : aux.entrySet()){
            q.add(entry.getKey());
            if(q.size() > k)
                q.poll();
        }
        
        int pos = k-1;
        while(!q.isEmpty()){
            res[pos]= q.poll();
            pos--;
        }
        return Arrays.asList(res);
            
    }
}
