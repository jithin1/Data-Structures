/*
LeetCode 310
For a undirected graph with tree characteristics, we can choose any node as the root. The result graph is then a rooted tree.
Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs). Given such a graph, write a function to 
find all the MHTs and return a list of their root labels.


Example 1 :

Input: n = 4, edges = [[1, 0], [1, 2], [1, 3]]

        0
        |
        1
       / \
      2   3 

Output: [1]

Example 2 :

Input: n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]

     0  1  2
      \ | /
        3
        |
        4
        |
        5 

Output: [3, 4]


*/

class Solution {
    LinkedList<Integer> []adjl;
    boolean visited[];
    int depth = Integer.MAX_VALUE;
    
    @SuppressWarnings("unchecked")
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<Integer>();
        
        result.add(depth);
        
        adjl = new LinkedList[n];
         for(int i=0 ; i<n; i++)
             adjl[i] = new LinkedList();
        
        visited = new boolean[n];
        
        for(int i=0; i<edges.length; i++)  // for filling the adjacency list
            addEdge(edges[i][0],edges[i][1]);
        
        
        for(int i=0; i<n; i++){
            
          int d = DFS(i,0);
          Arrays.fill(visited,false);
            
            if(d == -1)  // d is not valid as the depth of the current vertex exceeped the min depth found so far
                continue;
          
            if(d < depth)   // clear the array
            {
                    result.clear();
                    result.add(i);
                    depth = d;
            }
            
              else if( d == depth)
                result.add(i);
            
        }
        
        return result;
    }
    
    public int DFS(int v, int d){
            int depth = d; 
            int temp =0; // used as a delimiter
        
          if(d > this.depth)  // current depth > previous depths
              return -1;
              
            visited[v] = true;
            
              Iterator<Integer> itr = adjl[v].listIterator();
             while(itr.hasNext()){
                 int i = itr.next();
                 
                 if(!visited[i])
                   temp= DFS(i,d+1);
                 
                 if(temp == -1) // we need not dive further
                     return temp;
                 
                 depth = Math.max(depth,temp); // use the max height attained till now
             }
               return depth;
              
        }
    
    public void addEdge(int u, int v){
        adjl[u].add(v);
        adjl[v].add(u);
    }
}

Time complexity is O(n2) n is the number of vertices.
