/*
Given a list of non negative integers, arrange them in such a manner that they form the largest number possible.The result is going to be very large, hence return 
the result in the form of a string.


Example 1:

Input: 
N = 5
Arr[] = {3, 30, 34, 5, 9}
Output: 9534330
Explanation: Given numbers are {3, 30, 34,
5, 9}, the arrangement 9534330 gives the
largest value.
Example 2:

Input: 
N = 4
Arr[] = {54, 546, 548, 60}
Output: 6054854654
Explanation: Given numbers are {54, 546,
548, 60}, the arrangement 6054854654 
gives the largest value.
*/

class Solution {
    String printLargest(String[] arr) {
        // code here
        Arrays.sort(arr, (s1,s2) -> {
            String FS = s1+s2;
            String SF = s2+s1;
            
            int i = 0;
            while(i< FS.length()) {
                if(FS.charAt(i) > SF.charAt(i))
                    return -1;
                if(FS.charAt(i) < SF.charAt(i))
                    return 1;
                i++;
            }
            return 0;
        });
        
        String res = "";
        for(String s : arr)
            res += s;
        return res;
    }
}
