/*
You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.

There are two types of logs:

Letter-logs: All words (except the identifier) consist of lowercase English letters.
Digit-logs: All words (except the identifier) consist of digits.
Reorder these logs so that:

The letter-logs come before all digit-logs.
The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
The digit-logs maintain their relative ordering.
Return the final order of the logs.

 

Example 1:

Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
Explanation:
The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".
Example 2:

Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
*/

//Each String comparison takes O(m) time.There are O(nlogn) comparisons. Therefore, Total time = O(m*nlogn), Space = O(1)

class Solution {
    public String[] reorderLogFiles(String[] logs) {
        int n = logs.length;
        if(n == 1)
            return logs;
        
        Arrays.sort(logs,new Comparator<String>(){
            public int compare(String a, String b) {
                int ind1 = a.indexOf(' ');
                int ind2 = b.indexOf(' ');
                
                char cha = a.charAt(ind1+1), chb = b.charAt(ind2+1);
                if(Character.isDigit(cha)) {
                    if(Character.isDigit(chb))
                        return 0;
                    return 1;
                }
                if(Character.isDigit(chb))
                    return -1;
                int compareContents = a.substring(ind1+1).compareTo(b.substring(ind2+1));
                if(compareContents == 0)
                    return a.substring(0,ind1).compareTo(b.substring(0,ind2));
                return compareContents;
            }
        });
        return logs;
    }
}
