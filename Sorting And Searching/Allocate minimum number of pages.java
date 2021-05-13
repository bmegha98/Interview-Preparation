/*
You are given N number of books. Every ith book has Ai number of pages. 
You have to allocate books to M number of students. There can be many ways or permutations to do so. In each permutation, one of the M students will be allocated 
the maximum number of pages. Out of all these permutations, the task is to find that particular permutation in which the maximum number of pages allocated to a 
student is minimum of those in all the other permutations and print this minimum value. 
Each book will be allocated to exactly one student. Each student has to be allocated at least one book.
Note: Return -1 if a valid assignment is not possible, and allotment should be in contiguous order (see the explanation for better understanding).
Example 1:

Input:
N = 4
A[] = {12,34,67,90}
M = 2
Output:
113
Explanation: 
Allocation can be done in following ways:
{12} and {34, 67, 90} Maximum Pages = 191
{12, 34} and {67, 90} Maximum Pages = 157
{12, 34, 67} and {90}  Maximum Pages =113
Therefore, the minimum of these cases is 
113, which is selected as the output.
*/

//T(n) = O(log(sum(a)))

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]a,int n,int m)
    {
        if(n == 1)
            return a[0];
        int maxPages = getSum(a);
        if(m == 1)
            return maxPages;
        if(n < m)
            return -1;
        int minPages = getMax(a);
        int res = -1;
        while(minPages<=maxPages) {
            int mid = minPages+(maxPages-minPages)/2;
            int students = getStudents(a,mid);
            if(students > m)
                minPages = mid+1;
            else {
                res = mid;
                maxPages = mid-1;
            }
        }
        return res;
    }
    
    private static int getStudents(int[] a,int maxPages) {
        int count = 1,pages = 0;
        for(int ele : a){
            pages += ele;
            if(pages > maxPages) {
                pages = ele;
                count++;
            }
        }
        return count;
    }
    
    private static int getMax(int A[]) {
        int ans = 0;
        for(int ele : A)
            ans = Math.max(ans,ele);
        return ans;
    }
    
    private static int getSum(int A[]) {
        int sum = 0;
        for(int ele : A)
            sum += ele;
        return sum;
    }
}
