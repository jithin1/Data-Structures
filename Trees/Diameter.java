/* java program to find the diameter of a given tree */


   20) Diameter of a tree

     class node{
    int data;
    node left,right;
    
    node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
    }
 }

    class Diameter{
        node root;
        
        public int diameter(node a){

            if(a==null)
            return 0;
            int lheight=getHeight(a.left);  // left subtree height
            int rheight=getHeight(a.right);
            
            int ldiameter=diameter(a.left);  // calculate diametr of right subtrees
            int rdiamter=diameter(a.right);  /.calculate diameter of left sub trees
            
            return Math.max(lheight+rheight+1,Math.max(ldiameter,rdiamter));
        }
        
         public int getHeight(node a){
            if(a==null)
            return 0;
            
            return 1+Math.max(getHeight(a.left),getHeight(a.right));
         }
        
        public static void main(String[] args){
            Diameter d=new Diameter();
            d.root=new node(3);
            d.root.right=new node(12);
            d.root.left=new node(4);
            d.root.left.left=new node(5);
            d.root.left.left.right=new node(1);
            d.root.left.left.right.left=new node(6);
            d.root.left.left.right.left.left=new node(7);
            d.root.left.right=new node(10);
            d.root.left.right.left=new node(11);
            d.root.left.right.left.right=new node(14);
            d.root.left.right.left.right.right=new node(16);
            
            System.out.println(d.diameter(d.root));
        }
    }

