import java.util.Arrays;

class ThreeSum{
    
    public static void threeSum(int[] a, int key){
        
        int p1=0,p2=1;
        int n = a.length;
        int p3 = n-1;
        
        while(p2 < p3){
            
            if(a[p1]+a[p2]+a[p3] > key){
               p3--;
             continue;
            } 
            
            while((a[p1]+a[p2]+a[p3] < key) && (p2<p3))
                 p2++;
            
             if(a[p1]+a[p2]+a[p3] == key){
                 System.out.println(p1+" "+p2+" "+p3);
                 return;
             }
             
             p2--;
             
             while( (p2 > p1-1) && a[p1]+a[p2]+a[p3] < key){
                 p1++;
             }  
          
        }
        
        System.out.println("Does not exist");
    }
    
    public static void main(String[] args){
        int a[] = {8,8,6,7,2,5};
        Arrays.sort(a);
        threeSum(a,21);
        
    }
}
