
   // Java programm to find the permutation of a string
   
   class Permutation{
    
    public static void permutate(char[] c,int l, int r){
        if(l==r){
            System.out.println(c); // prints the String one by one
            return;
        }
        
      for(int i=l;i<=r;i++){   
          swap(c,i,l);   // swap , fix the position
          permutate(c,l+1,r);  // permute from previous fixed position + 1
          swap(c,i,l);  swap back to original position
        }
      
    }
    
    public static void swap(char[] c,int i,int j){
        char ch=c[i];
        c[i]=c[j];
        c[j]=ch;
    }
    
    public static void main(String[] args){
        String s="abcd";
        char[] c= s.toCharArray();
        permutate(c,0,3);
      }
 }
 
 // Time complexity is O(n*n)
