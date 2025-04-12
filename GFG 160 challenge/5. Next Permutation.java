// Given an array of integers arr[] representing a permutation, implement the next permutation that rearranges the numbers into the lexicographically next greater permutation. If no such permutation exists, rearrange the numbers into the lowest possible order (i.e., sorted in ascending order). 

// Note - A permutation of an array of integers refers to a specific arrangement of its elements in a sequence or linear order.

// Examples:

// Input: arr = [2, 4, 1, 7, 5, 0]
// Output: [2, 4, 5, 0, 1, 7]
// Explanation: The next permutation of the given array is {2, 4, 5, 0, 1, 7}.
// Input: arr = [3, 2, 1]
// Output: [1, 2, 3]
// Explanation: As arr[] is the last permutation, the next permutation is the lowest one.
// Input: arr = [3, 4, 2, 5, 1]
// Output: [3, 4, 5, 1, 2]
// Explanation: The next permutation of the given array is {3, 4, 5, 1, 2}.
// Constraints:
// 1 ≤ arr.size() ≤ 105
// 1 ≤ arr[i] ≤ 105

class Solution {
    void nextPermutation(int[] arr) {
        int idx = -1, i = 0, j = 0;   //STEP 1: Find the break point

        for(i = arr.length - 2; i>=0; i--){     //always traverse from last to find the breakpoint.
            if (arr[i] < arr[i+1]){
                idx = i;
                break;
            }
        }

        if(idx == -1){        //if breakpoint doesnt exist, it means given permutation is the last.
            i = 0;
            j = arr.length - 1;
            while(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
            return;
        }
        
        for(i = arr.length - 1; i>idx ;i--){    //STEP 2: find the element thats just greater than arr[i]. Swap once u find it.
            if(arr[i] > arr[idx]){
                int temp = arr[i];
                arr[i] = arr[idx];
                arr[idx] = temp;
                break;
            }
        }

        int temp[] = new int[arr.length - 1 - idx]; //temp array to sort the remaining array.
        j = 0;

        for(i = idx + 1; i < arr.length; i++){
            temp[j++] = arr[i];
        }

        Arrays.sort(temp);

        j = 0;
        for(i = idx + 1; i<arr.length; i++){    //replace remaining array with sorted array.
            arr[i] = temp[j++]; 
        }
        return;
    }
}