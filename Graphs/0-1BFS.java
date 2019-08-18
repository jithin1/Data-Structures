// Codeforces : https://codeforces.com/contest/1063/problem/B

    import java.util.*;
    import java.io.*;
     
    public class Solution{
    	static int ways = 0;
    	public static void main (String[] args) throws java.lang.Exception
    	{
    		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    		PrintWriter out = new PrintWriter(System.out);
    		
    		StringTokenizer st = new StringTokenizer(br.readLine());
    		int n = Integer.parseInt(st.nextToken());
    		int m = Integer.parseInt(st.nextToken());
    		
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken())-1;
    		int b = Integer.parseInt(st.nextToken())-1;
    		
    		st = new StringTokenizer(br.readLine());
    		int x = Integer.parseInt(st.nextToken());
    		int y = Integer.parseInt(st.nextToken());
    		
    		char[][] p = new char[n][m];
    		
    		for(int i=0; i<n; i++){
    		   String s = br.readLine();
    		   for(int j=0; j<m; j++)
    		    p[i][j] = s.charAt(j);
    		}
    		 
    		LinkedList<Cell> dequeue = new LinkedList();
    		dequeue.add(new Cell(a,b,x,y));
    		p[a][b] = '*';
    		ways++;
    		
    		findWays(n,m,p,dequeue);
    		out.println(ways);
    		out.close();
    	}
    	private static void findWays(int n, int m, char[][] p, LinkedList<Cell> dequeue) {	
    		
    		while(!dequeue.isEmpty()){
               Cell c = dequeue.poll();
               int i = c.i;
               int j = c.j;
               int x = c.x;
               int y = c.y;
               	
    		 if(i-1 >= 0 && p[i-1][j] !='*'){
    		 dequeue.addFirst(new Cell(i-1,j,x,y));
    		    p[i-1][j] = '*';
    			ways++;
    		 }
    		 
    		 if(i+1 < n && p[i+1][j] !='*'){
    			 dequeue.addFirst(new Cell(i+1,j,x,y));
    			p[i+1][j] = '*';
    			ways++;
    		 }
    		 if(x > 0 && j-1>=0 && p[i][j-1] !='*'){
    			dequeue.add(new Cell(i,j-1,x-1,y));
    			p[i][j-1] = '*';
    			ways++;
    		 }
    	   	 if(y > 0 && j+1<m && p[i][j+1] !='*'){
    			dequeue.add(new Cell(i,j+1,x,y-1));
    			p[i][j+1] = '*';
    			ways++;
    	   	  }
    	   }
    	}
    }
      class Cell{
    	 int i,j,x,y;
    	  Cell(int i,int j, int x, int y){
    		 this.i =i;
    		 this.j = j;
    		 this.x = x;
    		 this.y = y;
    	 }
     }
