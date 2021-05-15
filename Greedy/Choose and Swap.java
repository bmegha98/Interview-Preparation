/*
You are given a string s of lower case english alphabets. You can choose any two characters in the string and replace all the occurences of the first character
with the second character and replace all the occurences of the second character with the first character. Your aim is to find the lexicographically smallest
string that can be obtained by doing this operation at most once.

Example 1:

Input:
A = "ccad"
Output: "aacd"
Explanation:
In ccad, we choose ‘a’ and ‘c’ and after 
doing the replacement operation once we get, 
aacd and this is the lexicographically
smallest string possible. 
 

Example 2:

Input:
A = "abba"
Output: "abba"
Explanation:
In abba, we can get baab after doing the 
replacement operation once for ‘a’ and ‘b’ 
but that is not lexicographically smaller 
than abba. So, the answer is abba.
*/

//T(n) = O(n^2)

class Solution{
    
    
    String chooseandswap(String A){
        int n = A.length();
        if(n == 1)
            return A;
        
        int i;
        char min = A.charAt(0);
        boolean[] visited = new boolean[26];
        for(i=0;i<n;i++) {
            char ch = A.charAt(i);
            visited[ch-'a'] = true;
            min = ch;
            for(int j = i+1;j<n;j++) {
                char tmp = A.charAt(j);
                if(min > tmp&& !visited[tmp-'a'])
                    min = tmp;
            }
            
            if(min != ch)
                break;
        }
        
        StringBuilder res = new StringBuilder(A);
        
        if(i < n) {
            char x = A.charAt(i);
            for(int j=0;j<n;j++) {
                if(res.charAt(j) == min)
                    res.setCharAt(j,x);
                else if(res.charAt(j) == x)
                    res.setCharAt(j,min);
            }
        }
        return res.toString();
    }
    
}

//T(n) = O(26*n) = O(n)

class Solution{
    
    
    String chooseandswap(String A){
        int n = A.length();
        if(n == 1)
            return A;
        int[] firstOccurence = new int[26];
        Arrays.fill(firstOccurence,-1);
        
        for(int i=0;i<n;i++) {
            char ch = A.charAt(i);
            if(firstOccurence[ch-'a'] == -1)
                firstOccurence[ch-'a'] = i;
        }
        
        int l ,r = 0;
        for(l =0;l<n;l++) {
            char ch = A.charAt(l);
            boolean flag = false;
            for(r=0;r<ch-'a';r++) 
            {
                if(firstOccurence[r] > l)
                {
                    flag = true;
                    break;
                }
            }
            if(flag)
                break;
        }
        
        StringBuilder res = new StringBuilder(A);
        if(l < n) {
            char x = A.charAt(l);
            char y = (char)(r+'a');
            
            for(int i=0;i<n;i++) {
                if(res.charAt(i) == x)
                    res.setCharAt(i,y);
                else if(res.charAt(i) == y)
                    res.setCharAt(i,x);
            }
        }
        return res.toString();
    }
    
}
