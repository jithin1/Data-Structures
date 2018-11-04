/*
Maximum edges that can be added to DAG so that it remains DAG

    Do topological Sort and go for the below function
   */
       	    public void maximumEdgeAddtion(){
	        
	        boolean visited[]=new boolean[V];
	        Vector<Integer> topo=topologicalSort();
	          for(int i=0;i<topo.size();i++)
	          {
	              int t= topo.get(i);
	              for(int s:adj[t]){
	                visited[s]=true;
	              }
	              
	                for(int j=i+1;j<topo.size();j++){
	                    if(!visited[topo.get(j)])
	                     System.out.print(t+"->"+topo.get(j)+" ");
	                     
	                     visited[topo.get(j)]=false;
	                }
	          }
	    }
