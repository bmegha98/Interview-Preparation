/*
We can scramble a string s to get a string t using the following algorithm:

If the length of the string is 1, stop.
If the length of the string is > 1, do the following:
Split the string into two non-empty substrings at a random index, i.e., if the string is s, divide it to x and y where s = x + y.
Randomly decide to swap the two substrings or to keep them in the same order. i.e., after this step, s may become s = x + y or s = y + x.
Apply step 1 recursively on each of the two substrings x and y.
Given two strings s1 and s2 of the same length, return true if s2 is a scrambled string of s1, otherwise, return false.

 

Example 1:

Input: s1 = "great", s2 = "rgeat"
Output: true
Explanation: One possible scenario applied on s1 is:
"great" --> "gr/eat" // divide at random index.
"gr/eat" --> "gr/eat" // random decision is not to swap the two substrings and keep them in order.
"gr/eat" --> "g/r / e/at" // apply the same algorithm recursively on both substrings. divide at ranom index each of them.
"g/r / e/at" --> "r/g / e/at" // random decision was to swap the first substring and to keep the second substring in the same order.
"r/g / e/at" --> "r/g / e/ a/t" // again apply the algorithm recursively, divide "at" to "a/t".
"r/g / e/ a/t" --> "r/g / e/ a/t" // random decision is to keep both substrings in the same order.
The algorithm stops now and the result string is "rgeat" which is s2.
As there is one possible scenario that led s1 to be scrambled to s2, we return true.
*/

class Solution {
    Map<String,Boolean> aux = new HashMap<>();
    public boolean isScramble(String s1, String s2) {
        int m = s1.length(),n = s2.length();
        if(m != n)
            return false;
        if(s1.equals(s2))
            return true;
        if(n == 0)
            return true;
        return solve(s1,s2);
    }
    private boolean solve(String s, String t) {
        int n= s.length();
        if(s.equals(t))
            return true;
        String key = s+"_"+t;
        if(aux.containsKey(key))
            return aux.get(key);
        // 1st check is to make sure both strings have same characters,otherwise we dont want to        // look further
        int [] count = new int [26];
        for (int i=0; i<s.length(); i++) {
            count[s.charAt(i) - 'a'] += 1;
            count[t.charAt(i) - 'a'] -= 1;
        }
        for (int number : count) 
            if (number != 0) {
                aux.put(key, false);
                return false;
            }
            
        boolean flag = false;
        for(int i = 1;i<n;i++) {
            boolean swap = solve(s.substring(0,i),t.substring(n-i)) &&
                           solve(s.substring(i),t.substring(0,n-i));
            
            boolean notSwap = solve(s.substring(0,i),t.substring(0,i)) &&
                           solve(s.substring(i),t.substring(i));
            if(swap || notSwap) {
                flag = true;
                break;
            }
        }
        aux.put(key,flag);
        return flag;
    }
}
