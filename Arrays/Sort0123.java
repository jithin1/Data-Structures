import java.util.Arrays;

class Sort0123{
    
    public static void sort0123(int[] a){
      int n = a.length-1;
      int low = 0, mid1 =0;
      int mid2 = n, high = n;
      
      while(mid1 <= mid2){
          
          if(a[mid1] == 0){
              int temp = a[mid1];
              a[mid1] = a[low];
              a[low] = temp;
              low++;
              mid1++;
          }
          
          else if(a[mid1] == 1)
           mid1++;
           
           else if(a[mid1] == 2){
              int temp = a[mid1];
              a[mid1] = a[mid2];
              a[mid2] = temp;
              mid2--;
           }
      
           else{
               int temp = a[mid1];
              a[mid1] = a[high];
              a[high] = temp;
              
              if(high != mid2){
                temp = a[mid1];
              a[mid1] = a[mid2];
              a[mid2] = temp;
              }
              high--;
              mid2--;
              
           }
      }
      
          System.out.println(Arrays.toString(a));
    }
    
    public static void main(String[] args){
        int a[] = {1,1,2,3,2,0,0,1,2,0,1,1,2,3,0,0};
           sort0123(a);
        
    }
}
