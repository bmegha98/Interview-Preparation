/*
Given a string s, partition s such that every string of the partition is a palindrome.

Return all possible palindrome partitioning of s.

For example, given s = "aab",
Return

  [
    ["a","a","b"]
    ["aa","b"],
  ]
 Ordering the results in the answer : Entry i will come before Entry j if :
len(Entryi[0]) < len(Entryj[0]) OR
(len(Entryi[0]) == len(Entryj[0]) AND len(Entryi[1]) < len(Entryj[1])) OR
*
*
*
(len(Entryi[0]) == len(Entryj[0]) AND … len(Entryi[k] < len(Entryj[k]))
In the given example,
["a", "a", "b"] comes before ["aa", "b"] because len("a") < len("aa")
*/

public class Solution {
    ArrayList<ArrayList<String>> res;
    public ArrayList<ArrayList<String>> partition(String a) {
        res = new ArrayList<>();
        helper(a,0,a.length()-1,new ArrayList<>());
        return res;
    }
    private void helper(String a, int start, int end, ArrayList<String> tmp) {
        if(start > end) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int k = start;k<=end;k++) 
            if(isPalindrome(a,start,k)) {
                tmp.add(a.substring(start,k+1));
                helper(a,k+1,end,tmp);
                tmp.remove(tmp.size()-1);
            }
    }
    private boolean isPalindrome(String s,int l,int h) {
        while(l<h) {
            if(s.charAt(l) != s.charAt(h))
                return false;
            l++;
            h--;
        }
        return true;
    }
}
