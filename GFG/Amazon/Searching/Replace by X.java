/*
Given a string and a pattern, Replace all the continuous occurrence of pattern with a single X in the string. For a clear view see the example below.
Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is string str.
The second line of each test case contains a string s,which is a pattern.

Output:

Print the modified string str.

Constraints:

1 ≤ T ≤ 100
1 ≤ size of str,s ≤ 1000

Example:

Input
2
abababcdefababcdab
ab
geeksforgeeks
geeks

Output
XcdefXcdX
XforX
*/

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		int T;
		Scanner s = new Scanner(System.in);
		T = s.nextInt();
		while(T-- > 0) {
		    String str = s.next();
		    String p = s.next();
		    String tmp = str.replaceAll(p,"X");
		    StringBuilder res = new StringBuilder("");
		    for(char ch : tmp.toCharArray()) {
		        if(ch != 'X' || res.length() == 0)
		            res.append(ch);
		        else if(ch != res.charAt(res.length()-1))
		            res.append(ch);
		    }
		    System.out.println(res.toString());
		}
	}
}
