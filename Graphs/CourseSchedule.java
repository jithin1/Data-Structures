/*
LeetCode : 207. Course Schedule

There are a total of n courses you have to take, labeled from 0 to n-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: 2, [[1,0]] 
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
*/

class Solution {    
    
    LinkedList<Integer> []adjl;
    boolean visited[];
    boolean parent[];
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
         
        adjl = new LinkedList[numCourses];
         for(int i=0 ; i<numCourses; i++)
             adjl[i] = new LinkedList();
        
        visited = new boolean[numCourses];
        parent = new boolean[numCourses];
        
        for(int i=0; i<prerequisites.length; i++)
            addEdge(prerequisites[i][0],prerequisites[i][1]);

          for(int i=0; i< numCourses; i++){
                 
            if(!visited[i])
               if(cycle(i))  // cycle found, if true
                   return false;
          }
        
          return true;
    }
    
    public boolean cycle(int v){
        
        if(parent[v])    // parent is visited before
            return true; 
        
        if(visited[v])   // visited previously in outer for loop
            return false;
        
        visited[v] = true;  
        parent[v] = true;
        
        Iterator<Integer> itr = adjl[v].listIterator();
        
        while(itr.hasNext())
        {
           int i = itr.next(); 
           
             if(cycle(i))    // if parent found before
                   return true;                 
        } 
        
          parent[v] = false;   // since we are going back put parent as false
          return false;
    }
    
    public void addEdge(int u, int v){
        adjl[u].add(v);
    }
    
}
