// https://codeforces.com/contest/1136/problem/D
// Find which vertices can reach the end.
      import java.util.*;
      import java.io.*;
         
      
      public class Solution{
    	  public static void main (String[] args) throws java.lang.Exception
	{
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter out = new PrintWriter(System.out);
	    StringTokenizer st = new StringTokenizer(br.readLine());
	    
	    int n = Integer.parseInt(st.nextToken());
	    int m = Integer.parseInt(st.nextToken());
	    st = new StringTokenizer(br.readLine());
	    
	    int[] a = new int[n];
	    
	    for(int i=0; i<n; i++)
	     a[i] = Integer.parseInt(st.nextToken())-1;
	     
	     int[] us =new int[m];
	     int[] vs = new int[m];
	     int[] deg = new int[n];
	     
		for(int i = 0; i < m; i++) {
		    st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken())-1;
			int v = Integer.parseInt(st.nextToken())-1;
			deg[u]++;
			us[i] = u; vs[i] = v;
		}
		
		int[][] adj = new int[n][];
		for(int i = 0; i < n; i++) adj[i] = new int[deg[i]];
		for(int i = 0; i < m; i++) {
			int u = us[i];
			int v = vs[i];
			adj[u][--deg[u]] = v;
		}
		boolean[] reach = new boolean[n];
		reach[a[n-1]] = true;
		int alive =1;
		int ans = 0;
		
		for(int i=n-2; i>=0; i--){
		    int count = 0;
		    for(int v : adj[a[i]])
		        if(reach[v]) count++;
		         
		        if(count == alive)
		         ans++;
		         else{
		             alive++;
		             reach[a[i]] = true;
		         }
		}
		out.println(ans);
		out.close();
	}
}
      
      
