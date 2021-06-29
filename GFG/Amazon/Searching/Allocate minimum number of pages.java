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
Allocation can be done in following ways: {12} and {34, 67, 90} Maximum Pages = 191 
{12, 34} and {67, 90} Maximum Pages = 157
{12, 34, 67} and {90}  Maximum Pages =113
Therefore, the minimum of these cases is 113, which is selected as the output.
Example 2:

Input:
N = 3
A[] = {15,17,20}
M = 2
Output:
32
Explanation:
Allocation is done as {15,17} and {20}

Hint :
We need to think whether we can find how many number of students we need if we fix that one student can read at most V number of pages. So, our problem statement
reduces to : Given fixed number of pages (V),  how many number of students we need?
*/

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]a,int n,int m)
    {
        int minPages = getMax(a);
        int maxPages = getSum(a);
        
        int ans = -1;
        while(minPages <= maxPages) {
            int mid = minPages + (maxPages-minPages)/2;
            int studentsRequired = getStudents(a,mid);
            
            if(studentsRequired <= m) {
                ans = mid;
                maxPages = mid-1;
            }
            else
                minPages = mid+1;
        }
        return ans;
    }
    private static int getMax(int[] A) {
        int max = 0;
        for(int ele : A)
            if(ele > max)
                max = ele;
        return max;
    }
    private static int getSum(int[] A) {
        int s = 0;
        for(int ele : A)
            s += ele;
        return s;
    }
    private static int getStudents(int[] A, int pages) {
        int count = 1;
        int tmp = 0;
        for(int ele : A) {
            tmp += ele;
            if(tmp > pages) {
                count++;
                tmp = ele;
            }
        }
        return count;
    }
}
