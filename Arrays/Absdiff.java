 // In a BST inorder traversal gives ascending order

       import java.util.Arrays;

  public class Decreasebyk {

    static int[] a ; 

    public static void main(String[] args) {
          int k=4;
         a=new int[]{9,12,34,2,1,6,10};
            
           treeSort(a,k);                
    }
      public static void treeSort(int []a,int k){
          node root=new node((Integer)Math.abs(a[0]-k),0);
          for(int i=1;i<a.length;i++){
             
              insert(root,(Integer) Math.abs(a[i]-k),i);
          } 
               display(root);    
      }
 // ====== insering elemets to form binary search tree ====================     
      public static node insert(node n,Integer e,int i){
          if(n==null){
              return new node(e,i);
              
          }
          if(n.Element>e){     //doubt here
             n.left=insert(n.left,e,i);  
            
          }
          if(n.Element<=e){
             n.right=insert(n.right,e,i);
          }
          return n;
      }
      //========== display elements in ascending order ===============  
      public static void display(node n){
            if(n!=null){
                 display(n.left); ;
              System.out.println(a[n.ind]);
              display(n.right); 
            
          }
          
      }
   }

     class node{
         Integer Element;
         int ind;
         node left,right;
         node(Integer e, int ind){
             this(e,null,null,ind);
         }
         node(Integer e,node left,node right,int ind){
             this.Element=e;
             this.left=left;
             this.right=right;
             this.ind=ind;
         }
     }
