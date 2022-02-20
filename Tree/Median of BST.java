/*
Given a Binary Search Tree of size N, find the Median of its Node values.

Example 1:

Input:
       6
     /   \
   3      8   
 /  \    /  \
1    4  7    9
Output: 6
Explanation: Inorder of Given BST will be:
1, 3, 4, 6, 7, 8, 9. So, here median will 6.

Example 2:

Input:
       6
     /   \
   3      8   
 /   \    /   
1    4   7   
Output: 5
Explanation:Inorder of Given BST will be:
1, 3, 4, 6, 7, 8. So, here median will
(4 + 6)/2 = 10/2 = 5.
 

Your Task:
You don't need to read input or print anything. Your task is to complete the function findMedian() which takes the root of the Binary Search Tree as input and
returns the Median of Node values in the given BST.
Median of the BST is:

If number of nodes are even: then median = (N/2 th node + (N/2)+1 th node)/2
If number of nodes are odd : then median = (N+1)/2th node.

*/
//T(n) = Space = O(n)
class Tree
{
    public static float findMedian(Node root) {
        // code here.
        ArrayList<Integer> inOrder = new ArrayList<>();
        while(root != null) {
            if(root.left == null) {
                inOrder.add(root.data);
                root = root.right;
            }
            else {
                Node pre = root.left;
                while(pre.right != null && pre.right != root)
                    pre = pre.right;
                
                if(pre.right == null) {
                    pre.right = root;
                    root = root.left;
                }
                else {
                    pre.right = null;
                    inOrder.add(root.data);
                    root = root.right;
                }
            }
        }
        
        int n = inOrder.size();
        if(n%2 == 0)
            return (inOrder.get(n/2) + inOrder.get(n/2 - 1))/2.0f;
        return inOrder.get(n/2);
    }
}

//Using rank
class Tree
{
    private static int countNodes(Node root) {
        if(root == null)
            return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    private static int findNode(Node root, int rank, int serialNum, int[] val) {
        if(root == null)
            return serialNum;
        serialNum = findNode(root.left, rank, serialNum, val);
        serialNum++;
        if(serialNum == rank)
            val[0] = root.data;
        //System.out.println(l+r);
        serialNum = findNode(root.right, rank, serialNum, val);
        
        return serialNum;
    }
    public static float findMedian(Node root)
    {
        // code here.
        int n = countNodes(root);
        if(n%2 == 1) {
            int[] mid = new int[1];
            findNode(root,n/2+1,0,mid);
            return mid[0];
        }
        
        int[] mid1 = new int[1];
        int[] mid2 = new int[1];
        
        findNode(root,n/2,0,mid1);
        findNode(root,n/2+1,0,mid2);
        
        return (mid1[0]+mid2[0])/2.0f;
    }
}
