/*
A celebrity is a person who is known to all but does not know anyone at a party. If you go to a party of N people, find if there is a celebrity in the party or not.
A square NxN matrix M[][] is used to represent people at the party such that if an element of row i and column j  is set to 1 it means ith person knows jth person.
Here M[i][i] will always be 0.
Note: Follow 0 based indexing.
 
*/

class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	// code here 
    	int left = 0, right = n-1;
    	while(left < right) {
    	    //A knows B i.e. A cannot be the celebrity
    	    if(M[left][right] == 1)
    	        left++;
    	    else               //A doesn't know B i.e. B cannot be the celebrity
    	        right--;
    	}
    	
    	boolean isCelebrity = true;
    	for(int i = 0;i<n;i++) 
    	    if(i != left && M[i][left] == 0)
    	    {
    	        isCelebrity = false;
    	        break;
    	    }
    	if(!isCelebrity)
    	    return -1;
    	for(int i =0;i<n;i++)
    	    if(M[left][i] == 1) {
    	        isCelebrity = false;
    	        break;
    	    }
    	
    	return isCelebrity?left:-1;
    }
}
