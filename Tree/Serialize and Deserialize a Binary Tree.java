/*
Serialization is to store a tree in an array so that it can be later restored and Deserialization is reading tree back from the array. Now your task is to complete
the function serialize which stores the tree into an array A[ ] and deSerialize which deserializes the array to tree and returns it.
Note: The structure of tree must be maintained.
*/

class Tree 
{
    int pos;
    //Function to serialize a tree and return a list containing nodes of tree.
	public void serialize(Node root, ArrayList<Integer> A) 
	{
	    if(root == null) {
	        A.add(-1);
	        return;
	    }
	    A.add(root.data);
	    serialize(root.left, A);
	    serialize(root.right, A);
	}
	
	//Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A)
    {
        if(A.size() == 1) return null;
        pos = 0;
        return helper(A);
    }
    
    private Node helper(ArrayList<Integer> A) {
        if(A.get(pos) == -1) {
            pos++;
            return null;
        }
        Node root = new Node(A.get(pos));
        pos++;
        root.left = helper(A);
        root.right = helper(A);
        return root;
    }
}
