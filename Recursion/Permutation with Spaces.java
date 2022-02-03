/*
Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them. The output should be printed in sorted increasing order of strings

Example 1:

Input:
S = "ABC"
Output: (A B C)(A BC)(AB C)(ABC)
Explanation:
ABC
AB C
A BC
A B C
These are the possible combination of "ABC".
 

Example 2:

Input:
S = "AB"
Output: (A B)(AB)

Your Task:  
You don't need to read input or print anything. Your task is to complete the function permutation() which takes the string S as input parameters and returns the 
sorted array of the string denoting the different permutation (DON'T ADD '(' and ')' it will be handled by the driver code only).
*/

//At each character, except first, we have two choices : include element only or include " "+element

class Solution{
    char firstEle;
    ArrayList<String> res;
    ArrayList<String> permutation(String S){
        // Code Here
        res = new ArrayList<>();
        int n = S.length();
        if(n == 0)
            return res;
        firstEle = S.charAt(0);
        helper(S,1,n,new StringBuilder(""));
        return res;
    }
    
    private void helper(String s, int ind, int n, StringBuilder tmp) {
        if(ind == n) {
            String per = firstEle+tmp.toString();
            res.add(per);
            return;
        }
        tmp.append(" "+s.charAt(ind));
        helper(s,ind+1,n,tmp);
        tmp.deleteCharAt(tmp.length()-2);
        helper(s,ind+1,n,tmp);
        tmp.deleteCharAt(tmp.length()-1);
    }
    
}
