 /* Java progaram to implement chain hashing
  Hash function used  (Summation(s[i] *x power(i-1))modp) mod m
  m = bucked size
  p = 1000000007
  x = 263
 */

import java.util.LinkedList;
  import java.util.Scanner;
  
   class Hashing{
      LinkedList<String> ll[];
      private int p = 1000000007;
      private int x = 263;
      private int m;
      
    @SuppressWarnings("unchecked")
      Hashing(int m){
          this.m = m;
          ll = new LinkedList[m];
          
          for(int i=0 ; i<m; i++)
           ll[i] = new LinkedList<String>();

      }
       
          @SuppressWarnings("unchecked")
       public void tableInsert(int key, String value){
          LinkedList head = ll[key];
          
          if(!head.contains(value))
          head.addFirst(value);
          
          
       }
       
       public void getList(int k){
             LinkedList<String> head = ll[k];
 
              for(String s : head)
             System.out.print(s+" ");
             
             System.out.println();
       }
       
      public void hashFunction(String s){
         char[] ch = s.toCharArray();
         int result = 0;
         for (int i=0; i<s.length(); i++){
             result = result + ( (int)ch[i]*(int)Math.pow(x,i) ) %p ;
         }
          result = result%m;
       //   System.out.println(result);
          
          tableInsert(result,s);
      }
      
      public boolean search(String s){
          for(int i=0; i<m; i++){
              if(ll[i].contains(s))
              return true;
          }
          
          return false;
      }
      
      public void remove(String s){
          for(int i=0; i<m; i++){
              
              if(ll[i].contains(s))
                ll[i].remove(s);
                
          }
      }
      
  }
  
   public class Compute{
       
       public static void main(String[] args){
           Hashing h;
           Scanner sc = new Scanner(System.in);
           int m = sc.nextInt();
           h= new Hashing(m);
           
           int n= sc.nextInt();
           
           for(int i=0; i<= n; i++){
               String temp= sc.nextLine();
               String[] s = temp.split(" ");
               
               if(s[0].equalsIgnoreCase("add"))
                h.hashFunction(s[1]);
               
                else if(s[0].equalsIgnoreCase("check")){
                  //  System.out.println(s[1]);
                 h.getList(Integer.parseInt(s[1]));
                }
                
                else if(s[0].equalsIgnoreCase("find"))
                 System.out.println(h.search(s[1]));
                 
                 else if(s[0].equalsIgnoreCase("del"))
                 h.remove(s[1]);
           }
       }
   }
