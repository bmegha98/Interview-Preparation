/*
Given a number A in a form of string.You have to find the smallest number that has same set of digits as A and is greater than A.
If A is the greatest possible number with its set of digits, then return -1.
Problem Constraints
1 <= A <= 10100000
A doesn't contain leading zeroes.

Input Format
First and only argument is an numeric string denoting the number A.
Output Format
Return a string denoting the smallest number greater than A with same set of digits , if A is the largest possible then return -1.

Example Input
Input 1:

 A = "218765"
Input 2:

 A = "4321"


Example Output
Output 1:

 "251678"
Output 2:

 "-1"
*/

public class Solution {
    public String solve(String A) {
        char[] tmp = A.toCharArray();
        
        int first = -1,n = tmp.length;
        for(int i = n-2;i>=0;i--)
            if(tmp[i] < tmp[i+1]) {
                first = i;
                break;
            }
        if(first == -1)
            return "-1";
        int second = -1;
        for(int j=n-1;j>first;j--)
            if(tmp[j] > tmp[first]) {
                second = j;
                break;
            }
        swap(tmp,first,second);
        
        int l = first+1,h = n-1;
        while(l<h) {
            swap(tmp,l,h);
            l++;
            h--;
        }
        return new String(tmp);
    }
    
    private void swap(char[] A,int i,int j) {
        char x = A[i];
        A[i] = A[j];
        A[j] = x;
    }
}
