 import java.util.*;

  class node{

    int data;
    node right,left;

    node(int data){
        this.data=data;
        this.left=null;
        this.right=null;
      }
    
   }

     public class DiagonalTraversal{

    node root;
    HashMap<Integer,ArrayList<Integer>> diagonal =new HashMap<Integer,ArrayList<Integer>>();

     public void diagonalTraversal(node n,int d,HashMap<Integer,ArrayList<Integer>> diagonal){
         if(n==null)
         return;
         ArrayList<Integer> a= diagonal.get(d); // take the list belonging to a particular level
         if(a==null)
             a=new ArrayList<Integer>();  // if visited for the first time then assign it.	

         a.add(n.data);

         diagonal.put(d,a);  insert the updated list and level. i.e parent and right child in same level
         diagonalTraversal(n.left,d+1,diagonal); // now call recursively the children the left child gets an increment in the level
         diagonalTraversal(n.right,d,diagonal); // the right children are called recursively keeping the level constant.
     }
     
      public void print(){
          for(ArrayList<Integer>a:diagonal.values()){  // for printing
              System.out.println(a);
          }
      }
    public static void main(String[] args){
        DiagonalTraversal dt= new DiagonalTraversal();
         dt.root=new node(3);
         dt.root.left=new node(7);
         dt.root.right=new node(10);
         dt.root.left.left=new node(12);
         dt.root.left.right=new node(9);
         dt.diagonalTraversal(dt.root,0,dt.diagonal);
         dt.print();
    }
 }

