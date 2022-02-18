/*
Given a Two Binary Trees, write a function that returns true if one is mirror of other, else returns false.
MirrorTree1            

Example 1:

Input:
T1:     1     T2:     1
      /   \         /   \
     2     3       3     2
Output: 1
Example 2:

Input:
T1:     10      T2:   10
       /  \          /  \
      20  30        20  30
     /  \          /  \
    40   60       40  60
Output: 0

Your Task:
You don't need to take input. Just complete the function areMirror() that takes root node of two tree as parameter and returns true, if one is the mirror of other
else returns false. (The driver's code print 1 if the returned value is true, otherwise 0)
*/

class Solution {
    boolean areMirror(Node a, Node b) {
        // Your code here
        if(a==null && b==null)
            return true;
        if(a==null || b==null)
            return false;
        return (a.data == b.data)
                &&areMirror(a.left,b.right)
                &&areMirror(a.right,b.left);
    }
}
