/*
An encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time and the following steps are
taken:

If the character read is a letter, that letter is written onto the tape.
If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.
*/

class Solution {
    public String decodeAtIndex(String S, int K) {
        long len = 0;
        if(K == 1)
            return String.valueOf(S.charAt(0));
        for(int i = 0;i<S.length();i++) {
            char ch = S.charAt(i);
            if(Character.isDigit(ch))
                len *= (ch-'0');
            else
                len++;
        }
        
        for(int i = S.length()-1;i>=0;i--) {
            char ch = S.charAt(i);
            if(Character.isDigit(ch)) 
                len /= (ch-'0');
            else
            {
                K %= len;
                if(K == 0)
                    return String.valueOf(ch);
                len--;
            }
        }
        return "";
    }
}
