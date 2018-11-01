/* program to find the lowest common ancestor in a binary tree  */

 
     class Node 
   { 
	int data;
	Node left, right;

	Node(int item) 
	{
		data = item;
		left = right = null;
	}
   }

     class BinaryTree 
    {
	Node root;
	

	public Node lca(Node node, int n1, int n2) {
         while(node!=null){
             if(node.data>n1&&node.data>n2) //if node is greater than both the nodes search left
             node=node.left;
             else if(node.data<n1&&node.data<n2)   //if node is lesser than both the nodes.
              node=node.right;
              else{                      // we found the lca here.
                  break;
              }
         }
         
         return node;
	}


	public static void main(String args[]) 
	{
		// Let us construct the BST shown in the above figure
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(20);
		tree.root.left = new Node(8);
		tree.root.right = new Node(22);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(12);
		tree.root.left.right.left = new Node(10);
		tree.root.left.right.right = new Node(14);

		int n1 = 4, n2 = 22;
		Node t = tree.lca(tree.root, n1, n2);
		System.out.println("LCA of " + n1 + " and " + n2 + " is " + t.data);


	}
   }
