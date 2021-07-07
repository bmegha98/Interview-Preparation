/*
Given a positive integer X. The task is to find the smallest even number E such that
E > X and all digits in X and E are same.
Note: All the digits in X should be same with digits in E.
Example 1:

Input:
X = 34722641
Output:
34724126
Explanation: Next greater number with same digits as in input is 34724126.

Example 2:

Input:
X = 111
Output:
-1
Explanation: You can't rearrange the digits to get an answer.
*/

class Solution {
    
    private void nextGreater(char[] s,int n) {
        int first = -1,second = -1;
        
        for(int i=n-1;i>0;i--) 
            if(s[i-1] < s[i]) {
                first = i-1;
                break;
            }
        if(first == -1)
            return;
        for(int i=n-1;i>first;i--) 
            if(s[i] > s[first]) {
                second = i;
                break;
            }
        
        swap(s,first,second);
        
        reverse(s,first+1,n-1);
    }
    
    private void reverse(char[] A,int l,int h) {
        while(l<h) {
            swap(A,l,h);
            l++;
            h--;
        }
    }
    
    private void swap(char[] A,int i,int j) {
        char tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
    public long getNextEven(String x)
    {
        int n = x.length();
        char[] num = x.toCharArray();
        
        int count = 0;
        for(char ch : num) 
            if((ch-'0')%2 == 1)
                count++;
        if(count == n)
            return -1;
        while(true){
            int i=n-2;
            while(i>=0&&num[i]>=num[i+1])
                i--;
            if(i<0)
                return -1l;
            int min=i+1;
            for(int j=n-1;j>i;j--)
                if(num[j]>num[i]){
                    min=j;
                    break;
                }
            swap(num,i,min);
            reverse(num,i+1,n-1);
            if((num[n-1]-'0')%2==0)
                return Long.parseLong(new String(num));
        }
    }
}
