# Given an array arr[] containing integers and an integer k, your task is to find the length of the longest subarray where the sum of its elements is equal to the given value k. If there is no subarray with sum equal to k, return 0.

# Examples:

# Input: arr[] = [10, 5, 2, 7, 1, -10], k = 15
# Output: 6
# Explanation: Subarrays with sum = 15 are [5, 2, 7, 1], [10, 5] and [10, 5, 2, 7, 1, -10]. The length of the longest subarray with a sum of 15 is 6.

# Input: arr[] = [-5, 8, -14, 2, 4, 12], k = -5
# Output: 5
# Explanation: Only subarray with sum = 15 is [-5, 8, -14, 2, 4] of length 5.

# Input: arr[] = [10, -10, 20, 30], k = 5
# Output: 0
# Explanation: No subarray with sum = 5 is present in arr[].

# Constraints:
# 1 ≤ arr.size() ≤ 105
# -104 ≤ arr[i] ≤ 104
# -109 ≤ k ≤ 109


class Solution:
    def longestSubarray(self, arr, k):  
        pre = {}
        sum = 0
        res = 0
        for i in range(len(arr)):
            sum += arr[i]
            
            if(sum == k):
                res = max(res, i+1)
            
            remaining = sum-k
            
            if remaining in pre:
                res = max(res, i - pre[remaining])
            
            if sum not in pre:
                pre[sum] = i
        return res        

