
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
         public void rotateandDetect(){
             node slow=head;
             node fast=head;
             while(slow!=null||fast!=null||fast.next!=null){
                 slow=slow.next;
                 fast=fast.next.next;
                 if(slow==fast){
                    
                 remove(slow);
                  return;
                 }
             }
              System.out.println("no loops");   // slow and fast dint meet so no loop
         }
         public void remove(node slow){
            node ptr=slow.next;
            int count=1;
            while(ptr!=slow){  //count the length of the loop
                count++;
                ptr=ptr.next;
            }
              ptr=null;
              for(int i=0;i<count;i++){  //travel the length of the loop
                  if(ptr==null){
                  ptr=head;
                  continue;
                  }
                  ptr=ptr.next;
              }

              node front=head; //one step ahead so front reaches the intersection point first
              while(front!=ptr.next){   // Iterate till front reaches intersecion point.
   
                  front=front.next;
                  ptr=ptr.next;
              }
              ptr.next=null;  // remove the loop here
         }
          public static void main(String[] args){
          LinkedList ll=new LinkedList();
          ll.push(7);
          ll.push(2);
          ll.push(9);
          ll.push(4);
          ll.push(10);
          ll.head.next.next.next.next.next=ll.head.next.next;
          ll.rotateandDetect();
         ll.display();
     }
}

   Time complexity O(n)
