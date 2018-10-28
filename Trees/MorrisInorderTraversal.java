   import java.util.Stack;

  class node{
    int data;
    node right,left;

    node(int data){
        this.data=data;
        right=left=null;
    }

  }

     class TBinarytree{
    node root;
    
    public void inorder(){
        node cur,pre;
        cur=root;
        while(cur!=null){
            if(cur.left==null){   //this happens at the leftmost child so its time to print it
                System.out.println(cur.data);
                cur=cur.right;
            }
            
            else{
                pre=cur.left; //  start from the left.
                while(pre.right!=null&&pre.right!=cur)  // go to the rightmost child
                pre=pre.right;
                   
                   if(pre.right==null){    // send a link to the current parent so that we can go back to the parent in later stages
                       pre.right=cur;
                       cur=cur.left;
                   }
                   
                   else{    // case when you have to go the parent. Like the inner node is visited once and  and you have to backtrack
                       pre.right=null;// remove that thread
                       System.out.println(cur.data);
                       cur=cur.right; // time to move right as you came out of thee inner subtrees. on the left
                   }
            }
        }
    }
    
    public static void main(String[] args){
         TBinarytree t=new TBinarytree();
         t.root=new node(4);
         t.root.left=new node(5);
         t.root.right=new node(9);
         t.root.left.left=new node(10);
         t.root.right.right=new node(6);
         t.inorder();
        }
  }
