/*
Given a string s, you can transform every letter individually to be lowercase or uppercase to create another string.

Return a list of all possible strings we could create. Return the output in any order.

 

Example 1:

Input: s = "a1b2"
Output: ["a1b2","a1B2","A1b2","A1B2"]
Example 2:

Input: s = "3z4"
Output: ["3z4","3Z4"]
 

Constraints:

1 <= s.length <= 12
s consists of lowercase English letters, uppercase English letters, and digits.
*/

class Solution {
    List<String> res;
    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<>();
        helper(s,0,s.length(),new StringBuilder(""));
        return res;
    }
    
    private void helper(String s, int ind, int n, StringBuilder tmp) {
        if(ind == n) {
            res.add(tmp.toString());
            return;
        }
        if(Character.isDigit(s.charAt(ind))) {
            tmp.append(s.charAt(ind));
            helper(s,ind+1,n,tmp);
        }
        else {
            tmp.append(Character.toLowerCase(s.charAt(ind)));
            helper(s,ind+1,n,tmp);
            tmp.deleteCharAt(tmp.length()-1);
            tmp.append(Character.toUpperCase(s.charAt(ind)));
            helper(s,ind+1,n,tmp);
        }
        tmp.deleteCharAt(tmp.length()-1);
    }
}
