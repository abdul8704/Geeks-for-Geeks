// Given an array of integers arr[]. Find the Inversion Count in the array.
// Two elements arr[i] and arr[j] form an inversion if arr[i] > arr[j] and i < j.

// Inversion Count: For an array, inversion count indicates how far (or close) the array is from being sorted. If the array is already sorted then the inversion count is 0.
// If an array is sorted in the reverse order then the inversion count is the maximum. 

// Examples:
// Input: arr[] = [2, 4, 1, 3, 5]
// Output: 3

// Explanation: The sequence 2, 4, 1, 3, 5 has three inversions (2, 1), (4, 1), (4, 3).
// Input: arr[] = [2, 3, 4, 5, 6]
// Output: 0
// Explanation: As the sequence is already sorted so there is no inversion count.

// Input: arr[] = [10, 10, 10]
// Output: 0
// Explanation: As all the elements of array are same, so there is no inversion count.

// Constraints:
// 1 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 104

class Solution {    
    static int c = 0;
    
    static int inversionCount(int arr[]) {
        c=0;
        partition(arr, 0, arr.length-1);
        return c;
    }
    
    private static void partition(int arr[], int i, int j){
        if(i >= j)
            return;
        
        int mid = (i + j) / 2;    
        
        partition(arr, i, mid);
        partition(arr, mid+1, j);
        
        mergesort(arr, i, mid, j); 
    }
    
    private static void mergesort(int arr[], int a, int mid, int b){
        int n1 = mid - a+1;
        int n2 = b - mid; 
        
        int a1[] = new int[n1];
        int a2[] = new int[n2];
        
        for(int i=0; i<n1; i++)
            a1[i] = arr[a+i];
        
        for(int j=0; j<n2; j++)
            a2[j] = arr[mid+1+j];
        
        int p1 =0, p2=0, ptr = a;
        
        while(p1 < n1 && p2 < n2){
            if(a1[p1] <= a2[p2]){
                arr[ptr] = a1[p1++];
            }
            else{
               
                arr[ptr] = a2[p2++];
                c+= (n1-p1);
                 
            }
            ptr++;
        }
        
        while(p1 < n1){
            arr[ptr++] = a1[p1++];
        }
        
        while(p2 < n2){
            //   c+= (n1-p2);
            arr[ptr++] = a2[p2++];
          
        }
    }
}