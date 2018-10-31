  /* Java program to convert Binary Tree into Doubly Linked List 
where the nodes are represented spirally */
  import java.util.Stack;
  import java.util.Queue;
  import java.util.LinkedList;
  
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

 class Spiral{
     

     public void convert(TreeNode root){
         Stack<TreeNode> st = new Stack<TreeNode>();
         Queue<TreeNode> q = new LinkedList<TreeNode>();
         LinkedList<TreeNode> ll = new LinkedList<TreeNode>(); //result linked list
         
         if(root == null)
          return;
         
         boolean alternate = true; // to change directions
        // System.out.print(root.data+" ");
           ll.add(root);
           
         
         if(root.left != null){
           //System.out.print(root.left.data+" ");
           ll.add(root.left);
           st.push(root.left);
         }
           if(root.right != null){
                //System.out.print(root.right.data+" ");
                ll.add(root.right);
                st.push(root.right);
           }
           
          while(!st.isEmpty()){
          
         if(alternate){
             while(!st.isEmpty()){
                 TreeNode temp = st.pop();
                 
                 if(temp.right!=null)
                  q.add(temp.right);
                  
                  if(temp.left != null)
                  q.add(temp.left);
             }
             
             while(!q.isEmpty()){
                 TreeNode temp = q.remove();
                //  System.out.print(temp.data+" ");
                  ll.add(temp);
                  st.push(temp);
             }
             alternate = false;
         }
         
         else{
              while(!st.isEmpty()){
                 TreeNode temp = st.pop();
        
                 if(temp.left!=null)
                  q.add(temp.left);
                  
                  if(temp.right != null)
                  q.add(temp.right);
              }
              while(!q.isEmpty()){
                 TreeNode temp = q.remove();
                 // System.out.print(temp.data+" ");
                  ll.add(temp);
                  st.push(temp);
             }
             alternate = true;
              
           }
         
        }
          for(TreeNode t : ll)
        System.out.print(t.data+" ");
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
          root.right.right.right = new TreeNode(1);
          
          Spiral s = new Spiral();
          s.convert(root);
          
     }
}
