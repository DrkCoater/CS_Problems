package us.csbu.cs546.sort;

//Java implementation of Counting Sort
//from Internet GeekbyGeek

class CountingSort
{
 void sort(int arr[])
 {
     int n = arr.length;

     // The output character array that will have sorted arr
     int output[] = new int[n];

     // Create a count array to store count of individual
     // number and initialize count array as 0
     int count[] = new int[256];
     
     for (int i=0; i<256; ++i)
         count[i] = 0;

     // store count of each character
     for (int i=0; i<n; ++i)
         ++count[arr[i]];

     // Change count[i] so that count[i] now contains actual
     // position of this character in output array
     for (int i=1; i<=255; ++i)
         count[i] += count[i-1];

     // Build the output character array
     for (int i = 0; i<n; ++i)
     {
         output[count[arr[i]]-1] = arr[i];
         --count[arr[i]];
     }

     // Copy the output array to arr, so that arr now
     // contains sorted characters
     for (int i = 0; i<n; ++i)
         arr[i] = output[i];
 }

 // Driver method
 public static void main(String args[])
 {
     CountingSort ob = new CountingSort();
     //use integer instead of char
     int arr[] = { 27, 22, 25, 33, 40, 26, 41, 50, 28, 19, 18, 22, 56};
     /*
     char arr[] = {'g', 'e', 'e', 'k', 's', 'f', 'o',
                   'r', 'g', 'e', 'e', 'k', 's'
                  };
*/
     ob.sort(arr);

     System.out.print("Sorted array is ");
     for (int i=0; i<arr.length; ++i)
         System.out.print(arr[i] + " ");
 }
}
/*This code is contributed by Rajat Mishra */
