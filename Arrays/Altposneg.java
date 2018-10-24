  import java.util.Arrays;


    public class Alternate {


    public static void main(String[] args) {
        
        int[] a={1,2,-1,3,-7,-9,-4,-2,8,7,9,5,-6};
      alternate(a);
    }
    public static void alternate(int[] a){
        int n=a.length;
        int j=-1;
          for(int i=0;i<n;i++){     // to move all the negative numbers to the front and the positive numbers behind
             if(a[i]<0){
                 j++;
                 int temp=a[i];  // swap a[i] and a[j]
                 a[i]=a[j];
                 a[j]=temp;
             } 
          }
            int pos=j+1,neg=1;
            while(neg<n && pos<n && a[neg]<0){      //to alternate positives and negatives numbers
                int tmp=a[pos];
                a[pos]=a[neg];
                a[neg]=tmp;
                pos++;
                neg+=2;
            }
          System.out.println(Arrays.toString(a));
    }
  }
