/*
Serialization is to store a tree in an array so that it can be later restored and Deserialization is reading tree back from the array. Now your task is to complete
the function serialize which stores the tree into an array A[ ] and deSerialize which deserializes the array to the tree and returns it.
Note: The structure of the tree must be maintained. Multiple nodes can have the same data.
Example 1:

Input:
      1
    /   \
   2     3
Output: 2 1 3
Example 2:

Input:
         10
       /    \
      20    30
    /   \
   40  60
Output: 40 20 60 10 30
*/

class Tree 
{
    int ind = 0;
    //Function to serialize a tree and return a list containing nodes of tree.
	public void serialize(Node root, ArrayList<Integer> A) 
	{
	    //code here
	    if(root == null)
	        return;
	    preOrder(root, A);
	}
	
	private void preOrder(Node root, ArrayList<Integer> res) {
	    if(root == null) {
	        res.add(-1);
	        return;
	    }
	    res.add(root.data);
	    preOrder(root.left, res);
	    preOrder(root.right, res);
	}
	
	//Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A)
    {
        //code here
        int n = A.size();
        if(n == 0)
            return null;
        return constructTree(A, n);
    }
    
    private Node constructTree(ArrayList<Integer> pre, int n) {
        if(ind >= n)
            return null;
        int val = pre.get(ind);
        ind++;
        Node root = new Node(val);
        if(val == -1)
            return null;
        root.left = constructTree(pre, n);
        root.right = constructTree(pre, n);
        return root;
    }
}
