/*
Given a set of N nuts of different sizes and N bolts of different sizes. There is a one-one mapping between nuts and bolts. Match nuts and bolts efficiently.

Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means nut can only be compared with bolt and bolt can only be compared with nut to
see which one is bigger/smaller.
The elements should follow the following order ! # $ % & * @ ^ ~ .

Example 1:

Input: 
N = 5
nuts[] = {@, %, $, #, ^}
bolts[] = {%, @, #, $ ^}
Output: 
# $ % @ ^
# $ % @ ^
Example 2:

Input: 
N = 9
nuts[] = {^, &, %, @, #, *, $, ~, !}
bolts[] = {~, #, @, %, &, *, $ ,^, !}
Output: 
! # $ % & * @ ^ ~
! # $ % & * @ ^ ~
*/

class Solution {
    int partition(char[] A, int low, int high, char pivot) {
        int i = low;
        for(int j=low;j<high;j++) {
            if(A[j] < pivot) {
                char temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
            }
            else if(A[j] == pivot) {
                char temp = A[j];
                A[j] = A[high];
                A[high] = temp;
                j--;
            }
        }
        
        char temp = A[i];
        A[i] = A[high];
        A[high] = temp;
        
        return i;
    }
    
    void quickSort(char[] nuts, char[] bolts, int l, int h) {
        if(l > h)
            return;
        int pivot = partition(nuts,l,h,bolts[h]);
        partition(bolts,l,h,nuts[pivot]);
        
        quickSort(nuts,bolts,l,pivot-1);
        quickSort(nuts,bolts,pivot+1,h);
    }
    void matchPairs(char nuts[], char bolts[], int n) {
        // code here
        quickSort(nuts, bolts, 0, n-1);
    }
}
