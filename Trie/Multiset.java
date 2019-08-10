   // https://codeforces.com/contest/706/problem/D
   
      import java.util.*;
      import java.io.*;
         
      public class Solution{
   
       
       public static void main (String[] args) throws java.lang.Exception
{
        	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	    PrintWriter out = new PrintWriter(System.out);
        	     int n = Integer.parseInt(br.readLine());
        	    Trie t = new Trie();
        	    t.insert(0);
        	     for(int i=0; i<n; i++){
        	    StringTokenizer st = new StringTokenizer(br.readLine());
        	       String c = st.nextToken();
        	       int val = Integer.parseInt(st.nextToken());
        	       if(c.equals("+"))  t.insert(val);
        	       else if(c.equals("-")) t.delete(val);
        	       else
        	       out.println(t.search(val));
        	    }
 
        	   out.close();
        }
   }
class Node{
         int count;
         LinkedList<Node> ch = new LinkedList();
          Node(){
        	  ch.add(null);
        	  ch.add(null);
          }
      }
      
      class Trie{
          Node root;
          Trie(){
              root = new Node();
          }
          
          public void insert(int val){
              Node cur = root;
              
              for(int i=31; i>=0; i--){
                  int key = (val & (1<<i)) >=1 ?1:0;
                  if(cur.ch.get(key) == null) cur.ch.set(key, new Node());
 
                   cur =cur.ch.get(key);
                   cur.count++;
              }
          }
          
           public void delete(int val){
              Node cur = root;
              
              for(int i=31; i>=0; i--){
                  int key = (val & (1<<i)) >=1 ?1:0;
                   cur = cur.ch.get(key);
                   cur.count--;
              }
          }
          
             public int search(int val){
              Node cur = root;
              int ans = 0;
              for(int i=31; i>=0; i--){
                  int key = (val & (1<<i)) >=1 ?1:0;
                   if( cur.ch.get(1-key) != null && cur.ch.get(1-key).count > 0){
                    ans|=(1<<i);
                    cur = cur.ch.get(1-key);
                   }
                   else cur = cur.ch.get(key);
              }
              return ans;
          }
      }
