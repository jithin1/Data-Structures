/* Topological sorting for Directed Acyclic Graph (DAG) is a linear ordering of vertices such that for every directed edge uv, vertex u
    comes before v in the ordering Topological Sorting for a graph is not possible if the graph is not a DAG.
         a) Same as DFS code
         b) Use a stack
   */
   
   	void topologicalSort(int v, boolean visited[],Stack stack)
	{
          visited[v]=true;

         Iterator<Integer> it= adj[v].listIterator();
          while(it.hasNext()){
              int i= it.next();
               if(!visited[i])
               topologicalSort(i,visited,stack);
          }
          
          stack.push(v);
	}


	void topological()
	{
         boolean visited[] = new boolean[V];
         Stack<Integer> st = new Stack<Integer>();
         
         for(int i=0;i<V;i++){
             if(!visited[i])
             topologicalSort(i,visited,st);
         }
         
         while(!st.isEmpty()){
             System.out.print(st.pop()+" ");
         }
   }
