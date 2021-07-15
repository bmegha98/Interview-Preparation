/*
Problem Description
Given a column title A as appears in an Excel sheet, return its corresponding column number.
Problem Constraints
1 <= |A| <= 100
Input Format
First and only argument is string A.
Output Format
Return an integer

A  -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
*/

public class Solution {
    public int titleToNumber(String s) {
        int num = 0,tmp = 1;
        for(int i=s.length()-1;i>=0;i--) {
            int ind = (s.charAt(i)-'A')+1;
            //num += Math.pow(26,count)*ind;count++;
            num += ind*tmp;
            tmp *= 26;
        }
        
        return num;
        
    }
}
