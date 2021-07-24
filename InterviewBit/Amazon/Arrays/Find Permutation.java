/*
Given a positive integer n and a string s consisting only of letters D or I, you have to find any permutation of first n positive integer that satisfy the given input string.

D means the next number is smaller, while I means the next number is greater.

Notes

Length of given string s will always equal to n - 1
Your solution should run in linear time and space.
Example :

Input 1:

n = 3

s = ID

Return: [1, 3, 2]

each element will be in range [1,n]
Start from the right
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public ArrayList<Integer> findPerm(final String A, int B) {
        ArrayList<Integer> res = new ArrayList<>();
        int max = B, min = 1;
        for(int i=B-2;i>=0;i--) {
            if(A.charAt(i) == 'I') {
                res.add(max);
                max--;
            }
            else {
                res.add(min);
                min++;
            }
        }
        
        res.add(max);
        Collections.reverse(res);
        return res;
    }
}
