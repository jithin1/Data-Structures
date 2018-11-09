/* This algorithm is used to find whether a graph is strongly connected. 

The algorithm uses 
1) DFS to find if all vertices can be visited from a particular vertex
2) Reverse the edges by transposing the graph
3) Perform DFS again to check whether alll vertices can be reached from the previous vertex.

The time complexity of this algorithm is O(V+E)

*/

  import java.io.*;
   import java.util.*;
   import java.util.LinkedList;

    class Graph
  {
	private int V; // No. of vertices
	private LinkedList<Integer> adj[]; //Adjacency List

	//Constructor
	Graph(int v)
	{
		V = v;
		adj = new LinkedList[v];
		for (int i=0; i<v; ++i)
			adj[i] = new LinkedList();
	}

	//Function to add an edge into the graph
	void addEdge(int v,int w) { adj[v].add(w); }

	// A recursive function to print DFS starting from v
	void DFSUtil(int v,Boolean visited[])
	{
		visited[v] = true;

		int n;

		Iterator<Integer> i = adj[v].iterator();
		while (i.hasNext())
		{
			n = i.next();
			if (!visited[n])
				DFSUtil(n,visited);
		}
	}

	Graph getTranspose()
	{
		Graph g = new Graph(V);
		for (int v = 0; v < V; v++)
		{
			Iterator<Integer> i = adj[v].listIterator();
			while (i.hasNext())
				g.adj[i.next()].add(v);
		}
		return g;
	}


	Boolean isSC()
	{

		Boolean visited[] = new Boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		DFSUtil(0, visited);

		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				return false;

		// Step 3: Create a reversed graph
		Graph gr = getTranspose();

		for (int i = 0; i < V; i++)
			visited[i] = false;

		gr.DFSUtil(0, visited);


		for (int i = 0; i < V; i++)
			if (visited[i] == false)
				return false;

		return true;
	}

	public static void main(String args[])
	{
		// Create graphs given in the above diagrams
		Graph g1 = new Graph(5);
		g1.addEdge(0, 1);
		g1.addEdge(1, 2);
		g1.addEdge(2, 3);
		g1.addEdge(3, 0);
		g1.addEdge(2, 4);
		g1.addEdge(4, 2);
		if (g1.isSC())
			System.out.println("Yes");
		else
			System.out.println("No");

		Graph g2 = new Graph(4);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(2, 3);
		if (g2.isSC())
			System.out.println("Yes");
		else
			System.out.println("No");
	}
   }
