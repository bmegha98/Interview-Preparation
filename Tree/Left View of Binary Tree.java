/*
Given a Binary Tree, print Left view of it. Left view of a Binary Tree is set of nodes visible when tree is visited from Left side. The task is to complete the
function leftView(), which accepts root of the tree as argument.
Left view of following tree is 1 2 4 8.

          1
       /     \
     2        3
   /     \    /    \
  4     5   6    7
   \
     8   
*/

class Tree
{
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root)
    {
        // Your code here
        ArrayList<Integer> res = new ArrayList<>();
        if(root == null)
            return res;
      
        Queue<Node> aux = new LinkedList<>();
        res.add(root.data);
        aux.add(root);
        aux.add(null);
      
        while(!aux.isEmpty()) {
            Node curr = aux.poll();
            if(curr == null) {
                if(!aux.isEmpty()) {
                    res.add(aux.peek().data);
                    aux.add(null);
                }
            }
            else {
                    if(curr.left != null)
                        aux.add(curr.left);
                    if(curr.right != null)
                        aux.add(curr.right);
                }
        }
        return res;
    }
}
