// Given an array arr[] where no two adjacent elements are same, find the index of a peak element. An element is considered to be a peak if it is greater than its adjacent elements (if they exist). If there are multiple peak elements, return index of any one of them. The output will be "true" if the index returned by your function is correct; otherwise, it will be "false".
// Note: Consider the element before the first element and the element after the last element to be negative infinity.

// Examples :
// Input: arr = [1, 2, 4, 5, 7, 8, 3]
// Output: true
// Explanation: arr[5] = 8 is a peak element because arr[4] < arr[5] > arr[6].

// Input: arr = [10, 20, 15, 2, 23, 90, 80]
// Output: true
// Explanation: arr[1] = 20 and arr[5] = 90 are peak elements because arr[0] < arr[1] > arr[2] and arr[4] < arr[5] > arr[6]. 

// Input: arr = [1, 2, 3]
// Output: true
// Explanation: arr[2] is a peak element because arr[1] < arr[2] and arr[2] is the last element, so it has negative infinity to its right.

// Constraints:
// 1 ≤ arr.size() ≤ 106
// -231 ≤ arr[i] ≤ 231 - 1

class Solution {
    public int peakElement(int[] arr) {
        int N = arr.length;
        int left = 1, right = N - 2;
        
        if(N == 1)  return 0;
        else if(arr[0] > arr[1])  return 0;
        else if(arr[N-1] > arr[N-2]) return N-1;
        
        while(left <= right){
            int mid = (right - left)/2 + left;
            
            if(arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1])
                return mid;
            else if(arr[mid] < arr[mid+1])
                left = mid + 1;
            else
                right = mid - 1;
        }
        
        return -1;
    }
}