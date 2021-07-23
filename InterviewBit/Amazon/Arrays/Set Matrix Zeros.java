/*
Given a matrix, A of size M x N of 0s and 1s. If an element is 0, set its entire row and column to 0.
Note: This will be evaluated on the extra memory used. Try to minimize the space and time complexity.
Input Format:
The first and the only argument of input contains a 2-d integer matrix, A, of size M x N.
Output Format:
Return a 2-d matrix that satisfies the given conditions.
Constraints:

1 <= N, M <= 1000
0 <= A[i][j] <= 1
Examples:

Input 1:
    [   [1, 0, 1],
        [1, 1, 1], 
        [1, 1, 1]   ]

Output 1:
    [   [0, 0, 0],
        [1, 0, 1],
        [1, 0, 1]   ]

Input 2:
    [   [1, 0, 1],
        [1, 1, 1],
        [1, 0, 1]   ]

Output 2:
    [   [0, 0, 0],
        [1, 0, 1],
        [0, 0, 0]   ]
*/

//Using additional space, O(m+n)
public class Solution {
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
	    int m = a.size(), n = a.get(0).size();
	    Set<Integer> row = new HashSet<>();
	    Set<Integer> col = new HashSet<>();
	    
	    for(int i=0;i<m;i++)
	        for(int j=0;j<n;j++)
	            if(a.get(i).get(j) == 0) {
	                row.add(i);
	                col.add(j);
	            }
	   
	   for(int i=0;i<m;i++)
	       for(int j=0;j<n;j++) 
	            if(row.contains(i) || col.contains(j))
	                a.get(i).set(j,0);
	                
	}
}

//using first row and first col to determine if a particular row/col should set to 0 or not.
public class Solution {
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
	    int m = a.size(), n = a.get(0).size();
	    boolean row = false, col = false;
	    for(int j=0;j<n;j++)
	        if(a.get(0).get(j) == 0) {
	            row = true;
	            break;
	        }
	   
	    for(int i=0;i<m;i++)
	        if(a.get(i).get(0) == 0) {
	            col = true;
	            break;
	        }
	    
	    for(int i=1;i<m;i++)
	        for(int j=1;j<n;j++)
	            if(a.get(i).get(j) == 0) {
	                a.get(0).set(j,0);
	                a.get(i).set(0,0);
	            }
	   
	   for(int i=1;i<m;i++)
	       for(int j=1;j<n;j++) 
	            if(a.get(i).get(0) == 0 || a.get(0).get(j) == 0)
	                a.get(i).set(j,0);
	   if(row)
	        for(int j=0;j<n;j++)
	            a.get(0).set(j,0);
	   if(col)
	        for(int i=0;i<m;i++)
	            a.get(i).set(0,0);
	                
	}
}
