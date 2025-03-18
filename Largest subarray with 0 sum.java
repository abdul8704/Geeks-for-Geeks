// Given an array arr containing both positive and negative integers, the task is to compute the length of the largest subarray that Shas a sum of 0.

// Examples:

// Input: arr[] = [15, -2, 2, -8, 1, 7, 10, 23]
// Output: 5
// Explanation: The largest subarray with a sum of 0 is [-2, 2, -8, 1, 7].

// Input: arr[] = [2, 10, 4]
// Output: 0
// Explanation: There is no subarray with a sum of 0.

// Input: arr[] = [1, 0, -4, 3, 1, 0]
// Output: 5
// Explanation: The subarray is [0, -4, 3, 1, 0].

// Constraints:
// 1 ≤ arr.size() ≤ 106
// −103 ≤ arr[i] ≤ 103, for each valid i

import java.util.HashMap;

class Solution {
    int maxLen(int arr[]) {
       HashMap<Integer, Integer> hash = new HashMap<>();
       int sum = 0, res = 0;
       
       for(int i=0; i<arr.length; i++){
           sum += arr[i];
           if(sum == 0)
                res = Math.max(res, i+1);
                
           if(hash.containsKey(sum)){
               res = Math.max(res, i - hash.get(sum));
           }
           else{
               hash.put(sum, i);
           }
       }
      return res;
    }
}