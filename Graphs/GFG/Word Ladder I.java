/*
Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. Find the length of the shortest transformation
sequence from startWord to targetWord.
Keep the following conditions in mind:
A word can only consist of lowercase characters.
Only one letter can be changed in each transformation.
Each transformed word must exist in the wordList including the targetWord.
startWord may or may not be part of the wordList.
The second part of this problem can be found here.


Example 1:
Input:
wordList = {"des","der","dfr","dgt","dfs"}
startWord = "der", targetWord= "dfs",
Output:3
Explanation:
The length of the smallest transformation sequence from "der" to "dfs" is 3 i,e "der" -> "dfr" -> "dfs".

Example 2:
Input:
wordList = {"geek", "gefk"}
startWord = "gedk", targetWord= "geek", 
Output:
2
Explanation:
gedk -> geek

Example 3:
Input: 
wordList = {"poon", "plee", "same", "poie","plea","plie","poin"}
startWord = "toon", targetWord= "plea",
Output: 7 
Explanation:
toon -> poon -> poin -> poie -> plie -> plee -> plea 
*/
/*
Change each character of word and check if the new word is present in the dictionary.If it does, add an edge to it and remove that word from the dictionary
to avoid cycles. Perform BFS from start to target words.

Let size of dic be N and size of each word be M
Time = O(N*M*26) , Space = O(N)
*/

class Pair {
    String s;
    int d;
    public Pair(String word,int dist) {
        s = word;
        d = dist;
    }
    public String getKey() {
        return s;
    }
    public int getValue() {
        return d;
    }
}
class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        Set<String> words = new HashSet<>();
        for(String s : wordList)
            words.add(s);
        
        if(!words.contains(targetWord))
            return 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startWord,1));
        if(words.contains(startWord))
            words.remove(startWord);
            
        while(!q.isEmpty()) {
            Pair curr = q.poll();
            String w = curr.getKey();
            
            int d = curr.getValue();
            if(w.equals(targetWord))
                return d;
            
            for(int i = 0;i<w.length();i++) {
                char[] tmp = w.toCharArray(); 
                for(char j = 'a';j<='z';j++) {
                    tmp[i] = j;
                    String newWord = new String(tmp);
                    if(words.contains(newWord)) {
                        q.add(new Pair(newWord,d+1));
                        words.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
}
