// Find Kth Non Repeating character in a string


   import java.util.*;

         class KNonRepeating{
 
   public static void kNonRepeating(String s,int k){
          
        int[] ch=new int[128];
         int[] index= new int[128];
         
           for(int i=0;i<128;i++)
            index[i]=128;
         
         for(int i=0; i< s.length(); i++){
             char c= s.charAt(i);
             ch[c]++;
             
             if(ch[c]==1)
               index[c]=i;
               
              else if(ch[c]>1)
              index[c]=128;
         }
         
         Arrays.sort(index);
         
         if(index[k-1]==128)
          System.out.println("No such string");
          
          else
           System.out.println(s.charAt(index[k-1]));
    }
   
    public static void main(String[] args){
        String s="geeksforgeeks";
         kNonRepeating(s,3);
       }
 }
