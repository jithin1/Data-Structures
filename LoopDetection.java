
  //  Using  Floyd’s Cycle-Finding Algorithm

      class node{
          int data;
          node next;
        node(int d){
            data=d;
            next=null;
        }
    }
 
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

   

    public boolean cycle() {
        node slow=head;
        node fast=head;
        while(slow!=null&&fast!=null&&fast.next!=null){   //for odd length
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow)  // fast moves at 2 times speed. so if there is a  loop
                                 // fast will catch up with slow before slow finishes
                                    // the length of the list.
                return true;
        }
        return false;
    }

    
      public static void main(String[] args){
          LinkedList ll=new LinkedList();
          ll.push(3);
          ll.push(4);
          ll.push(5);
          ll.head.next.next.next=ll.head;
          System.out.println(ll.cycle());
          
          //ll.display();
     }
}
