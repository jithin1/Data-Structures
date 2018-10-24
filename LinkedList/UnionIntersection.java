	import java.util.HashSet;
  
          class node{
         
              int data;
        
                  node next;
    
                 node(int d){
           
                    data=d;
          
                 next=null;
       
                          }
    
                  }
   

       public class LinkedList 
         {
   
       node head;
   
        public void push(int i) {
       
        node n=new node(i);
       
           n.next=head;
       
                   head=n;        
    }

       
            public static void main(String[] args){
          
              LinkedList ll=new LinkedList();
          
            ll.push(3);
     
          ll.push(4);
 
         ll.push(5);
  
        ll.push(7);
 
         ll.push(9);

 
         LinkedList l2=new LinkedList();
  
        l2.push(1);
   
       l2.push(8);
 
         l2.push(9);
 
         l2.push(3);
  
        l2.push(4);
 
         node hu=union(ll.head,l2.head);
 
         node hi=intersection(ll.head,l2.head);
  
        LinkedList union=new LinkedList();
 
         union.head=hi;
   
       union.display();
   
     
 
     }

     
      public static node intersection(node h1, node h2) {
 
   	  HashSet<Integer> hs=new HashSet<Integer>();
  

		node result=null; //head of resulting list
 
 		node ptr=null; //pointer to move around the list

  		hs.add(h1.data); //enter first value into the hash set
 
 		while(h1.next!=null){
 
 			h1=h1.next;
 
			hs.add(h1.data);
	  //enter all values into hashset
  	}


		while(h2!=null){
			
      if(hs.contains(h2.data)){
				
            if(result==null){
					
      result=new node(h2.data); //initialize


			ptr=result; 

			h2=h2.next;

			continue;

				 }
		
		ptr.next=new node(h2.data); //insert second value to the list
		
		ptr=ptr.next;
			
         	h2=h2.next;
	
		}

			else{
				
                   h2=h2.next;				
			
                           }
		
         }
		
            return result;
	
     }
  
    
	
    public void display() {
   
       node temp=head;
  
        while(temp!=null){
  
            System.out.println(temp.data);
 
             temp=temp.next;
   
       }
  
    }


	
      private static node union(node h1, node h2) {

		HashSet<Integer> hs=new HashSet<Integer>();

		node result=null;

		node ptr=null;

		hs.add(h1.data);

		result=new node(h1.data);

		ptr=result;


		while(h1.next!=null){

			h1=h1.next;

			ptr.next=new node(h1.data); //add all values to the list

			ptr=ptr.next;

			hs.add(h1.data);
	
		}
	
	
                  while(h2!=null){

			if(hs.contains(h2.data)){
				h2=h2.next;

			}

			else{

				ptr.next=new node(h2.data); //insert new value to the list

				ptr=ptr.next;

				h2=h2.next;

			}

		}
		
                   return result;
	
     }

  }

