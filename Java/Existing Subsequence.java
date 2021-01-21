/*
You are given two arrays of size n1 and n2. The arrays contains distinct elements. Your task is to find if all the elements of arr2 appear as a subsequence in the 
arr1. If yes, print 1; else print 0.
*/

class Geeks
{
    static void hasSubseq(int arr1[],int arr2[])
    {
        
        //Your code here.
        int m = arr1.length,n = arr2.length;
        int i=0,j = 0;
        while(i<m && j<n)
        {
            if(arr1[i] == arr2[j])
                j++;
            i++;
        }
        if(j == n)
            System.out.print(1);
        else
            System.out.print(0);
    }
}
