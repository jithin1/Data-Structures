/* 
   Time complexity is O(n*n)
   Space complexity is O(1)
   
     // Longest Palindrome
     
     Fix the centre and expand the window in both direction.
 */
 
         
          class LongestPalindrome{
    
      public static void findPalindrome(String s){
          char [] c= s.toCharArray();
           int max_length=1;
            int n= c.length;
             int start=0;
             
          for(int i=1; i<n; i++){
            int low=i-1;
            int high=i;
            
                 // for even length Palindromes
              while(low>=0 && high<n && c[low]==c[high]){

                  if(high-low+1 > max_length){
                   max_length=high-low+1;
                   start=low;
                  }
                   low--;
                   high++;
              }
              
             low=i-1;
             high=i+1;
             
               // for odd length
              while(low>=0 && high<n && c[low]==c[high]){
                   if(high-low+1 > max_length){
                   max_length=high-low+1;
                    start=low;
                   }
                   low--;
                   high++;
              }
          }
          
             // substring method used 
           System.out.println(s.substring(start,start+max_length));
      }
    
    public static void main(String[] args){
        String s="abbbaaabbbaaa";
        findPalindrome(s);
       }
  }
