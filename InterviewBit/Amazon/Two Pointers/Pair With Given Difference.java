/*
Given an one-dimensional unsorted array A containing N integers.
You are also given an integer B, find if there exists a pair of elements in the array whose difference is B.
Return 1 if any such pair exists else return 0.
Problem Constraints
1 <= N <= 105
-103 <= A[i] <= 103
-105 <= B <= 105
Input Format
First argument is an integer array A of size N.Second argument is an integer B.
Output Format
Return 1 if any such pair exists else return 0.
Example Input
Input 1:

 A = [5, 10, 3, 2, 50, 80]
 B = 78
Input 2:

 A = [-10, 20]
 B = 30
Example Output
Output 1:

 1
Output 2:

 1
*/

//using HashSet A = [10,20] or [20,10] and B = 10
public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        Set<Integer> aux = new HashSet<>();
        for(int ele : A) {
            if(aux.contains(ele-B) || aux.contains(ele+B))
                return 1;
            aux.add(ele);
        }
        return 0;
    }
}

//using sorting
//A[j]-A[i] : Maximize by incrementing j and minimize by incrementing i
public class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();
        Collections.sort(A);
        int i = 0, j = 1;
        while(i <n && j<n) {
            int diff = A.get(j)-A.get(i);
            if(i!=j && diff == B)   //for case : B = 0
                return 1;
            if(diff < B) //maximize diff by incrementing A[j]
                j++;
            else
                i++;
        }
        return 0;
    }
}

