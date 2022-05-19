/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. Return the answer in any 
order.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:

Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
Example 2:

Input: digits = ""
Output: []
Example 3:

Input: digits = "2"
Output: ["a","b","c"]
 

Constraints:

0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/

class Solution {
    String[] phone = {null,"","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> res;
    public List<String> letterCombinations(String digits) {
        res = new ArrayList<>();
        int n = digits.length();
        if(n == 0)
            return res;
        combinations(digits.toCharArray(),0,n,new StringBuilder(""));
        return res;
    }
    
    private void combinations(char[] digits, int start, int n, StringBuilder tmp) {
        if(start == n) {
            res.add(tmp.toString());
            return;
        }
        
        for(char ch : phone[digits[start]-'0'].toCharArray()) {
            tmp.append(ch);
            combinations(digits,start+1,n,tmp);
            tmp.deleteCharAt(tmp.length()-1);
        }
    }
}
