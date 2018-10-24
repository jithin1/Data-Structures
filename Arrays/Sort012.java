  import java.io.*;
 
      class countzot {
 
    static void sort012(int a[], int arr_size)
    {
        int low = 0;
        int high = arr_size - 1;
        int mid = 0,temp=0;
        while (mid <= high)
        {
            if (a[mid] == 0)
            {
                temp   =  a[low];   
                a[low]  = a[mid];
                a[mid] = temp;
                low++;
                mid++;
            }
             else if (a[mid] == 1)
                mid++;
            
               else                     // mid == 3
                 {
                   temp = a[mid];
                  a[mid] = a[high];
                  a[high] = temp;
                  high--;
                 }
            }
        }
    }
 

    static void printArray(int arr[], int arr_size)
    {
        int i;
        for (i = 0; i < arr_size; i++)
            System.out.print(arr[i]+" ");
        System.out.println("");
    }


    public static void main (String[] args)
    {
        int arr[] = {0, 2, 1, 1, 1, 2, 1, 2, 0, 0, 0, 1,2,2};
        int arr_size = arr.length;
        sort012(arr, arr_size);
        System.out.println("Array after seggregation ");
        printArray(arr, arr_size);
    }

 }
