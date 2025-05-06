// Given a square matrix mat[][] of size n x n. The task is to rotate it by 90 degrees in an anti-clockwise direction without using any extra space. 

// Examples:
// Input: mat[][] = [[1, 2, 3],
//                 [4, 5, 6]
//                 [7, 8, 9]]
// Output: Rotated Matrix:
// [3, 6, 9]
// [2, 5, 8]
// [1, 4, 7]

// Input: mat[][] = [[1, 2],
//                 [3, 4]]
// Output: Rotated Matrix:
// [2, 4]
// [1, 3]

// Constraints:
// 1 ≤ n ≤ 102
// 0 <= mat[i][j] <= 103

class Solution {
    static void rotateby90(int arr[][]) {
        int n = arr.length;
        reverse(arr, n);
        transpose(arr, n);   
    }
    private static void transpose(int arr[][], int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<i; j++){
                swap(arr, i, j, j, i);
            }
        }
    }
    private static void reverse(int arr[][], int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n/2; j++){
                swap(arr, i, j, i, n-j-1);
            }
        }
    }
    private static void swap(int[][] arr, int r1, int c1, int r2, int c2){
        int temp = arr[r1][c1];
        arr[r1][c1] = arr[r2][c2];
        arr[r2][c2] = temp;
    }
}