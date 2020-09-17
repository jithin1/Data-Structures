import java.util.Arrays;

class Solution{
	private static int[] fromNode;
	private static int[] toNode;
	private static boolean[] visitedCentroids;
	private static int nextCentNode = 0;
	private static int root;
	private static int[] subTreeSums;
	private static int[][] g;
	
	private static void DFS(int u, int p) {
		subTreeSums[u] = 1;
		for(int v:g[u]) {
			if(visitedCentroids[v] || v == p) continue;
			DFS(v,u);
			subTreeSums[u]+=subTreeSums[v];
		}
	}
	
	private static int findCentroid(int u,int p,int n) {
		int heavierSubTree = 0;
		boolean isCentroid = true;
		for(int v:g[u]) {
			if(visitedCentroids[v] || v == p) continue;
			
			if(subTreeSums[v] > n/2) isCentroid = false;
			if(subTreeSums[heavierSubTree] < subTreeSums[v]) heavierSubTree = v;
		}
		
		isCentroid &= (n-subTreeSums[u] <= n/2);
		return (isCentroid) ? u :findCentroid(heavierSubTree,u,n);
	}
	
	private static int findCentroid(int u) {
		DFS(u,-1);
		int centroidNode = findCentroid(u,-1,subTreeSums[u]);
		visitedCentroids[centroidNode] = true;
		return centroidNode;
	}
	private static int decompose(int u) {
		int centroidNode = findCentroid(u);
		for(int v: g[centroidNode]) {
			if(visitedCentroids[v]) continue;
			int centroidSubTree = decompose(v);
			fromNode[nextCentNode] = centroidNode;
			toNode[nextCentNode++] = centroidSubTree;
		}
		return centroidNode;
	}
	
	public static void main(String[] args) {
		int n = 16;
        int[][] edges = getEdges();
        subTreeSums = new int[n+1];
        visitedCentroids = new boolean[n+1];
        fromNode = new int[n];
        toNode = new int[n];
        int m = n-1;
        
        int[] from = new int[m+1], to = new int[m+1];
        
		for(int i = 0; i < m; i++) {  // input edges
			from[i] = edges[i][0];
			to[i] =  edges[i][1];
		}
		
		 g = construct(n+1,from,to);
		 root = decompose(1);
		 
		 int[][] centroidTree = construct(n+1, fromNode, toNode);
		Arrays.stream(centroidTree).forEach(e->System.out.println(Arrays.toString(e)));
		 
	}
	
	
	private static int[][] construct(int n, int[] from, int[] to) {  // Graph construction
		int[][] g = new int[n][];
		int[] p = new int[n];
		for (int f : from)
			p[f]++;
		for (int t : to)
			p[t]++;
		for (int i = 0; i < n; i++)
			g[i] = new int[p[i]];
		for (int i = 0; i < from.length; i++) {
			g[from[i]][--p[from[i]]] = to[i];
			g[to[i]][--p[to[i]]] = from[i];
		}
		return g;
	}
	
	private static int[][] getEdges(){
		int[][] edges = { {1,4},
				          {2, 4}, 
				          {3, 4},
				          {4, 5},
				          {5, 6},
				          {6, 7},
				          {7, 8},
				          {7, 9},
				          {6, 10},
				          {10, 11},
				          {11, 12},
				          {11, 13},
				          {12, 14},
				          {13, 15},
				          {13, 16}};
       return edges;
	}
}
