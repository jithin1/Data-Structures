/* Dijsktra's algorithm to find the shortest path in a graph


     public class ShortestPath{
    
       int V=9;
       
       
       public int getMinIndex(boolean[] spclSet, int[] distance){
           int min=Integer.MAX_VALUE,min_index=-1;
           for(int i=0;i<V;i++){
               if(!spclSet[i]&&distance[i]<=min){ // find the unvisited vertex with min distance
                   min=distance[i];
                   min_index=i;
               }
           }
           return min_index;
       }
       
    public void dijkstra(int graph[][],int src){
        
         boolean []spclSet = new boolean[V];
         int[] distance= new int[V];
         int parent[]=new int[V];
         
         for(int v=0;v<V;v++)
           distance[v]=Integer.MAX_VALUE;
          
           distance[src]=0;
          parent[src]=-1;
        
        for(int v=0;v<V-1;v++){  // visit v-1 vertices
               int u;
               
 
                 u = getMinIndex(spclSet,distance);
                  spclSet[u]=true;
            
                for(int i=0;i<V;i++){  // update distances of vertices.
                  if(!spclSet[i] && distance[u]!=Integer.MAX_VALUE && graph[u][i]!=0 && distance[i]>distance[u]+graph[u][i]){
                       distance[i]=distance[u]+graph[u][i];
                       parent[i]=u; // used to store the parent
                  }      
            
             }
        
         }
         
                  printSolution(distance,parent);
    
    }
    
          public void printSolution(int dist[],int[] parent)
    {
        System.out.println("Vertex   Distance from Source");
        for (int i = 0; i < V; i++){
            System.out.print(i+"  "+dist[i]+"  ");
             path(parent,i);
             System.out.println("");
        }
    }
    // to print path used
      public void path(int[] parent,int i){
          if(i==-1)
          return;
           path(parent,parent[i]);
           System.out.print(i+" ");
      }
    
    public static void main (String[] args)
    {
        
       int graph[][] = new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0},
                                  {4, 0, 8, 0, 0, 0, 0, 11, 0},
                                  {0, 8, 0, 7, 0, 4, 0, 0, 2},
                                  {0, 0, 7, 0, 9, 14, 0, 0, 0},
                                  {0, 0, 0, 9, 0, 10, 0, 0, 0},
                                  {0, 0, 4, 14, 10, 0, 2, 0, 0},
                                  {0, 0, 0, 0, 0, 2, 0, 1, 6},
                                  {8, 11, 0, 0, 0, 0, 1, 0, 7},
                                  {0, 0, 2, 0, 0, 0, 6, 7, 0}};
                                  
        ShortestPath t = new ShortestPath();
        t.dijkstra(graph, 0);
    }
}
