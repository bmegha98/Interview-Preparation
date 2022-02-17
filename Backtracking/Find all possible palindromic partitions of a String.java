/*
Given a String S, Find all possible Palindromic partitions of the given String.
 

Example 1:

Input:
S = "geeks"
Output:
g e e k s
g ee k s
Explanation:
All possible palindromic partitions
are printed.
Example 2:

Input:
S = "madam"
Output:
m a d a m
m ada m
madam

Your Task:
You don't need to read input or print anything. Your task is to complete the function allPalindromicPerms() which takes a String S as input parameter and returns a
list of lists denoting all the possible palindromic partitions in the order of their appearance in the original string.
*/
//For a string of length n, we've n choices of making a cut
class Solution {
    static ArrayList<ArrayList<String>> res;
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        res = new ArrayList<>();
        helper(S,0,S.length()-1, new ArrayList<>());
        return res;
    }
    
    static void helper(String s, int i, int j, ArrayList<String> tmp) {
        if(i > j) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        
        for(int k=i;k<=j;k++) {
            String left = s.substring(i,k+1);
            if(isPalindrome(left)) {
                tmp.add(left);
                helper(s,k+1,j,tmp);
                tmp.remove(tmp.size()-1);
            }
        }
    }
    static boolean isPalindrome(String str) {
        int l = 0, h = str.length()-1;
        while(l < h) {
            if(str.charAt(l) != str.charAt(h))
                return false;
            l++;
            h--;
        }
        return true;
    }
}
