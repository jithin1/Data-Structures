
  // 22) Finding shortest path in a DAG using topological sort and dijksrta algo

    import java.util.*;
   class node{
  int v;
  int weight;
  node(int v, int weight){
      this.v=v;
      this.weight=weight;
      }
   }


    class Graph{
    
    int V;
    ArrayList<node>[] adjList;
    
 @SuppressWarnings("unchecked")
    Graph(int V){
      this.V=V;
      adjList=new ArrayList[V];
      
      for(int i=0;i<V;i++)
       adjList[i]=new ArrayList<node>();
       
    }
    
    public void addEdge(int u,int v, int weight){
        adjList[u].add(new node(v,weight));
    }
    
          public void topologicalSort(int src, boolean[] visited , Stack<Integer> st){
              if(!visited[src]){
                  
                  visited[src]=true;
                  
                  Iterator<node> itr=adjList[src].listIterator();
                  while(itr.hasNext()){
                      node n=itr.next();
                       int v=n.v;
                       topologicalSort(v,visited,st);
                  }
                  st.push(src);
              }
          }
    
      public void shortestPath(int src){
          int []distance =new int[V];
          boolean[] visited=new boolean[V];
           Stack<Integer> st=new Stack<Integer>();
           topologicalSort(src,visited,st);
           
           for(int i=0;i<V;i++)
            distance[i]=Integer.MAX_VALUE;
            
            distance[src]=0;
           
           while(!st.isEmpty()){
               int u=st.pop();
               
               Iterator<node> itr= adjList[u].listIterator();
               while(itr.hasNext()){
                   node n=itr.next();
               
               if(distance[u]!=Integer.MAX_VALUE && distance[u]+n.weight<distance[n.v])
                         distance[n.v]=distance[u]+n.weight;
               }
           }
           
           printShortestPath(distance);
      }
      
       public void printShortestPath(int [] distance){
           for(int i=0;i<V;i++)
             if(distance[i]!=Integer.MAX_VALUE)
              System.out.println(distance[i]);
       }
    
    public static void main(String[] args){
        Graph g=new Graph(6);
    g.addEdge(0, 1, 5);
    g.addEdge(0, 2, 3);
    g.addEdge(1, 3, 6);
    g.addEdge(1, 2, 2);
    g.addEdge(2, 4, 4);
    g.addEdge(2, 5, 2);
    g.addEdge(2, 3, 7);
    g.addEdge(3, 4, -1);
    g.addEdge(4, 5, -2);
    
       g.shortestPath(1);
    }
    
  }
