// Construct a binary tree from inorder and post order traversals

 /* java program to construct a tree from inorder and postorder travesals */

  
class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int data){
        this.data = data;
        this.left = left;
        this.right = right;
    }
} 

 class Construct{
     
     int incr = 8;
      
      
     public TreeNode construct(int[] in, int[] post, int str, int end){
          
          if(str > end)  // boundary condition
            return null;
            
         TreeNode root = new TreeNode(post[incr--]); //save root
         
           int ind = findRoot(in,root,str,end); // find the index of the root
           root.right = construct(in,post,ind+1,end); // partition the array for right sub tree
           root.left = construct(in,post,str,ind-1);  // partition the arrray for left subtree
           
           return root;
     }
     
     public int findRoot(int[] in, TreeNode root, int str, int end){
         for(int i=str; i<=end; i++){
             if(in[i] == root.data)
             return i;
         }
          return 0;
     }
     
      public static void inorder(TreeNode root){
          if(root == null)
            return;
            
            inorder(root.left);
            System.out.print(root.data+" ");
            inorder(root.right);
      }
     
     
         public static void main (String[] args) {
           TreeNode root;
         int[] post = {1,9,6,16,15,18,7,8,3};
         int[] in = {1,9,3,6,8,7,16,15,18};
         
         int end = in.length- 1;
         Construct c = new Construct();
         root = c.construct(in,post,0,end);
         inorder(root);
     }
}
