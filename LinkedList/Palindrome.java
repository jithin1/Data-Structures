       class node{
          char data;
          node next;
        node(char d){
            data=d;
            next=null;
        }
    }

   public class LinkedList {
    node head;

    public void push(char i) {
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

   

    public boolean palindrome() {
        node slow=head;
        node fast=head;
        node second_half=null;
        while(slow!=null&&fast!=null&&fast.next!=null){  // reach the middle
            slow=slow.next;
            fast=fast.next.next;
              
        }
        if(fast!=null){
            second_half=slow.next;  // find from where to reverse depending on even or odd length
                                      // here it is odd length
        }
        else{
            second_half=slow;
        }
       second_half =reverse(second_half);  // reverse here
        node temp2=second_half;          // save this location so as to get back the original list later
           node temp=head;
           while(temp2!=null){
               if(temp.data==temp2.data){
                   temp=temp.next;
                   temp2=temp2.next;
                   continue;
               }
               reverse(second_half);     // reverse back to original list
               return false;
           }
               reverse(second_half);   // reverse back to original list
               return true;
    }

           public node reverse(node begin){
            node prev=null;
            node cur=begin;
            node next=null;
            while(cur!=null){
                next=cur.next;
                cur.next=prev;
                prev=cur;
                cur=next;
            }
            return prev;
        }
    
      public static void main(String[] args){
          LinkedList ll=new LinkedList();
          ll.push('a');
          ll.push('b');
          ll.push('c');
          ll.push('b');
          ll.push('a');
          System.out.println(ll.palindrome());
          ll.display();
     }
 }
