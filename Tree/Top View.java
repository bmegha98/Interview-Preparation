//Given a pointer to the root of a binary tree, print the top view of the binary tree.The tree as seen from the top the nodes, is called the top view of the tree.

class Solution {

	/* 
    
    class Node 
    	int data;
    	Node left;
    	Node right;
	*/
    static class Pair {
        int key;
        Node value;
        public Pair(int k, Node v) {
            key = k;
            value = v;
        }
        public int getKey() {
            return key;
        }
        public Node getValue() {
            return value;
        }
    }
	public static void topView(Node root) {
      if(root == null)
        return;
      TreeMap<Integer,Integer> aux = new TreeMap<>();
     
      Queue<Pair> q = new LinkedList<>();
      q.add(new Pair(0,root));
      while(!q.isEmpty()) {
          Pair p = q.poll();
          Node curr = p.getValue();
          int level = p.getKey();
          if(!aux.containsKey(level))
            aux.put(level,curr.data);
          if(curr.left != null)
            q.add(new Pair(level-1, curr.left));
          if(curr.right != null)
            q.add(new Pair(level+1, curr.right));
      }
      
      for(Map.Entry<Integer,Integer> entry : aux.entrySet())
        System.out.print(entry.getValue()+" ");
       System.out.println();
    }

	public static Node insert(Node root, int data) {
        if(root == null) {
            return new Node(data);
        } else {
            Node cur;
            if(data <= root.data) {
                cur = insert(root.left, data);
                root.left = cur;
            } else {
                cur = insert(root.right, data);
                root.right = cur;
            }
            return root;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        Node root = null;
        while(t-- > 0) {
            int data = scan.nextInt();
            root = insert(root, data);
        }
        scan.close();
        topView(root);
    }	
}
