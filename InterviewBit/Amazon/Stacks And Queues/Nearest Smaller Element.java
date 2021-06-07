/*
Given an array, find the nearest smaller element G[i] for every element A[i] in the array such that the element has an index smaller than i.
More formally,

    G[i] for an element A[i] = an element A[j] such that 
    j is maximum possible AND 
    j < i AND
    A[j] < A[i]
Elements for which no smaller element exist, consider next smaller element as -1.
Input Format
The only argument given is integer array A.
Output Format

Return the integar array G such that G[i] contains nearest smaller number than A[i].If no such element occurs G[i] should be -1.
For Example

Input 1:
    A = [4, 5, 2, 10, 8]
Output 1:
    G = [-1, 4, -1, 2, 2]
Explaination 1:
    index 1: No element less than 4 in left of 4, G[1] = -1
    index 2: A[1] is only element less than A[2], G[2] = A[1]
    index 3: No element less than 2 in left of 2, G[3] = -1
    index 4: A[3] is nearest element which is less than A[4], G[4] = A[3]
    index 4: A[3] is nearest element which is less than A[5], G[5] = A[3]
*/

public class Solution {
    public ArrayList<Integer> prevSmaller(ArrayList<Integer> A) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = A.size();
        if(n == 1) {
            res.add(-1);
            return res;
        }
        int[] tmp = new int[n];
        Stack<Integer> aux = new Stack<>();
        for(int i =0;i<n;i++) {
            while(!aux.isEmpty() && aux.peek() >= A.get(i))
                aux.pop();
            tmp[i] = aux.isEmpty()?-1:aux.peek();
            aux.push(A.get(i));
        }
        for(int ele : tmp) res.add(ele);
        return res;
    }
}
