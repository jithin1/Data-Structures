 class node{
    int data;
    node right,left;
    node(int data){
        this.data=data;
        left=right=null;
       }
  }
    
   public class Tree2Dll{
       
       node head;
       node root;
       node prev=null;
       public void convert(node cur){

             if(cur==null)
             return;
             else{
                 convert(cur.left);
                 if(prev==null)                       // do an inorder traversal                                                      
                  head=cur;                          // at the same time create a doubly linked list
                  else{
                      prev.right=cur;                  // prev has to have a link forward so prev.right= cur
                      cur.left=prev;                    // also the current node must point backward so cur.left= prev
                      }
                  prev=cur;                          // now change the prev to root
                   convert(cur.right);
             }
       }
       
        public void printList(){
            node temp=head;
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.right;
            }
        }
       
        public static void main(String[] args){
            Tree2Dll tree= new Tree2Dll();
          tree.root = new node(10);
          tree.root.left = new node(12);
          tree.root.right = new node(15);
          tree.root.left.left = new node(25);
          tree.root.left.right = new node(30);
          tree.root.right.left = new node(36);
          
        tree.convert(tree.root);
           tree.printList();
        }
    }
