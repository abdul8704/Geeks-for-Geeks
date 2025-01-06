// Given an array arr[] containing only 0s, 1s, and 2s. Sort the array in ascending order.

// Examples:

// Input: arr[] = [0, 1, 2, 0, 1, 2]
// Output: [0, 0, 1, 1, 2, 2]
// Explanation: 0s 1s and 2s are segregated into ascending order.

// Input: arr[] = [0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1]
// Output: [0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2]
// Explanation: 0s 1s and 2s are segregated into ascending order.

// Constraints:
// 1 <= arr.size() <= 106
// 0 <= arr[i] <= 2

class Solution {
    public void sort012(int[] arr) {
        int zero = 0, one = 0, two = arr.length - 1;
        
        while(one <= two){
            if(arr[one] == 0){
                swap(arr, one, zero);
                one++;
                zero++;
            }
            else if(arr[one] == 2){
                swap(arr, one, two);
                two--;
            }
            else{
                one++;
            }
        }
        return;
    }
    static void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
        return;
    }
}