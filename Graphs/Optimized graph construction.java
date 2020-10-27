void solve() {
		int n = scn.nextInt(), m = scn.nextInt();
		int[] from = new int[m], to = new int[m];
		for(int i = 0; i < m; i++) {  // input edges
			from[i] = scn.nextInt() - 1;
			to[i] = scn.nextInt() - 1;
		}
		int[][] g = packU(n, from, to);
		System.out.println(Arrays.toString(from)+" "+Arrays.toString(to));
		for(int[] u: g)
		  System.out.println(Arrays.toString(u));

	}
	
          //undirected graph
	int[][] packU(int n, int[] from, int[] to) {  // Graph construction
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

//directed graph
private static int[][] construct(int n, int[] from, int[] to){
          int[][] g = new int[n+1][];
		int[] p = new int[n+1];
		for (int f : from)
			p[f]++;
		for (int i = 0; i <=n; i++)
			g[i] = new int[p[i]];
		for (int i = 0; i < from.length; i++) {
			g[from[i]][--p[from[i]]] = to[i];
		}
		return g;
     }
}
