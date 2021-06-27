/*
Given an array A of N elements. Find the majority element in the array. A majority element in an array A of size N is an element that appears more than N/2 times 
in the array.
Example 1:

Input:
N = 3 
A[] = {1,2,3} 
Output:
-1
Explanation: Since, each element in  {1,2,3} appears only once so there  is no majority element.
*/

//Using Sorting
class Solution
{
    static int majorityElement(int a[], int size)
    {
        Arrays.sort(a);
        int res = a[size/2];
        int count = 0;
        for(int ele : a)
            if(ele == res)
                count++;
        return count > size/2?res : -1;
    }
}

//Using Bit Masking
class Solution
{
    static int majorityElement(int a[], int size)
    {
        int res = 0;
        for(int i=0;i<32;i++) {
            int mask = (1 << i), count = 0;
            for(int ele : a)
                if((ele&mask) != 0)
                    count++;
            
            if(count > size/2)
                res |= mask;
        }
        return isMajorityElement(a, res) ? res : -1;
    }
    private static boolean isMajorityElement(int[] A, int res) {
        int count = 0;
        for(int ele : A)
            if(ele == res)
                count++;
        return count > A.length/2;
    }
}

//Using Moore's voting algorithm
class Solution
{
    static int majorityElement(int a[], int size)
    {
        int res = a[0], count = 1;
        for(int i=1;i<size;i++) {
            if(a[i] == res)
                count++;
            else
                count--;
            if(count == 0) {
                res = a[i];
                count = 1;
            }
        }
        if(count < 1)
            return -1;
        return isMajorityElement(a, res) ? res : -1;
    }
    private static boolean isMajorityElement(int[] A, int res) {
        int count = 0;
        for(int ele : A)
            if(ele == res)
                count++;
        return count > A.length/2;
    }
}
