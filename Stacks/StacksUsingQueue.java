/*  
Implement Stack using Queues

Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.
*/


class MyStack {
      
    Queue<Integer> q1;
    Queue<Integer> q2;

    public MyStack() {
        q1 = new LinkedList();
        q2 = new LinkedList();
    }
    

    public void push(int x) {
        q1.add(x);
    }
    
    
    public int pop() {
        while(q1.size() > 1){
            q2.add(q1.poll());
        }
        int ele = q1.poll();
        q1 = q2;
        q2 = new LinkedList();
        return ele;
    }
    
    
    public int top() {
          while(q1.size() > 1){
            q2.add(q1.poll());
        }
        int ele = q1.poll();
        q2.add(ele);
        q1 = q2;
        q2 = new LinkedList();
        return ele;
    }
    
   
    public boolean empty() {
        return(q1.size() == 0)?true:false;
    }
}
