import java.util.*;

 class SCCGraph{
    
    LinkedList<Integer> adjl[];
        int[] disc;
        int[] low;
        int time =0 ;
        Stack<Integer> st = new Stack();
        boolean[] stackMember;
        boolean[] visited;
        int V;
    
    @SuppressWarnings("unchecked")
    SCCGraph(int V){
        adjl = new LinkedList[V];
        
        for(int i=0;i<V;i++)
          adjl[i] = new LinkedList();
          
           this.V = V;
           disc = new int[V];
           low = new int[V];
           stackMember = new boolean[V];
           visited = new boolean[V];
    }
    
    public void addEdge(int u, int v){
        adjl[u].add(v);
    }
    
    public void DFS(int v){
        visited[v] = true;
        stackMember[v] = true;
        st.push(v);
        disc[v] = low[v] = time++;
        
        Iterator<Integer> itr = adjl[v].listIterator();
        
        while(itr.hasNext()){
             int u = itr.next();
             
            if(!visited[u]){
                DFS(u);
                
                low[v] = Math.min(low[u],low[v]);
            }
            
            else{
                  if(stackMember[u])
                low[v] = Math.min(low[v],disc[u]);
            }
              
        }
        
        if(low[v] == disc[v]){
            int top = st.peek();
            while(top != v)
            {
                System.out.print(top+" ");
                stackMember[top] = false;
                st.pop();
                top = st.peek();
            }
                System.out.print(top);
                System.out.println();
                stackMember[top] = false;
                st.pop();
                
        }
    }
    
    public void findSCC(){
        for(int i=0; i<V; i++)
          if(!visited[i])
            DFS(i);
    }
    
 public static void main (String[] args) {
     SCCGraph g = new SCCGraph(5);
     
        g.addEdge(1,0);
        g.addEdge(0,2);
        g.addEdge(2,1);
        g.addEdge(0,3);
        g.addEdge(3,4);
    
        g.findSCC();
    }
}
