/*
The set [1, 2, 3, ..., n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

 

Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
Example 3:

Input: n = 3, k = 1
Output: "123"
 

Constraints:

1 <= n <= 9
1 <= k <= n!
*/

//Time = O(k*n) ,space = O(n)
class Solution {
    public String getPermutation(int n, int k) {
        char[] s = new char[n];
        for(int i=1;i<=n;i++)
            s[i-1] = (char)(i+'0');
        
        if(k == 1)
            return new String(s);
        while(k-- > 1)
            nextPermutation(s,n);
        return new String(s);
    }
    private void nextPermutation(char[] s, int n) {
        int first = -1;
        for(int i=n-1;i>0;i--)
            if(s[i] > s[i-1]) {
                first = i-1;
                break;
            }
        if(first == -1)
            return;
        int second = -1;
        for(int j=n-1;j>first;j--)
            if(s[j] > s[first]) {
                second = j;
                break;
            }
        swap(s,first,second);
        int l = first+1,h = n-1;
        while(l<h) {
            swap(s,l,h);
            l++;
            h--;
        }
    }
    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
