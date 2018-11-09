/* java program to determine if a graph is bipartite or not

   LeetCode 785 : Is Graph Bipartite?
   Given an undirected graph, return true if and only if it is bipartite.

Recall that a graph is bipartite if we can split it's set of nodes into two independent subsets A and B such that every edge in the graph 
has one node in A and another node in B.

The graph is given in the following form: graph[i] is a list of indexes j for which the edge between nodes i and j exists.  Each node is an
integer between 0 and graph.length - 1.  There are no self edges or parallel edges: graph[i] does not contain i, and it doesn't contain 
any element twice.

Example 1:
Input: [[1,3], [0,2], [1,3], [0,2]]
Output: true
Explanation: 
The graph looks like this:
0----1
|    |
|    |
3----2
We can divide the vertices into two groups: {0, 2} and {1, 3}.

  */
   
  
  class Solution {
    LinkedList<Integer> adjl[];
     boolean[] visited;
    
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        
        adjl = new LinkedList[V];
         visited = new boolean[V];
        
        for(int i=0; i<V; i++)
         adjl[i] = new LinkedList();
        
        for(int i=0; i<graph.length; i++){
            for(int j=0; j<graph[i].length; j++)
                addEdge(i,graph[i][j]);
        }
        
        int[] colour = new int[V];
        Arrays.fill(colour,-1);
        
          for(int i=0; i<V; i++)
              if(!visited[i]){   
               colour[i] = 0;
                  
                  if(!DFS(i,colour)) // if we find the result of DFS with source vertex i, return false
                    return false;    
              } 
        
        return true;   // It is a bipartite graph
    }
    
    public boolean DFS(int v, int[] colour){
        visited[v] = true;
        Iterator<Integer> itr = adjl[v].listIterator();
        
        while(itr.hasNext()){
            int u = itr.next();
            
            if(colour[u] == -1){
                colour[u] = 1 - colour[v];
                
                if(!DFS(u,colour)) // found that graph is not bipartite in the children
                    return false;
            }
            
            else if(colour[u] == colour[v])
                return false;
        }
        
        return true;
    }
    
    public void addEdge(int u, int v){
       adjl[u].add(v);
        adjl[v].add(u);
    }
}
