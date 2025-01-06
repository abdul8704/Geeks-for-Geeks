// Given a sorted array, arr[] and a number target, you need to find the number of occurrences of target in arr[]. 

// Examples :

// Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 2
// Output: 4
// Explanation: target = 2 occurs 4 times in the given array so the output is 4.

// Input: arr[] = [1, 1, 2, 2, 2, 2, 3], target = 4
// Output: 0
// Explanation: target = 4 is not present in the given array so the output is 0.

// Input: arr[] = [8, 9, 10, 12, 12, 12], target = 12
// Output: 3
// Explanation: target = 12 occurs 3 times in the given array so the output is 3.

// Constraints:
// 1 ≤ arr.size() ≤ 106
// 1 ≤ arr[i] ≤ 106
// 1 ≤ target ≤ 106

class Solution {
    int countFreq(int[] arr, int target) {
        int left = 0, right = arr.length - 1, mid = 0;
        int lower_bound =0, upper_bound = 0;
        
        while(left <= right){                   //finding lower-bound
            mid = left + (right - left) / 2;
            if(arr[mid] >= target){
                right = mid - 1;
                lower_bound = mid;
            }
            else{
                left = mid + 1;
            }
        }
        if(arr[lower_bound] != target){
            return 0;
        }

        left = 0; right = arr.length - 1;
        while(left <= right){               //finding upper bound
             mid = left + (right - left) / 2;
             
            if(arr[mid] <= target){
                left = mid + 1;
                upper_bound = mid;
            }
            else{
                right = mid - 1;
            } 
        }
        return upper_bound - lower_bound + 1;
    }
}



class Solution1 {
    int countFreq(int[] arr, int target) {
        int left = 0, right = arr.length - 1, mid = 0;
        
        while(left <= right){
            mid = left + (right - left) / 2;
            if(arr[mid] == target){
                break;
            }
            else if (arr[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        if(arr[mid] == target){             //find mid and then linear search
            left = right = mid;
            while(left>=1 && arr[left-1] == target){
                left--;
            }
            while(right < arr.length-1 && arr[right+1] == target){
                right++;
            }
            return right - left + 1;
        }else{
            return 0;
        }
    }
}