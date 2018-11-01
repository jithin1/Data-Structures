  /* Java program to print the sum of data in leaf nodes */

  
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

 class Sumofleaf{
     

     public int sum(TreeNode root){
          if(root == null)
            return 0;
            
          else{
            
            if(root.left == null && root.right == null)    // reached the leaf node
                return root.data;
                
             int result = sum(root.left) + sum(root.right);  // to store the result of addition
              return result;
          }
          
         
     }
     
     
         public static void main (String[] args) {
           
          TreeNode root = new TreeNode(5);
          root.left = new TreeNode(3);
          root.right = new TreeNode(7);
          root.left.left = new TreeNode(6);
          root.left.right = new TreeNode(12);
          root.right.left = new TreeNode(2);
          root.right.right = new TreeNode(11);
          root.left.left.left = new TreeNode(13);
          root.left.left.right = new TreeNode(14);
          root.left.right.left = new TreeNode(15);
          root.left.right.right = new TreeNode(16);
          root.right.left.left = new TreeNode(9);
          root.right.left.right = new TreeNode(19);
          root.right.right.left = new TreeNode(21);
          
          Sumofleaf s = new Sumofleaf();
          System.out.println(s.sum(root));
          
     }
}

Time complexity = O(n) 
