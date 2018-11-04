/*    Find the vertex from which we can reach all the vertex in the graph
     1) use dfs
     2) when visited is all true we might have found that vertex  */

   import java.util.*;

      class Graph{
    int V;
    LinkedList<Integer>[] adjl;
    boolean[] visited;

    Graph(int V){
        
        this.V=V;
         adjl= new LinkedList[V];
          visited = new boolean[V];
          
         for(int v=0;v<V;v++)
          adjl[v]=new LinkedList<Integer>();
         
    }
    
    public void setEdge(int i,int j){
        adjl[i].add(j);
    }
    
    public void DFS(int v){  // goes to all possible path from v
        visited[v]=true;
        
        Iterator<Integer> it= adjl[v].listIterator();
          while(it.hasNext()){
              int s=it.next();
              if(!visited[s])
               DFS(s); 
          }
    }
    
    public int motherVertex(){
        int r=-1;
        for(int v=0;v<V;v++){
            if(!visited[v]){  // mother not found yet  
            DFS(v);
            r=v; // potential Mother vertex possibly the first one found from 0
            }
        }
        
        for(int v=0;v<V;v++)
          visited[v]=false;
          
           DFS(r);
           
           for(int v=0;v<V;v++){  //verifying if r is actually the mother vertex or not.
             if(!visited[v])
              return -1;   // we could'nt reach all the vertices from this potential mother vertex
           }
           return r;
    }
    
    public static void main(String[] args){
        Graph g1=new Graph(5);
        g1.setEdge(0,2);
        g1.setEdge(2,3);
        g1.setEdge(3,2);
        g1.setEdge(4,0);
        g1.setEdge(1,0);
        g1.setEdge(1,4);
        System.out.print(g1.motherVertex());
       }
  }
