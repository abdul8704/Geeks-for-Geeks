// Given an unsorted array arr[]. Rotate the array to the left (counter-clockwise direction) by d steps, where d is a positive integer. Do the mentioned change in the array in place.

// Note: Consider the array as circular.

// Examples :

// Input: arr[] = [1, 2, 3, 4, 5], d = 2
// Output: [3, 4, 5, 1, 2]
// Explanation: when rotated by 2 elements, it becomes 3 4 5 1 2.
// Input: arr[] = [2, 4, 6, 8, 10, 12, 14, 16, 18, 20], d = 3
// Output: [8, 10, 12, 14, 16, 18, 20, 2, 4, 6]
// Explanation: when rotated by 3 elements, it becomes 8 10 12 14 16 18 20 2 4 6.
// Input: arr[] = [7, 3, 9, 1], d = 9
// Output: [3, 9, 1, 7]
// Explanation: when we rotate 9 times, we'll get 3 9 1 7 as resultant array.
// Constraints:
// 1 <= arr.size(), d <= 105
// 0 <= arr[i] <= 105


class Solution1 { //constant space complexity solution

    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        int n = arr.length;

        // Edge case: If the array has only one element, no rotation is needed
        if (n <= 1) return;
        

        // Adjust d to ensure it falls within the valid range [0, n)
        d = d % n;
         // Convert negative rotations to equivalent positive rotations
        if (d < 0) d += n;
        
        reverseArray(arr, 0 , d - 1);
        reverseArray(arr, d, n - 1);
        reverseArray(arr, 0, n - 1);
    }
    private static void reverseArray(int arr[], int i, int j) {
        while (i <= j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
class Solution { // linear space complexity solution
    // Function to rotate an array by d elements in counter-clockwise direction.
    static void rotateArr(int arr[], int d) {
        int res[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            res[i] = arr[(i+d)%arr.length];
            
        }
        for(int i = 0; i< arr.length; i++){
            arr[i] = res[i];
        }
    }
}
