//Given a BST and an integer K. Find the Kth Smallest element in the BST. 

//Space = O(n)

class Solution
{
    // Return the Kth smallest element in the given BST 
    public int KthSmallestElement(Node root, int K) 
    {
        // Write your code here
        if(root == null) return -1;
        if(root.left == null && root.right == null) {
            if(K == 1)
                return root.data;
            return -1;
        }
        Stack<Node> aux = new Stack<>();
        while(true) {
            while(root != null) {
                aux.push(root);
                root = root.left;
            }
            if(aux.isEmpty())
                break;
            root = aux.pop();
            if(--K == 0)
                return root.data;
            root = root.right;
        }
        return -1;
    }
}

//Space = O(1)

class Solution
{
    // Return the Kth smallest element in the given BST 
    public int KthSmallestElement(Node root, int K) 
    {
        // Write your code here
        if(root == null) return -1;
        if(root.left == null && root.right == null) {
            if(K == 1)
                return root.data;
            return -1;
        }
        Node curr = root;
        while(curr != null) {
            if(curr.left == null) {
                if(--K == 0)
                    return curr.data;
                curr = curr.right;
            }
            else {
                Node tmp = curr.left;
                while(tmp.right != null && tmp.right != curr)
                    tmp = tmp.right;
                if(tmp.right == null) {
                    tmp.right = curr;
                    curr = curr.left;
                }
                else {
                    tmp.right = null;
                    if(--K == 0)
                        return curr.data;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
}
