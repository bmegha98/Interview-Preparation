/*
Given a matrix with n rows and m columns. Your task is to find the kth element which is obtained while traversing the matrix spirally. You need to complete the 
method findK which takes four arguments the first argument is the matrix A and the next two arguments will be n and m denoting the size of the matrix A and then 
the forth argument is an integer  k denoting the kth element . The function will return the kth element obtained while traversing the matrix spirally.


Example 1:

Input:
n = 3, m = 3, k = 4
A[][] = {{1 2 3},
         {4 5 6},
         {7 8 9}}
Output:
6
Explanation:
The matrix above will look like 
1 2 3
4 5 6
7 8 9
and the 4th element in spiral fashion
will be 6 .

Your Task:
You only need to implement the given function findK(). Do not read input, instead use the arguments given in the function. Return the K'th element obtained by 
traversing matrix spirally.


Expected Time Complexity: O(N*M)
Expected Auxiliary Space: O(N*M)


Constraints:
1<=n,m<=20
1<=k<=n*m
*/

class GfG
{
    /*You are required to complete this method*/
    int findK(int A[][], int n, int m, int k)
    {
	    // Your code here	
	    int[] aux = new int[n*m];
	    int j = 0;
	    
	    int firstRow = 0, lastCol = m-1, lastRow = n-1, firstCol = 0;
	    do {
	        for(int i=firstCol;i<=lastCol;i++)
	            aux[j++] = A[firstRow][i];
	        firstRow++;
	        if(firstRow > lastRow)
	            break;
	        for(int i=firstRow;i<=lastRow;i++)
	            aux[j++] = A[i][lastCol];
	        lastCol--;
	        if(firstCol > lastCol)
	            break;
	        for(int i=lastCol;i>=firstCol;i--)
	            aux[j++] = A[lastRow][i];
	        lastRow--;
	        if(firstRow > lastRow)
	            break;
	        for(int i=lastRow;i>=firstRow;i--)
	            aux[j++] = A[i][firstCol];
	        firstCol++;
	    }
	    while(firstRow <= lastRow && firstCol <= lastCol);
	    
	    return aux[k-1];
    }
}
