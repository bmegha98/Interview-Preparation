/*
Given a positive integer N, the task is to find all the N bit binary numbers having more than or equal 1’s than 0’s for any prefix of the number.

Example 1:

Input:  N = 2
Output: 11 10
Explanation: 11 and 10 have more than 
or equal 1's than 0's
Example 2:

Input:  N = 3
Output: 111 110 101
Explanation: 111, 110 and 101 have more 
than or equal 1's than 0's
User Task:
Your task is to complete the function NBitBinary() which takes a single number as input and returns the list of strings in decreasing order. You need not take any
input or print anything.
*/

class Solution {
    ArrayList<String> res;
    ArrayList<String> NBitBinary(int N) {
        // code here
        res = new ArrayList<>();
        helper(0,0,N,new StringBuilder(""));
        return res;
    }
    
    private void helper(int ones, int zeroes, int n,StringBuilder tmp) {
        if(ones + zeroes == n) {
            res.add(tmp.toString());
            return;
        }
        
        tmp.append("1");
        helper(ones+1,zeroes,n,tmp);
        tmp.deleteCharAt(tmp.length()-1);
        
        if(ones > zeroes) {
            tmp.append("0");
            helper(ones,zeroes+1,n,tmp);
            tmp.deleteCharAt(tmp.length()-1);
        }
    }
}
