 

     import java.util.Arrays;

  public class QuickFind {

    public static void main(String[] args) {
        
        int[] a={1,2,3,4,5};
        int k=11;
      quickFind(a,k);
    }
    public static void quickFind(int[] a,int k){
        int n=a.length;
           k=k%n;  //to get the index of rotation
           int b[]=new int[n];
             b[0]=a[k];
             int j=1;
        for(int i=k+1;i<n;i++){
            b[j]=a[i];
            j++;
        }
            for(int i=0;i<k;i++){  // print remaining values of the array
                b[j]=a[i];
                j++;
            }
          System.out.println(Arrays.toString(b));
    }
 }

 Time Complexity O(n)
