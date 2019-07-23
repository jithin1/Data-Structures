/* Code forces

  You are given a graph with n nodes and m directed edges. One lowercase letter is assigned to each node. We define a path's value as 
  the number of the most frequently occurring letter. For example, if letters on a path are "abaca", then the value of that path is
  3

. Your task is find a path whose value is the largest.
Input

The first line contains two positive integers n,m
(1≤n,m≤300000), denoting that the graph has n nodes and m

directed edges.

The second line contains a string s
with only lowercase English letters. The i-th character is the letter assigned to the i

-th node.

Then m
lines follow. Each line contains two integers x,y (1≤x,y≤n), describing a directed edge from x to y. Note that x can be equal to y and 
there can be multiple edges between x and y

. Also the graph can be not connected.
Output

Output a single line with a single integer denoting the largest value. If the value can be arbitrarily large, output -1 instead.

 */
 
 import java.util.*;
import java.lang.*;
import java.io.*;
 
 
 public class Solution{     
public static int[][] construct(int n, int[] from, int[] to){
         int[][] g = new int[n][];
         
         int[] p =new int[n];
         for(int f:from)
          p[f]++;
          
          for(int i=0; i<n; i++)
           g[i] = new int[p[i]];
           
           for(int i=0; i<from.length; i++)
            g[from[i]][--p[from[i]]] = to[i];
            
            return g;
     }
     
    public static int[] topologicalSort(int[][] g, int[] indegree){
    	int n = g.length;
        int[] sort = new int[n];
 
         int a=0,b=0;
        for(int u=0; u<n; u++)
        	  if(indegree[u] == 0)
                sort[a++] = u;
            	
                while(b < a){
                    int u = sort[b];
                    b++;
                for(int v: g[u]){
                    indegree[v]--;
                    if(indegree[v] == 0){
                     sort[a++] = v;
                    }
                }
               	
            }
    
        for(int i=0; i<n;i++)
         if(indegree[i] != 0)
            return null;
            
            return sort;
    }
    
    public static int findMax(int[] sort, int[][] g,String s){
    	int ans = 0;
    	int n = g.length;
    	 int[][] dp = new int[n][26];
 
    	 for(int u : sort){   		
    		 int index = s.charAt(u)-'a';
    		
    		 dp[u][index]++;
    		 ans = Math.max(ans, dp[u][index]);
    		 
    		 for(int v: g[u]){
    			 
    			 for(int i=0; i<26; i++)
    				 dp[v][i] = Math.max(dp[v][i], dp[u][i]);    		
    		 }
    	 }
    	 return ans;
    }
 
     public static void main (String[] args)throws Exception {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	PrintWriter out = new PrintWriter(System.out);
	StringTokenizer st = new StringTokenizer(br.readLine());
	
	int n = Integer.parseInt(st.nextToken());
	int m = Integer.parseInt(st.nextToken());
	
	String a = br.readLine();
	int[] from = new int[m];
	int[] to = new int[m];
	int[] indegree = new int[n];
	
    for(int i=0; i<m; i++){
        st = new StringTokenizer(br.readLine());
        from[i] = Integer.parseInt(st.nextToken())-1;
        to[i] = Integer.parseInt(st.nextToken())-1;
        indegree[to[i]]++;
    }
    
 
    int[][] g = construct(n,from,to);
     int[] sort = topologicalSort(g,indegree);
     if(sort == null){
    	 out.println(-1);
    	 out.close();
    	 return;
     }
          
      out.println(findMax(sort,g,a));
      out.close();
  }
}
