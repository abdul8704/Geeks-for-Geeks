// Given an array of integers arr[] in a circular fashion. Find the maximum subarray sum that we can get if we assume the array to be circular.

// Examples:

// Input: arr[] = [8, -8, 9, -9, 10, -11, 12]
// Output: 22

// Explanation: Starting from the last element of the array, i.e, 12, and moving in a circular fashion, we have max subarray as 12, 8, -8, 9, -9, 10, which gives maximum sum as 22.

// Input: arr[] = [10, -3, -4, 7, 6, 5, -4, -1]
// Output: 23

// Explanation: Maximum sum of the circular subarray is 23. The subarray is [7, 6, 5, -4, -1, 10].

// Input: arr[] = [-1, 40, -14, 7, 6, 5, -4, -1] 
// Output: 52

// Explanation: Circular Subarray [7, 6, 5, -4, -1, -1, 40] has the maximum sum, which is 52.

// Constraints:
// 1 <= arr.size() <= 105
// -104 <= arr[i] <= 104

class Solution {
    public int circularSubarraySum(int nums[]) {
        int sum = 0;     //find total sum of array

        int temp_min = 0, min_sub = 30001;  //finding max subarray(kadane's algo)
        int temp_max = 0, max_sub = -30001; //finding min subarray(kadane's algo)

        for(int num:nums){
            sum += num;

            temp_min += num;
            temp_max += num;

            min_sub = Math.min(min_sub, temp_min);
            max_sub = Math.max(max_sub, temp_max);

            temp_max = (temp_max < 0)? 0:temp_max;
            temp_min = (temp_min > 0)? 0:temp_min;
        }
        if(sum == min_sub){        // if this case is true, all elements in array in negative, so return the max element
            return max_sub;
        }
        return Math.max(sum - min_sub, max_sub);    //else compare bw max subarray and max sum without min subarray
    }
}
