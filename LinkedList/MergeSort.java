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
    public node getMiddle(node h){
        node slow=h;
        node fast=h;
         if(h.next.next==null)
          return h;                      //two get 1st element when there are two elements
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public node mergeSort(node h){
        if(h.next!=null){  // to get only one element
        node middle=getMiddle(h);  //get the middle element
         node rmiddle=middle.next; 
         middle.next=null; // to seperate the list
         h=mergeSort(h);  
         rmiddle=mergeSort(rmiddle);
        h=merge(h,rmiddle); //get the merged list
        }
        return h;  // return the merged list
    }
    
     public node merge(node a,node b){
         node temp; // pointer to move around
         node head; // to save the head of the merged list
              if(a.data>b.data){
                 temp=b;
                 b=b.next;
             }
             else{
                 temp=a;
                 a=a.next;
             }
              head=temp;
         while(a!=null&&b!=null){
             if(a.data>b.data){
                 temp.next=b;
                 temp=temp.next;
                 b=b.next;
             }
             else{
                 temp.next=a;
                 temp=temp.next;
                 a=a.next;
             }
         }
             while(a!=null){
                 temp.next=a;
                 temp=temp.next;
                 a=a.next;
             }
                 while(b!=null){
                 temp.next=b;
                 temp=temp.next;
                 b=b.next;
             }
             
         
         return head; 
     }
   
      public static void main(String[] args){
          LinkedList ll=new LinkedList();
          ll.push(7);
          ll.push(2);
          ll.push(9);
          ll.push(4);
          ll.push(10);
          ll.head=ll.mergeSort(ll.head);
         ll.display();
     }
}
