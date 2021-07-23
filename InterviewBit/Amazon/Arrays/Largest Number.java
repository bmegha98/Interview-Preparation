/*
Given a list of non negative integers, arrange them such that they form the largest number.
For example:
Given [3, 30, 34, 5, 9], the largest formed number is 9534330.
Note: The result may be very large, so you need to return a string instead of an integer.
*/

public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public String largestNumber(final List<Integer> A) {
        int n = A.size();
        if(n == 1)
            return String.valueOf(A.get(0));
        
        Collections.sort(A,(a,b)->{
            StringBuilder s1 = new StringBuilder("");
            s1.append(a);
            StringBuilder s2 = new StringBuilder("");
            s2.append(b);
            StringBuilder x = s1.append(s2), y = s2.append(s1);
            int len = x.length();
            for(int i=0;i<len;i++) {
                if(x.charAt(i) == y.charAt(i))
                    continue;
                if(x.charAt(i) > y.charAt(i))
                    return -1;
                return 1;
            }
            return 0;
        });
        
        StringBuilder res = new StringBuilder("");
        for(int ele : A)
            res.append(ele);
        while (res.length() > 0 && res.charAt(0) == '0') 
            res.deleteCharAt(0);
        if (res.length() == 0) res.append(0);
        return res.toString();
    }
}
