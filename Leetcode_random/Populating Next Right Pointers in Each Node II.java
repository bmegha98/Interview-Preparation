/*
Given a binary tree

struct Node {
  int val;
  Node *left;
  Node *right;
  Node *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.
*/

//Using Queue
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
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

//Constant Space
class Solution {
    public Node connect(Node root) {
        if(root == null)
            return null;
        Node dummy;
        Node curr = root;
        while(curr != null) {
            dummy = new Node(-1);
            Node aux = dummy;
            while(curr != null) {
                if(curr.left != null) {
                    dummy.next = curr.left;
                    dummy = dummy.next;
                }
                if(curr.right != null) {
                    dummy.next = curr.right;
                    dummy = dummy.next;
                }
                curr = curr.next;
            }
            curr = aux.next;
        }
        return root;
    }
}
