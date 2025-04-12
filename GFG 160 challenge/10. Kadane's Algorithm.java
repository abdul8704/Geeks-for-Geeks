// Given an integer array arr[]. You need to find the maximum sum of a subarray.

// Examples:

// Input: arr[] = [2, 3, -8, 7, -1, 2, 3]
// Output: 11

// Explanation: The subarray {7, -1, 2, 3} has the largest sum 11.

// Input: arr[] = [-2, -4]
// Output: -2

// Explanation: The subarray {-2} has the largest sum -2.

// Input: arr[] = [5, 4, 1, 7, 8]
// Output: 25

// Explanation: The subarray {5, 4, 1, 7, 8} has the largest sum 25.

// Constraints:
// 1 ≤ arr.size() ≤ 105
// -109 ≤ arr[i] ≤ 104
class Solution {
    int maxSubarraySum(int[] nums) {
        if(nums.length == 0) return nums[0];

        int max_sum = -100000001, current_sum = 0;

        for(int num : nums){
            current_sum += num;  
            max_sum = Math.max(max_sum, current_sum);            
            current_sum = Math.max(current_sum, 0);
        }
    return max_sum;
    }
}