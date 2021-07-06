/*
Given a list of words followed by two words, the task to find the minimum distance between the given two words in the list of words
Example 1:

Input:
S = { "the", "quick", "brown", "fox", 
     "quick"}
word1 = "the"
word2 = "fox"
Output: 3
Explanation: Minimum distance between the words "the" and "fox" is 3

Example 2:

Input:
S = {"geeks", "for", "geeks", "contribute", 
     "practice"}
word1 = "geeks"
word2 = "practice"
Output: 2
Explanation: Minimum distance between the words "geeks" and "practice" is 2
*/

class Solution {
    int shortestDistance(ArrayList<String> s, String word1, String word2) {
        //any of them comes before any of the words
        if(word1.equals(word2))
            return 0;
        int n = s.size(),first = -1,second = -1,
            minDiff = Integer.MAX_VALUE;
        for(int i=n-1;i>=0;i--) {
            if(s.get(i).equals(word2))
                second = i;
            else if(s.get(i).equals(word1))
                first = i;
            if(first != -1 && second != -1)
                minDiff = Math.min(minDiff, Math.abs(first-second));
        }
        
        return minDiff;
    }
}
