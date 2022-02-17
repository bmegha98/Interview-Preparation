/*
Given a string s and a dictionary of words dict of length n, add spaces in s to construct a sentence where each word is a valid dictionary word. Each dictionary
word can be used more than once. Return all such possible sentences.

Follow examples for better understanding.

Example 1:

Input: s = "catsanddog", n = 5 
dict = {"cats", "cat", "and", "sand", "dog"}
Output: (cats and dog)(cat sand dog)
Explanation: All the words in the given 
sentences are present in the dictionary.
Example 2:

Input: s = "catsandog", n = 5
dict = {"cats", "cat", "and", "sand", "dog"}
Output: Empty
Explanation: There is no possible breaking 
of the string s where all the words are present 
in dict.
Your Task:
You do not need to read input or print anything. Your task is to complete the function wordBreak() which takes n, dict and s as input parameters and returns a list
of possible sentences. If no sentence is possible it returns an empty list.
*/

class Solution{
    static List<String> res;
    static List<String> wordBreak(int n, List<String> dict, String s) {
        // code here
        res = new ArrayList<>();
        helper(s,0,s.length()-1,dict,new ArrayList<>());
        return res;
    }
    
    static void helper(String s, int i, int j, List<String> Dict, 
        List<String> tmp) {
        if(i > j) {
            String sentence = convertToSentence(tmp);
            res.add(sentence);
            return;
        }
        
        for(int k=i;k<=j;k++) {
            String left = s.substring(i,k+1);
            if(Dict.contains(left)) {
                tmp.add(left);
                helper(s,k+1,j,Dict,tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    
    static String convertToSentence(List<String> words) {
        StringBuilder sen = new StringBuilder("");
        for(String w : words) {
            sen.append(w);
            sen.append(" ");
        }
        sen.deleteCharAt(sen.length()-1);
        return sen.toString();
    }
}
