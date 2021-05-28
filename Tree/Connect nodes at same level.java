/*
You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.
*/

//Recursive 
class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        if(root.left == null && root.right == null)
            return root;
        root.left.next = root.right;
        if(root.next != null)
            root.right.next = root.next.left;
        root.left = connect(root.left);
        root.right = connect(root.right);
        return root;
    }
}

//Iterative : With queue
class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        if(root.left == null && root.right == null)
            return root;
        Queue<Node> aux = new LinkedList<>();
        aux.add(root);
        aux.add(null);
        
        while(!aux.isEmpty()) {
            Node curr = aux.poll();
            if(curr == null) {
                if(!aux.isEmpty())
                    aux.add(null);
            }
            else {
                curr.next = aux.peek();
                if(curr.left != null)
                    aux.add(curr.left);
                if(curr.right != null)
                    aux.add(curr.right);
            }
        }
        return root;
    }
}

//Constant Space : Works for standard binary tree also
class Solution {
    public Node connect(Node Root) {
        if(Root == null)
            return null;
        if(Root.left == null && Root.right == null)
            return Root;
        Node root = Root;
        while(root != null) {
            Node curr = root;
            Node dummy = new Node(-1);
            Node temp = dummy;
            while(curr != null) {
                if(curr.left != null) {
                    temp.next = curr.left;
                    temp = temp.next;
                    if(curr.right != null) {
                        temp.next = curr.right;
                        temp = temp.next;   
                    }
                }
                else if(curr.right != null) {
                    temp.next = curr.right;
                    temp = temp.next;
                }
                
                curr = curr.next;
            }
            root = dummy.next;
        }
        return Root;
    }
}
