// A sorted array of distinct elements arr[] is rotated at some unknown point, the task is to find the minimum element in it. 

// Examples:
// Input: arr[] = [5, 6, 1, 2, 3, 4]
// Output: 1
// Explanation: 1 is the minimum element in the array.

// Input: arr[] = [3, 1, 2]
// Output: 1
// Explanation: Here 1 is the minimum element.

// Input: arr[] = [4, 2, 3]
// Output: 2
// Explanation: Here 2 is the minimum element.

// Constraints:
// 1 ≤ arr.size() ≤ 106
// 1 ≤ arr[i] ≤ 109

class Solution {
    public int findMin(int[] arr) {
        int left=0, right = arr.length-1;
        
        while(left < right){
            int mid = (right - left)/2 + left;
            
            if(arr[right] > arr[mid])
                right = mid;
            else
                left = mid+1;
        }
        
        return arr[right];
    }
}