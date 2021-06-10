/*
Given two n-ary trees. Check if they are mirror images of each other or not. You are also given e denoting the number of edges in both trees, and two arrays, A[] 
and B[]. Each array has 2*e space separated values u,v denoting an edge from u to v for the both trees.
Example 1:
Input:
n = 3, e = 2
A[] = {1, 2, 1, 3}
B[] = {1, 3, 1, 2}
Output:
1
Explanation:
   1          1
 / \        /  \
2   3      3    2 
As we can clearly see, the second tree is mirror image of the first.
Example 2:

Input:
n = 3, e = 2
A[] = {1, 2, 1, 3}
B[] = {1, 2, 1, 3}
Output:
1
Explanation:
   1          1
 / \        /  \
2   3      2    3 
As we can clearly see, the second tree isn't mirror image of the first.

At each level l, order of nodes in t1 = reverse(order of nodes at l in t2)
Store child nodes of each node of t1 in a stack 
*/

class Solution {
    static int checkMirrorTree(int n, int e, int[] A, int[] B) {
        Map<Integer,Stack<Integer>> aux = new HashMap<>();
        
        for(int i=0;i<2*e;i+=2) {
            Stack<Integer> s;
            if(aux.containsKey(A[i]))
                s = aux.get(A[i]);
            else
                s = new Stack<>();
            s.push(A[i+1]);
            aux.put(A[i],s);
        }
        
        for(int i=0;i<2*e;i+=2) {
            if(aux.get(B[i]).peek() != B[i+1])
                return 0;
            aux.get(B[i]).pop();
        }
        return 1;
    }
}
