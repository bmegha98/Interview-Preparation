/*
Write a function that reverses a string. The input string is given as an array of characters s.

You must do this by modifying the input array in-place with O(1) extra memory.

 

Example 1:

Input: s = ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]
Example 2:

Input: s = ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
*/

//Iterative

class Solution {
    public void reverseString(char[] s) {
        int l = 0, h = s.length-1;
        while(l<h) {
            swap(s,l,h);
            l++;
            h--;
        }
    }
    private void swap(char[] A,int i, int j) {
        char tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}

//Recursive
class Solution {
    public void reverseString(char[] s) {
        int l = 0, h = s.length-1;
        helper(s,l,h);
    }
    
    private void helper(char[] A, int l, int h) {
        if(l >= h)
            return;
        helper(A,l+1,h-1);
        swap(A,l,h);
    }
    private void swap(char[] A,int i, int j) {
        char tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}
