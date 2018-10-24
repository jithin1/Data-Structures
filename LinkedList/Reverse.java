   public class LinkedList {
    node head;

    public void push(int i) {
        node n=new node(i);
        n.next=head;
        head=n;
        
    }

    public void display() {
        node temp=head;
        while(temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

   

    public void reverse() {
        node prev=null;
        node cur=head;                                            		   
        node next=null;
        while(cur!=null){
            next=cur.next;    //moving to next node  
            cur.next=prev;   //reverse is performed here
            prev=cur;        // moving prev to current so as to record the next move
            cur=next;      //now going to next node using next as cur.next points backwards
            
        }
        head=prev;
    }
    class node{
          int data;
          node next;
        node(int d){
            data=d;
            next=null;
        }
    }
    
      public static void main(String[] args){
          LinkedList ll=new LinkedList();
          ll.push(3);
          ll.push(4);
          ll.push(5);
          ll.reverse();
          ll.display();
     }
}
