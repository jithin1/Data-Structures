/*

LeetCode 399. Evaluate Division

 Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number 
 (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

Example:
Given a / b = 2.0, b / c = 3.0.
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
return [6.0, 0.5, -1.0, 1.0, -1.0 ].

The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where
equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

According to the example above:

equations = [ ["a", "b"], ["b", "c"] ],
values = [2.0, 3.0],
queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 

The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction. 


*/

class GraphNode{   // to store the weight of edge and the neighbouring node
    String value;
    double weight;
    
    GraphNode(String value, double weight){
        this.value = value;
        this.weight = weight;
    }
}

class Solution {
    
     HashMap<String, ArrayList<GraphNode>> eqn = new HashMap();  

      int j=0;
    
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        
        double[] d = new double[queries.length];
        
        // Graph Creation
        for(int i=0; i<equations.length; i++){
            String u = equations[i][0];
            String v= equations[i][1];
            
            if(!eqn.containsKey(u))   // if does not exist in the graph create a new vertex
            {
                GraphNode g = new GraphNode(v,values[i]);
                ArrayList temp = new ArrayList();
                temp.add(g);
                eqn.put(u,temp);
            }
            
            else{  // use the existing vertex
                ArrayList temp = eqn.get(u);
                temp.add(new GraphNode(v,values[i]));
                eqn.put(u,temp);
            }
            
            if(!eqn.containsKey(v)){
                 GraphNode g = new GraphNode(u,1/values[i]);   // store reciprocal value
                ArrayList temp = new ArrayList();
                temp.add(g);
                eqn.put(v,temp); 
            }
            
                else{
                ArrayList temp = eqn.get(v);
                temp.add(new GraphNode(u,1/values[i]));  
                eqn.put(v,temp);
            }
                                                
        }
        
        for(int i=0; i< queries.length; i++){
            
               HashSet visited = new HashSet();
            
              String u = queries[i][0];                        
              String v = queries[i][1];
            
              if(!eqn.containsKey(u) || !eqn.containsKey(v))  // vertex not present in the graph, solution not known
                  d[j++] = -1.0;
                
              else
                 d[j++] = DFS(u,v,visited); 
        }
        
        return d;
    }       
        
      
    
      public double DFS(String src,String dest, HashSet visited){
          
          double result = 1.0;    
         
           visited.add(src);
          
          if(src.equals(dest))
              return 1.0;
          
          ArrayList<GraphNode> temp = eqn.get(src);
          
          for(GraphNode a : temp) {
              
                if(!visited.contains(a.value)){
                    double b= DFS(a.value,dest,visited);  
                    
                 if (b != -1.0){
                     result = a.weight*b;
                     return result;
                     } 
                    
                }
         }      
                  
                   visited.remove(src);
                   return -1.0;
     }             
    
}
