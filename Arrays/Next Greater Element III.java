/*
Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such 
positive integer exists, return -1.
Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.
*/

class Solution {
    public int nextGreaterElement(int num) {
        String s = String.valueOf(num);
        char[] str = s.toCharArray();
        int n = str.length;
        int first = -1,second = -1;
        for(int i=n-1;i>0;i--) 
            if(str[i-1] < str[i]) {
                first = i-1;
                break;
            }
        if(first == -1)
            return first;
        for(int j = n-1;j>first;j--)
            if(str[j] > str[first]){
                second = j;
                break;
            }
        char tmp = str[first];
        str[first] = str[second];
        str[second] = tmp;
        
        Arrays.sort(str,first+1,n);
        s = new String(str);
        long l = Long.valueOf(s);
        return l > Integer.MAX_VALUE?-1:(int)l;
    }
}
